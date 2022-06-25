
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import static java.lang.System.exit;
import java.net.Socket;
import java.util.Scanner;

public class ClientSide {
    
    public static void main(String args[]) throws IOException{
        
        System.out.println("Client Side");
        
        Socket clientSocket = new Socket("127.0.0.1", 5000);
        
        System.out.println("Connected! Client Port: " + clientSocket.getLocalPort());
        System.out.println("Port: " + clientSocket.getPort());
        
        DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
        DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
        Scanner scn = new Scanner(System.in);
        
        while(true){
            
            String write_message = scn.nextLine();
            dos.writeUTF(write_message);
            
            try{
                
                String read_message = dis.readUTF();
                System.out.println("Uppercase form Server: " + read_message);
                
            } catch (EOFException ex){
                
                System.out.println("Server Down, more than five client was connected!");
                exit(0);
            }
            
            if("Bye".equals(write_message)){
                
                clientSocket.close();
                System.out.println("Client " + clientSocket.getLocalPort() + " is Closed!");
                break;
            }
        }
    }
}
