import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class ClientTwoWay {
    public static void main(String[] args) throws IOException {
        
        System.out.println("ClientTwoWay");
        
        Socket socket = new Socket("127.0.0.1", 5000);
        
        System.out.println("Client Port is: " + socket.getLocalPort());
        System.out.println("Client is connected!");
        
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader read = new BufferedReader(in);
        
        //Server D Start
        DataInputStream input = new DataInputStream(socket.getInputStream());
        //Server D End
        
        String str = "";
        while(!str.equals("Bye")){
            
            System.out.print("Enter: ");
            str = read.readLine();
            out.writeUTF(str);
            
            str = input.readUTF();
            System.out.println("Message From Server: " +str);
        }
        out.close();
        in.close();
        read.close();
    }
}
