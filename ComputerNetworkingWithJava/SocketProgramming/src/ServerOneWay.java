
import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;

public class ServerOneWay {
    
    public static void main(String[] args) throws IOException {
        
        ServerSocket serverSocket = new ServerSocket(5000);
        
        System.out.println("Server Handshaking Port No: " +serverSocket.getLocalPort());
        System.out.println("Server is connecting...");
        System.out.println("Server is waiting for client");
        
        Socket socket = serverSocket.accept();
        
        System.out.println("Client Request is accepted at port no: " + socket.getPort());
        System.out.println("Server Communication Port no:" + socket.getLocalPort());
        
        DataInputStream input = new DataInputStream(socket.getInputStream());
        
        String str = "";
        while(!str.equals("Bye")){
            
            str = input.readUTF();
            System.out.println("Message: " +str);
        }
        input.close();
    }
}
