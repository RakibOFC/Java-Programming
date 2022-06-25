package chatapplication;

import java.io.*;
import java.io.IOException;
import java.net.*;

public class TempServer {
    
    public static void main(String[] args) throws IOException {
        
        ServerSocket s = new ServerSocket(5000);
        Socket sr = s.accept();
        
        DataOutputStream dos = new DataOutputStream(sr.getOutputStream());
        
        File file = new File("/home/rakib/Desktop/temp.txt");
        byte[] fileContentBytes = null;
        
        int length;
        
        try (FileInputStream fis = new FileInputStream(file)) {

            fileContentBytes = new byte[(int) file.length()];
            
            length = (int) file.length();
            
            fis.read(fileContentBytes);
            dos.writeInt(length);
            dos.write(fileContentBytes);
        }
    }
}
