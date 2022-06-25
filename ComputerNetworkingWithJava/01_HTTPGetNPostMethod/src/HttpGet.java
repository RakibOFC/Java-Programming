import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class HttpGet {

    public static void main(String[] args) throws IOException {
        
        URL url = new URL("http://youtube.com/");
        
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        
        conn.setRequestMethod("GET");
        conn.setRequestProperty("User-Agent", "Chrome");
        
        int responseCode = conn.getResponseCode();
        
        System.out.println("Response Code: " + responseCode);
        System.out.println("Response Message: " + conn.getResponseMessage());
        
        if(responseCode == HttpURLConnection.HTTP_OK){
            
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader read = new BufferedReader(in);
            
            StringBuffer response = new StringBuffer();
            
            String str = null;
            
            while((str = read.readLine()) != null){
                
                response.append(str);
            }
            
            System.out.println(response);
        
        } else {
            
            System.out.println("Get Method Not Worked");
        }
    }
    
}