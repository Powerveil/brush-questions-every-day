package com.power._2023.study_2023_6.test03;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private String serverAddress;
    private int serverPort;
    private BufferedWriter fileWriter;

    public Client(String serverAddress, int serverPort) {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
        try {
            fileWriter = new BufferedWriter(new FileWriter("chat_history.txt", true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            Socket socket = new Socket(serverAddress, serverPort);
            System.out.println("已连接到服务器: " + socket);

            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            Thread serverThread = new Thread(new ServerHandler(socket));
            serverThread.start();

            Scanner scanner = new Scanner(System.in);
            while (true) {
                String message = scanner.nextLine();
                writer.println(message);

                fileWriter.write(message);
                fileWriter.newLine();
                fileWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class ServerHandler implements Runnable {
        private Socket socket;
        private BufferedReader reader;

        public ServerHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                while (true) {
                    String message = reader.readLine();
                    System.out.println("收到消息: " + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Client client = new Client("localhost", 1234);
        client.start();
    }
}