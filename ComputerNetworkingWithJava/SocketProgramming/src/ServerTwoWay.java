
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class ServerTwoWay {
    
    public static void main(String[] args) throws IOException {
        
        System.out.println("ServerTwoWay");
        
        ServerSocket serverSocket = new ServerSocket(5000);
        
        System.out.println("Server Handshaking Port No: " +serverSocket.getLocalPort());
        System.out.println("Server is connecting...");
        System.out.println("Server is waiting for client");
        
        Socket socket = serverSocket.accept();
        
        System.out.println("Client Request is accepted at port no: " + socket.getPort());
        System.out.println("Server Communication Port no:" + socket.getLocalPort());
        
        DataInputStream input = new DataInputStream(socket.getInputStream());
        
        //Client DIB Start
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader read = new BufferedReader(in);
        //Client DIB End
        
        String str = "";
        while(!str.equals("Bye")){

            str = input.readUTF();
            System.out.println("Message From Client: " +str);
            
            //Client SSO Start
            System.out.print("Enter: ");
            str = read.readLine();
            out.writeUTF(str);
            //Client SSO End
            
        }
        input.close();
    }
}
