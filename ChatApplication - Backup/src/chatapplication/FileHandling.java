package chatapplication;

import java.io.*;
import java.util.Arrays;

public class FileHandling {

    public static byte[] method(File file) throws IOException {

        FileInputStream fl = new FileInputStream(file);

        byte[] arr = new byte[(int) file.length()];

        fl.read(arr);

        fl.close();

        return arr;
    }

    public static void main(String args[]) throws FileNotFoundException, IOException {

        /*
        System.out.println("File Creattion");
        
        String server_path = System.getProperty("user.dir") + "/files/server_receive";
        String client_path = System.getProperty("user.dir") + "/files/client_receive";
        File server_receive = new File(server_path);
        File client_receive = new File(client_path);
        
        if (!server_receive.exists() || !client_receive.exists()) {
            
            server_receive.mkdirs();
            client_receive.mkdirs();
        }
        FileOutputStream fos = new FileOutputStream(client_path + "file.txt");
         */
        File path = new File("/home/rakib/Desktop/temp.txt");
        byte[] fileContentBytes = null;
        
        try (FileInputStream fis = new FileInputStream(path)) {

            fileContentBytes = new byte[(int) path.length()];

            fis.read(fileContentBytes);

            System.out.println(Arrays.toString(fileContentBytes));
        }
        int length = (int) path.length();
        
        File newFile = new File("/home/rakib/Desktop/rakib.txt");
        OutputStream os = new FileOutputStream(newFile);
        os.write(fileContentBytes);
        
        System.out.println("Length: " + length);
        
    }
}
