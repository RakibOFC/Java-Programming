package autoclientclose;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import static java.lang.System.exit;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerSide {
    
    public static void main(String args[]) throws IOException{
        
        System.out.println("Server Side");

        int count = 0, client_indentify[] = new int[6];
        
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server Handshaking Port No: " +serverSocket.getLocalPort());
        System.out.println("Server is connecting...");
        
        while(count < 6){
                
            try{
                
                Socket socket = serverSocket.accept();
                System.out.println("New Client connected, Port: " + socket.getPort());
                client_indentify[count] = socket.getPort();

                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                DataInputStream dis = new DataInputStream(socket.getInputStream());

                Thread newThread = new ClientHandler(client_indentify, socket, dos, dis);
                newThread.start();

                count++;

                Thread keep_alive = new KeepAlive(serverSocket);
                keep_alive.start();
            
            } catch(IOException e){
                
                System.out.println("Connection Time Out!");
                exit(0);
            }
            
        }
        serverSocket.close();
        System.out.println("Server Down, more than five client was connected!");
        exit(0);
    }
    
}


class KeepAlive extends Thread {
    
    ServerSocket serverSocket;
    
    public KeepAlive(ServerSocket serverSocket){
        
        this.serverSocket = serverSocket;
        
    }

    @Override
    public void run(){
        
        try {
            
            Thread.sleep(10000);
            serverSocket.close();
            //exit(0);
            
        } catch (InterruptedException ex) {
            
            System.out.println("InterruptedException");
            Logger.getLogger(KeepAlive.class.getName()).log(Level.SEVERE, null, ex);
        
        } catch (IOException ex) {
            
            System.out.println("IOException");
            Logger.getLogger(KeepAlive.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class ClientHandler extends Thread{
    
    Socket socket;
    DataOutputStream dos;
    DataInputStream dis;
    int client_indentify[];
    
    public ClientHandler(int client_indentify[], Socket socket, DataOutputStream dos, DataInputStream dis){
        
        this.socket = socket;
        this.dos = dos;
        this.dis = dis;
        this.client_indentify = client_indentify;
    }
    
    @Override
    public void run(){
        int i;
        while(true){
            
            for(i = 0; i < 6; i++){
                
                if(client_indentify[i] == socket.getPort()){
                    
                    break;
                }
            }
            try{
                String client_message = dis.readUTF();
                System.out.println("Client Port " + (i+1) + " says: " + client_message);
                
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                
                dos.writeUTF(client_message.toUpperCase());
                
            } catch (IOException e){
                
            }
        }
    }
}
