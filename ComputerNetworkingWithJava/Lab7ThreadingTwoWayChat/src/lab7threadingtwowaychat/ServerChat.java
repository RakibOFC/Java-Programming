package lab7threadingtwowaychat;
/*
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
*/

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerChat {
    
        public static void main(String[] args) throws IOException {

            ServerSocket serverSocket = new ServerSocket(5000);

            System.out.println("Server Handshaking Port No: " +serverSocket.getLocalPort());
            System.out.println("Server is connecting...");
            System.out.println("Server is waiting for client");
            
            while(true){
                
                Socket socket = serverSocket.accept();
                System.out.println("Accepted!");

                Thread thread1 = new server_send(socket);
                thread1.start();
                Thread thread2 = new server_receive(socket);
                thread2.start();
            }
    }
}

class server_receive extends Thread{
    
    private Socket socket;
            
    public server_receive(Socket socket){
        
        this.socket = socket;
    }
    @Override
    public void run(){
        
        while(true){
            
            try {
                DataInputStream in = new DataInputStream(socket.getInputStream());
                String str = in.readUTF();
                System.out.println("Client Says: " + str);
            } catch (IOException ex) {

            }
        }
    }
}

class server_send extends Thread{
    
    private Socket socket;
    
    public server_send(Socket socket){
        
        this.socket = socket;
    }
    
    @Override
    public void run(){
        
        while(true){
            
            try{
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                String str;
                Scanner scn = new Scanner(System.in);
                //System.out.print("Enter message: ");
                str = scn.nextLine();
                dos.writeUTF(str);
                System.out.println("Sent");
                
            } catch (IOException e){
                
            }
        }
    }
}