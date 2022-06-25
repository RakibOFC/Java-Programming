package chatapplication;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class ServerSide implements ActionListener {

    public static JFrame frame = new JFrame();
    public static JPanel top_panel;
    public static JTextArea receive_text_area, send_text_area; // text_area
    public static JTextField text_field;
    public static JButton choose_file_btn, send_btn;
    public static JLabel status;

    public static Socket clientSocket;
    public static ServerSocket serverSocket;
    public static DataInputStream dis;
    public static DataOutputStream dos;

    public static File fileToSend;
    public static int length;
    public static byte[] fileContentBytes = null;
    public static String fileName;

    public ServerSide() {

        // Top panel
        top_panel = new JPanel();
        top_panel.setLayout(null);
        top_panel.setBackground(new Color(32, 33, 36));
        top_panel.setBounds(0, 0, 400, 50);
        frame.add(top_panel);

        // Title
        JLabel title = new JLabel("Server Side");
        title.setFont(new Font("Ubuntu", Font.PLAIN, 24));
        title.setForeground(new Color(252, 252, 252));
        title.setBounds(135, 7, 200, 20);
        top_panel.add(title);

        // Status
        status = new JLabel("Connecting...");
        status.setFont(new Font("Ubuntu", Font.PLAIN, 13));
        status.setForeground(Color.RED);
        status.setBounds(135, 27, 200, 20);
        top_panel.add(status);

        // Text Area, where message will be store
        receive_text_area = new JTextArea(5, 20);
        receive_text_area.setFont(new Font("Ubuntu", Font.PLAIN, 18));
        receive_text_area.setBackground(new Color(52, 53, 54));
        receive_text_area.setForeground(new Color(226, 205, 150));
        receive_text_area.setBounds(5, 50, 195, 494);
        receive_text_area.setEditable(false);
        receive_text_area.setLineWrap(true);
        receive_text_area.setWrapStyleWord(true);
        
        frame.add(receive_text_area);
        send_text_area = new JTextArea(5, 20);
        send_text_area.setFont(new Font("Ubuntu", Font.PLAIN, 18));
        send_text_area.setBackground(new Color(52, 53, 54));
        send_text_area.setForeground(new Color(226, 205, 150));
        send_text_area.setBounds(205, 50, 190, 494);
        send_text_area.setEditable(false);
        send_text_area.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        send_text_area.setLineWrap(true);
        send_text_area.setWrapStyleWord(true);
        frame.add(send_text_area);

        // Text Field or Enter message
        text_field = new JTextField();
        text_field.setFont(new Font("Ubuntu", Font.PLAIN, 18));
        text_field.setBackground(new Color(200, 200, 200));
        text_field.setForeground(new Color(0, 0, 0));
        text_field.setBounds(50, 558, 245, 40);
        frame.add(text_field);

        // Choose file
        choose_file_btn = new JButton("a");
        choose_file_btn.setBounds(15, 566, 20, 20);
        choose_file_btn.setFont(new Font("Ubuntu", Font.PLAIN, 16));
        choose_file_btn.setBackground(new Color(200, 200, 200));
        choose_file_btn.addActionListener(e -> {

            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setDialogTitle("Choose a file to send");

            if (jFileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

                fileToSend = jFileChooser.getSelectedFile();
                text_field.setText("File: " + fileToSend.getName());
            }
        });
        frame.add(choose_file_btn);

        // Send Button
        send_btn = new JButton("Send");
        send_btn.setBounds(305, 558, 80, 40);
        send_btn.setFont(new Font("Ubuntu", Font.PLAIN, 18));
        send_btn.setBackground(new Color(4, 29, 7));
        send_btn.setForeground(new Color(240, 240, 240));
        send_btn.addActionListener(this);
        frame.add(send_btn);

        // Main Frame
        frame.getContentPane().setBackground(new Color(52, 53, 54));
        frame.setLayout(null);
        frame.setSize(400, 650);
        frame.setLocation(200, 80);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static String blank_message(String message){

        String blank_message = "";

        for(int i = 0; i < message.length(); i++){

            blank_message = blank_message + "  ";
        }

        return blank_message;
    }
    @Override
    public void actionPerformed(ActionEvent action_event) {

        String message_send = text_field.getText();
        send_text_area.setText(send_text_area.getText() + "\n" + message_send);
        receive_text_area.setText(receive_text_area.getText() + "\n" + blank_message(message_send));
        text_field.setText("");
        
        if (fileToSend != null) {
            
            File file = new File(fileToSend.getAbsolutePath());
            fileName = fileToSend.getName();
            
            try (FileInputStream fis = new FileInputStream(file)) {
                
                fileContentBytes = new byte[(int) file.length()];
                fis.read(fileContentBytes);
                length = (int) file.length();
                
                dos.writeUTF("this_is_a_file_##00");
                dos.writeUTF(fileName);
                dos.writeInt(length);
                dos.write(fileContentBytes);
                
            } catch (IOException ex) {

                System.out.println("Error: " + ex);
            }
            
            fileToSend = null;
            
        } else {
            
            try {
                
                dos.writeUTF(message_send);
                
            } catch (IOException ex) {

                System.out.println("Error: " + ex);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        new ServerSide();
        frame.setVisible(true);

        try {

            serverSocket = new ServerSocket(5000);

            System.out.println("Connectiong...");

            clientSocket = serverSocket.accept();
            System.out.println("Connected!");
            status.setText("Active Now");
            status.setForeground(Color.GREEN);

            dos = new DataOutputStream(clientSocket.getOutputStream());
            dis = new DataInputStream(clientSocket.getInputStream());

            while (true) {

                // Read message form client
                String message_receive = dis.readUTF();

                if (message_receive.equals("this_is_a_file_##00")) {

                    fileName = dis.readUTF();

                    String client_path_str = System.getProperty("user.dir") + "/files/server_receive";
                    File client_path = new File(client_path_str);

                    if (!client_path.exists()) {

                        client_path.mkdirs();
                    }

                    File newFile = new File(client_path_str + "/" + fileName);

                    if (newFile.createNewFile()) { }

                    OutputStream os = new FileOutputStream(newFile);

                    length = dis.readInt();
                    fileContentBytes = new byte[length];
                    dis.read(fileContentBytes);
                    os.write(fileContentBytes);
                    receive_text_area.setText(receive_text_area.getText() + "\nFile: " + fileName);
                    send_text_area.setText(send_text_area.getText() + "\n      " + blank_message(fileName));

                } else {
                    receive_text_area.setText(receive_text_area.getText() + "\n" + message_receive);
                    send_text_area.setText(send_text_area.getText() + "\n" + blank_message(message_receive));
                }
            }

        } catch (IOException e) {

            // If the client run first, the server will interact like a client
            try {

                clientSocket = new Socket("localhost", 5000);

                System.out.println("Client Connected!");
                status.setText("Active Now");
                status.setForeground(Color.GREEN);

                dos = new DataOutputStream(clientSocket.getOutputStream());
                dis = new DataInputStream(clientSocket.getInputStream());

                while (true) {

                    // Read message form client
                    String message_receive = dis.readUTF();

                    if (message_receive.equals("this_is_a_file_##00")) {

                        fileName = dis.readUTF();

                        String client_path_str = System.getProperty("user.dir") + "/files/server_receive";
                        File client_path = new File(client_path_str);

                        if (!client_path.exists()) {

                            client_path.mkdirs();
                        }

                        File newFile = new File(client_path_str + "/" + fileName);

                        if (newFile.createNewFile()) {

                            System.out.println("File created");
                        }

                        OutputStream os = new FileOutputStream(newFile);

                        length = dis.readInt();
                        fileContentBytes = new byte[length];
                        dis.read(fileContentBytes);
                        os.write(fileContentBytes);
                        receive_text_area.setText(receive_text_area.getText() + "\nFile: " + fileName);
                        send_text_area.setText(send_text_area.getText() + "\n      " + blank_message(fileName));

                    } else {

                        receive_text_area.setText(receive_text_area.getText() + "\n" + message_receive);
                        send_text_area.setText(send_text_area.getText() + "\n" + blank_message(message_receive));
                    }
                }

            } catch (IOException ex) {

                System.out.println("Error: " + ex);
            }
        }
    }

}
