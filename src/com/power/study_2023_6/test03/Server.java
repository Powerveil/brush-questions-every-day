package com.power.study_2023_6.test03;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private List<Socket> clients;
    private BufferedWriter fileWriter;

    public Server() {
        clients = new ArrayList<>();
        try {
            fileWriter = new BufferedWriter(new FileWriter("chat_history.txt", true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("服务器已启动，正在监听端口 " + port + "...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("客户端已连接: " + clientSocket);

                clients.add(clientSocket);

                Thread clientThread = new Thread(new ClientHandler(clientSocket));
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class ClientHandler implements Runnable {
        private Socket clientSocket;
        private BufferedReader reader;

        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        public void run() {
            try {
                reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                while (true) {
                    String message = reader.readLine();
                    System.out.println("收到消息: " + message);

                    fileWriter.write(message);
                    fileWriter.newLine();
                    fileWriter.flush();

                    broadcastMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void broadcastMessage(String message) {
        for (Socket client : clients) {
            try {
                PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
                writer.println(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start(1234);
    }
}