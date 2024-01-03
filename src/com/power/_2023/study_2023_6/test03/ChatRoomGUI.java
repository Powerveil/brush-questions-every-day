package com.power._2023.study_2023_6.test03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class ChatRoomGUI extends JFrame {
    private JTextArea chatTextArea;
    private JTextField messageTextField;
    private JButton sendButton;

    private String serverAddress;
    private int serverPort;
    private BufferedWriter fileWriter;

    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;

    public ChatRoomGUI(String serverAddress, int serverPort) {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;

        setTitle("Chat Room");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        chatTextArea = new JTextArea();
        chatTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatTextArea);
        add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        messageTextField = new JTextField();
        inputPanel.add(messageTextField, BorderLayout.CENTER);
        sendButton = new JButton("Send");
        inputPanel.add(sendButton, BorderLayout.EAST);
        add(inputPanel, BorderLayout.SOUTH);

        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String message = messageTextField.getText();
                sendMessage(message);
                messageTextField.setText("");
            }
        });

        try {
            fileWriter = new BufferedWriter(new FileWriter("chat_history.txt", true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void connectToServer() {
        try {
            socket = new Socket(serverAddress, serverPort);
            System.out.println("已连接到服务器: " + socket);

            writer = new PrintWriter(socket.getOutputStream(), true);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Thread serverThread = new Thread(new ServerHandler());
            serverThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage(String message) {
        writer.println(message);

        try {
            fileWriter.write(message);
            fileWriter.newLine();
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayMessage(String message) {
        chatTextArea.append(message + "\n");
    }

    private class ServerHandler implements Runnable {
        public void run() {
            try {
                while (true) {
                    String message = reader.readLine();
                    displayMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ChatRoomGUI chatRoom = new ChatRoomGUI("localhost", 1234);
                chatRoom.setVisible(true);
                chatRoom.connectToServer();
            }
        });
    }
}