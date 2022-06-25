package cnl_clp_2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import static java.lang.System.exit;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server1TwoMSG {

    public static void main(String[] args) throws IOException {

        System.out.println("Server Side");
        System.out.println("-----------------------");

        int clientCounter = 0;

        ServerSocket serverSocket = new ServerSocket(5000);

        System.out.println("Server is waiting for client...");

        while (clientCounter < 6) {

            Socket clinetSocket = serverSocket.accept();
            System.out.println((++clientCounter) + " client is connected!");

            Thread clientHandler = new ClientHandler(serverSocket, clinetSocket);
            clientHandler.start();
        }

        System.out.println("Server Jam!");
        exit(0);
    }
}

class ClientHandler extends Thread {

    ServerSocket serverSocket;
    Socket clinetSocket;

    ClientHandler(ServerSocket serverSocket, Socket clinetSocket) {

        this.serverSocket = serverSocket;
        this.clinetSocket = clinetSocket;
    }

    @Override
    public void run() {

        int vowel = 0;
        String message, messageClone;

        try {

            DataOutputStream dos = new DataOutputStream(clinetSocket.getOutputStream());
            DataInputStream dis = new DataInputStream(clinetSocket.getInputStream());

            message = dis.readUTF();
            messageClone = "";

            System.out.println("Client says: " + message);

            for (int i = 0, j = 0; i < message.length(); i++) {

                switch (message.charAt(i)) {

                    case 'A':
                    case 'a':
                        messageClone = messageClone + message.charAt(i);
                        j++;
                        vowel++;
                        break;

                    case 'E':
                    case 'e':
                        messageClone = messageClone + message.charAt(i);
                        j++;
                        vowel++;
                        break;

                    case 'I':
                    case 'i':
                        messageClone = messageClone + message.charAt(i);
                        j++;
                        vowel++;
                        break;

                    case 'O':
                    case 'o':
                        messageClone = messageClone + message.charAt(i);
                        j++;
                        vowel++;
                        break;

                    case 'U':
                    case 'u':
                        messageClone = messageClone + message.charAt(i);
                        j++;
                        vowel++;
                        break;

                    default:
                        break;
                }
            }

            dos.writeUTF(messageClone);
            dos.write(vowel);

            System.out.println("Client " + clinetSocket.getPort() + " closed!");

        } catch (IOException ex) {

            System.out.println("One client close!");
        }
    }
}
