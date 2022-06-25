
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.*;

public class HttpPost {
    
    public static void main(String args[]) throws IOException{
        
        URL url = new URL("https://jsonplaceholder.typicode.com/posts/");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        
        conn.setRequestMethod("POST");
        conn.setRequestProperty("User-Agent", "Chrome");
        
        conn.setDoOutput(true);
        
        String data = "UserID: 1000, Name: Rakib";
        OutputStream output = conn.getOutputStream();
        output.write(data.getBytes());
        output.flush();
        output.close();
        
        int responseCode = conn.getResponseCode();
        
        System.out.println("Response Code: " + responseCode);
        System.out.println("Response Message: " + conn.getResponseMessage());
        
        if(responseCode == HttpURLConnection.HTTP_CREATED){
            
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader read = new BufferedReader(in);
            
            StringBuffer response = new StringBuffer();
            
            String str = null;
            
            while((str = read.readLine()) != null){
                
                response.append(str);
            }
            System.out.println(response);
        
        } else {
            System.out.println("Post Method Not Worked");
        }
    }
}
