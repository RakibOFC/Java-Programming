package cnl_clp_2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import static java.lang.System.exit;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server2MathOP {

    public static void main(String[] args) throws IOException {

        System.out.println("Server Side");
        System.out.println("-----------------------");

        int clientCounter = 0;

        ServerSocket serverSocket = new ServerSocket(5000);

        System.out.println("Server is waiting for client...");

        while (true) {

            Socket clinetSocket = serverSocket.accept();
            System.out.println((++clientCounter) + " client is connected!");

            Thread mathOperation = new MathOperation(serverSocket, clinetSocket);
            mathOperation.start();
        }
    }
}

class MathOperation extends Thread {

    ServerSocket serverSocket;
    Socket clinetSocket;

    MathOperation(ServerSocket serverSocket, Socket clinetSocket) {

        this.serverSocket = serverSocket;
        this.clinetSocket = clinetSocket;
    }

    @Override
    public void run() {

        int val1 = 0, val2;
        double result;
        String operator = "";

        while (true) {
            try {

                DataOutputStream dos = new DataOutputStream(clinetSocket.getOutputStream());
                DataInputStream dis = new DataInputStream(clinetSocket.getInputStream());

                val1 = dis.read();
                
                try {
                    
                    operator = dis.readUTF();
                
                } catch(EOFException ex){
                    
                    System.out.println("Cancel!");
                    break;
                }
                val2 = dis.read();

                if (operator.equals("+")) {

                    operator = "sum";

                } else if (operator.equals("-")) {

                    operator = "sub";

                } else if (operator.equals("*")) {

                    operator = "mul";

                } else if (operator.equals("/")) {

                    operator = "div";
                    
                } else if (operator.equals("^")) {

                    operator = "exp";
                }

                System.out.println("Client sent a request to " + operator + " " + val1 + " and " + val2);

                switch (operator) {

                    case "sum":
                        result = val1 + val2;
                        System.out.println("Result Sent!");
                        dos.writeDouble(result);
                        break;

                    case "sub":
                        result = val1 - val2;
                        System.out.println("Result Sent!");
                        dos.writeDouble(result);
                        break;

                    case "mul":
                        result = val1 * val2;
                        System.out.println("Result Sent!");
                        dos.writeDouble(result);
                        break;

                    case "div":
                        result = val1 / val2;
                        System.out.println("Result Sent!");
                        dos.writeDouble(result);
                        break;
                    
                    case "exp":
                        
                        result = 1;
                        
                        for(int i = 1; i <= val2; i++){
                            
                            result = result * val1;
                        }
                        
                        System.out.println("Result Sent!");
                        dos.writeDouble(result);
                        break;

                    default:
                        System.out.println("Error! The client sent a bad request maybe.");
                        dos.writeUTF("null");
                        break;
                }

            } catch (IOException ex) {

                Logger.getLogger(ClinetSend.class.getName()).log(Level.SEVERE, null, ex);
                exit(0);
            }
        }
    }
}
