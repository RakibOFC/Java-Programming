package sendmessagesspecificclient;

import java.io.*;
import static java.lang.System.exit;
import java.net.*;
import java.util.*;

public class ServerSide {
    
        public static void main(String[] args) throws IOException {

            int clientCounter = 0, clientList[] = new int[8];
            
            ServerSocket serverSocket = new ServerSocket(5000);
            
            System.out.println("Server Side");
            System.out.println("---------------------");
            System.out.println("Server Handshaking Port No: " +serverSocket.getLocalPort());
            System.out.println("Server is waiting for client...");
            
            while(clientCounter < 6){

                try{

                    Socket clientSocket = serverSocket.accept();
                    System.out.println("Client is connected! Client Port: " +clientSocket.getPort());
                    clientList[clientCounter++] = clientSocket.getPort();
                    
                    Thread thread1 = new ServerSend(serverSocket, clientSocket);
                    thread1.start();
                    Thread thread2 = new ServerReceive(clientList, serverSocket, clientSocket);
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

class ServerSend extends Thread{
    
    private final Socket clientSocket;
    private final ServerSocket serverSocket;
    
    public ServerSend(ServerSocket serverSocket, Socket clientSocket){
        
        this.clientSocket = clientSocket;
        this.serverSocket = serverSocket;
    }
    
    @Override
    public void run(){
        
        while(true){
            
            try{
                
                DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
                int clientPort;
                String str;
                
                Scanner scn = new Scanner(System.in);
                str = scn.nextLine();
                
                System.out.print("Active Port: " + clientSocket.getPort() + " Enter Client Port: ");
                // System.out.println("Active Port List: " + clientSocket.);
                clientPort = scn.nextInt();
                
                if(clientPort == clientSocket.getPort()){
                    
                    dos.writeUTF(str);
                }
                
                if(str.equals("Exit") || str.equals("Bye")){
                    
                    System.out.println("Server Closed!");
                    serverSocket.close();
                    exit(0);
                }
                
            } catch (IOException e){
                
                System.out.println("Something went wrong!");
                exit(0);
            }
        }
    }
}

class ServerReceive extends Thread{
    
    private final Socket clientSocket;
    private final ServerSocket serverSocket;
    int clientList[];
            
    public ServerReceive(int clientList[], ServerSocket serverSocket, Socket clientSocket){
        
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
            
                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                String str = in.readUTF();
                System.out.println("Client "+ (i+1) + " Says: " + str);
                
                if(str.equals("Exit") || str.equals("Bye")){
                    
                    System.out.println("Server closed by client!");
                    serverSocket.close();
                    exit(0);
                }
            
            } catch (IOException ex) {
                
                System.out.println("Something went wrong!");
                exit(0);
            }
        }
    }
}
