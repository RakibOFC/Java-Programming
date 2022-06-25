package cnl_clp_2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import static java.lang.System.exit;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client1TwoMSG {
    
    public static void main(String[] args) throws IOException {
        
        System.out.println("Client Side");
        System.out.println("-----------------------");
        
        Socket socket = new Socket("localhost", 5000);
        System.out.println("Client Connected! Client Port is: " + socket.getLocalPort());
        
        Thread send = new ClinetSend(socket);
        send.start();

        Thread receive = new ClinetReceive(socket);
        receive.start();
    }
}

class ClinetSend extends Thread{
    
    Socket socket;
    
    ClinetSend(Socket socket){
        
        this.socket = socket;
    }
    
    @Override
    public void run(){
        
        while(true){
            
            try{
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                Scanner scn = new Scanner(System.in);
                
                String str = scn.nextLine();
                dos.writeUTF(str);
                
            } catch (IOException e){
                
                System.out.println("Something went wrong!");
                exit(0);
            }
        }
    }
}

class ClinetReceive extends Thread{
    
    Socket socket;
    
    ClinetReceive(Socket socket){
        
        this.socket = socket;
    }
    
    @Override
    public void run(){
        
        try {

            DataInputStream dis = new DataInputStream(socket.getInputStream());

            try {
                
                System.out.println("New Sentance: " + dis.readUTF());
                System.out.println("Number of vowel: " + dis.read());
                System.out.println("Client Closed!");
                exit(0);
                
            } catch (EOFException eof){
                
                System.out.println("Something went wrong");
                exit(0);
            }

        } catch (IOException ex) {

            Logger.getLogger(ClinetSend.class.getName()).log(Level.SEVERE, null, ex);
            exit(0);
        }
    }
}