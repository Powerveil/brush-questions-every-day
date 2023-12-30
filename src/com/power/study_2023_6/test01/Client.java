package com.power.study_2023_6.test01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private String serverAddress;
    private int serverPort;
    private PrintWriter writer;

    public Client(String serverAddress, int serverPort) {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
    }

    public void start() {
        try {
            Socket socket = new Socket(serverAddress, serverPort);
            System.out.println("已连接到服务器: " + socket);
            
            writer = new PrintWriter(socket.getOutputStream());
            Thread serverThread = new Thread(new ServerHandler(socket));
            serverThread.start();
            
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String message = scanner.nextLine();
                writer.println(message);
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class ServerHandler implements Runnable {
        private Socket socket;
        private Scanner scanner;

        public ServerHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                scanner = new Scanner(socket.getInputStream());
                
                while (true) {
                    String message = scanner.nextLine();
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