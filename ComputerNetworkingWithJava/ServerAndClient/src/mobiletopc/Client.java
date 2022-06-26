package mobiletopc;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        
            Socket socket = new Socket("192.168.239.77", 2121); // 127.0.0.1 //192.168.239.77

            System.out.println("Client Port is: " + socket.getLocalPort());
            System.out.println("Client is connected!");

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            InputStreamReader in = new InputStreamReader(System.in);
            BufferedReader read = new BufferedReader(in);

            String str = "";
            while(!str.equals("Bye")){

                System.out.print("Enter message: ");
                str = read.readLine();
                out.writeUTF(str);
            }
            out.close();
            in.close();
            read.close();
    }
}
