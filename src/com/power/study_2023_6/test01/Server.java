package com.power.study_2023_6.test01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Server {
    private List<PrintWriter> clients;

    public Server() {
        clients = new ArrayList<>();
    }

    public void start(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("服务器已启动，正在监听端口 " + port + "...");
            
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("客户端已连接: " + clientSocket);
                
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
                clients.add(writer);
                
                Thread clientThread = new Thread(new ClientHandler(clientSocket));
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class ClientHandler implements Runnable {
        private Socket clientSocket;
        private Scanner scanner;

        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        public void run() {
            try {
                scanner = new Scanner(clientSocket.getInputStream());
                
                while (true) {
                    String message = scanner.nextLine();
                    System.out.println("收到消息: " + message);
                    
                    broadcastMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void broadcastMessage(String message) {
        for (PrintWriter writer : clients) {
            writer.println(message);
            writer.flush();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start(1234);
    }
}