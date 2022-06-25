package chatapplication;

import java.io.*;
import java.io.IOException;
import java.net.*;

public class TempClient {
    
    public static void main(String[] args) throws IOException {
        
        
        Socket sr = new Socket("localhost", 5000);
        
        DataInputStream dis = new DataInputStream(sr.getInputStream());
        
        File newFile = new File("/home/rakib/Desktop/rakib.txt");
        OutputStream os = new FileOutputStream(newFile);
        
        int length = dis.readInt();
        System.out.println("Length: " + length);
        byte[] fileContentBytes = new byte[length];
        
        dis.read(fileContentBytes);
        os.write(fileContentBytes);
    }
}
