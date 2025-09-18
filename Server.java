import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {
    private static JTextArea chatArea;
    private static JTextField inputField;
    private static PrintWriter output;
    private static String username;

    public static void main(String[] args) {
        username = login.getUsername("Client");

        JFrame frame = new JFrame("Client - " + username);
        chatArea = new JTextArea(20, 40);
        chatArea.setEditable(false);
        inputField = new JTextField(25);
        JButton sendButton = new JButton("Send");

        JPanel panel = new JPanel();
        panel.setBackground(new Color(230, 255, 250));
        panel.add(inputField);
        panel.add(sendButton);

        frame.add(new JScrollPane(chatArea), BorderLayout.CENTER);
        frame.add(panel, BorderLayout.SOUTH);
        frame.getContentPane().setBackground(new Color(224, 255, 255));
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        try {
            Socket socket = new Socket("localhost", 12345);
            chatArea.append("[" + time() + "] Connected to server.\n");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);

            sendButton.addActionListener(e -> sendMessage());
            inputField.addActionListener(e -> sendMessage());

            String message;
            while ((message = input.readLine()) != null) {
                chatArea.append("[" + time() + "] Server: " + message + "\n");
            }

            socket.close();
        } catch (IOException e) {
            chatArea.append("Connection error: " + e.getMessage() + "\n");
        }
    }

    private static void sendMessage() {
        String message = inputField.getText();
        if (!message.isEmpty()) {
            output.println(message);
            chatArea.append("[" + time() + "] You: " + message + " ✓\n");
            inputField.setText("");
        }
    }

    private static String time() {
        return new SimpleDateFormat("HH:mm").format(new Date());
    }
}import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {
    private static JTextArea chatArea;
    private static JTextField inputField;
    private static PrintWriter output;
    private static String username;

    public static void main(String[] args) {
        username = login.getUsername("Client");

        JFrame frame = new JFrame("Client - " + username);
        chatArea = new JTextArea(20, 40);
        chatArea.setEditable(false);
        inputField = new JTextField(25);
        JButton sendButton = new JButton("Send");

        JPanel panel = new JPanel();
        panel.setBackground(new Color(230, 255, 250));
        panel.add(inputField);
        panel.add(sendButton);

        frame.add(new JScrollPane(chatArea), BorderLayout.CENTER);
        frame.add(panel, BorderLayout.SOUTH);
        frame.getContentPane().setBackground(new Color(224, 255, 255));
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        try {
            Socket socket = new Socket("localhost", 12345);
            chatArea.append("[" + time() + "] Connected to server.\n");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);

            sendButton.addActionListener(e -> sendMessage());
            inputField.addActionListener(e -> sendMessage());

            String message;
            while ((message = input.readLine()) != null) {
                chatArea.append("[" + time() + "] Server: " + message + "\n");
            }

            socket.close();
        } catch (IOException e) {
            chatArea.append("Connection error: " + e.getMessage() + "\n");
        }
    }

    private static void sendMessage() {
        String message = inputField.getText();
        if (!message.isEmpty()) {
            output.println(message);
            chatArea.append("[" + time() + "] You: " + message + " ✓\n");
            inputField.setText("");
        }
    }

    private static String time() {
        return new SimpleDateFormat("HH:mm").format(new Date());
    }
}
