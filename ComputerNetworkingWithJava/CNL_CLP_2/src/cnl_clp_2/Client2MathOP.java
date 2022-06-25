package cnl_clp_2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import static java.lang.System.exit;
import java.net.*;
import java.util.Scanner;

public class Client2MathOP {

    public static void main(String[] args) throws IOException {

        System.out.println("Client Side");
        System.out.println("-----------------------");

        Socket socket = new Socket("localhost", 5000);
        System.out.println("Client Connected! Client Port is: " + socket.getLocalPort());

        Thread mexp = new MathExp(socket);
        mexp.start();
    }
}

class MathExp extends Thread {

    Socket socket;

    MathExp(Socket socket) {

        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            
            while (true) {

                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                Scanner scn = new Scanner(System.in);

                System.out.print("Enter a expression (i.e: 10 + 20): ");

                String val1 = scn.next();

                if (val1.equals("ENDS")) {

                    System.out.println("ENDS");
                    System.out.println("Successfully client closed!");

                    exit(0);

                } else {

                    dos.write(Integer.parseInt(val1));
                }

                String operator = scn.next();
                dos.writeUTF(operator);

                String val2 = scn.next();
                dos.write(Integer.parseInt(val2));

                System.out.println("Value sent! Waiting for result...");
                System.out.println("Result: " + dis.readDouble());

            }

        } catch (IOException e) {

            System.out.println("Something went wrong!");
            exit(0);
        }

    }
}
