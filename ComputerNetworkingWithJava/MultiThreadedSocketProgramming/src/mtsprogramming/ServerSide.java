package mtsprogramming;

import java.io.*;
import static java.lang.System.exit;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class ServerSide {
    
        public static void main(String[] args) throws IOException {

            int clientCounter = 0, clientList[] = new int[8];
            
            ServerSocket serverSocket = new ServerSocket(5000);
            
            Date date = new Date();

            SimpleDateFormat formatter = new SimpleDateFormat("hh:mm");
            String time = formatter.format(date);
            
            System.out.println("Server Side");
            System.out.println("---------------------");
            System.out.println("Server Handshaking Port No: " +serverSocket.getLocalPort());
            
            while(clientCounter < 4){

                try{

                    Socket clientSocket = serverSocket.accept();
                    clientList[clientCounter++] = clientSocket.getPort();
                    System.out.println("Client " + clientCounter + " joins at " + clientSocket.getPort() + " at " + time + " pm");
                    
                    Thread thread2 = new ClientHandler(clientList, serverSocket, clientSocket);
                    thread2.start();
                    
                } catch (IOException ex){
                    
                    exit(0);
                }
            }
            
            System.out.println("Server Jam!");
            serverSocket.close();
            exit(0);
    }
}

class ClientHandler extends Thread{
    
    private final Socket clientSocket;
    private final ServerSocket serverSocket;
    int clientList[];
            
    public ClientHandler(int clientList[], ServerSocket serverSocket, Socket clientSocket){
        
        this.clientSocket = clientSocket;
        this.clientList = clientList;
        this.serverSocket = serverSocket;
    }
    @Override
    public void run(){
        
        int i;
        
        for(i = 0; i < 5; i++){
            
            if(clientList[i] == clientSocket.getPort()){
                
                break;
            }
        }
        
        while(true){
            
            try {
            
                DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
                String convert;
                
                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                
                String str = in.readUTF();
                System.out.println("Client "+ (i+1) + " Says: " + str);
                String str2 = in.readUTF();
                System.out.println("Client "+ (i+1) + " Says: " + str2);
                
                if(str.equals("BIDAI")){
                    
                    System.out.println("Server closed by client!");
                    serverSocket.close();
                    exit(0);
                }
                convert = str + str2;
                dos.writeUTF(convert.toUpperCase());
            
            } catch (IOException ex) {
                
                System.out.println("Something went wrong!");
                exit(0);
            }
        }
    }
}
