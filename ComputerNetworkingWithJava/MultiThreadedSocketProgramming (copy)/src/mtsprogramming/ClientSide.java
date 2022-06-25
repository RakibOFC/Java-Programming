package mtsprogramming;

import java.io.*;
import static java.lang.System.exit;
import java.net.*;
import java.util.*;

public class ClientSide {
    
    public static void main(String[] args) throws IOException {
   
        Socket socket = new Socket("127.0.0.1", 5000);
        
        System.out.println("Client Side");
        System.out.println("---------------------");
        System.out.println("Client Port is: " + socket.getLocalPort());
        System.out.println("Client is connected!");
        
        Thread thread1 = new ClientSend(socket);
        thread1.start();
        Thread thread2 = new ClientReceive(socket);
        thread2.start();
    }
}

class ClientSend extends Thread{
    
    private final Socket socket;
    
    public ClientSend(Socket socket){
        
        this.socket = socket;
    }
    
    @Override
    public void run(){
        
        while(true){
            
            try{
                
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                String str;
                Scanner scn = new Scanner(System.in);
                str = scn.nextLine();
                dos.writeUTF(str);
                
            } catch (IOException e){
                
                System.out.println("Something went wrong!");
                exit(0);
            }
        }
    }
}

class ClientReceive extends Thread{
    
    private final Socket socket;
            
    public ClientReceive(Socket socket){
        
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
                
                System.out.println("Server Closed!");
                exit(0);
            }
        }
    }
}
