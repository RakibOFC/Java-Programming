package lab7threadingtwowaychat;

/*
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
*/

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientChat {
    
    public static void main(String[] args) throws IOException {
   
        Socket socket = new Socket("127.0.0.1", 5000);
        
        System.out.println("Client Port is: " + socket.getLocalPort());
        System.out.println("Client is connected!");
        
        Thread thread1 = new client_send(socket);
        thread1.start();
        Thread thread2 = new client_receive(socket);
        thread2.start();
    }
}

class client_receive extends Thread{
    
    private Socket socket;
            
    public client_receive(Socket socket){
        
        this.socket = socket;
    }
    @Override
    public void run(){
        
        while(true){
            try {
                DataInputStream in = new DataInputStream(socket.getInputStream());
                String str = in.readUTF();
                System.out.println("Server Says: " + str);
            } catch (IOException ex) {

            }
        }
    }
}

class client_send extends Thread{
    
    private Socket socket;
    
    public client_send(Socket socket){
        
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