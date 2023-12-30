//package com.power.study_2023_6.test02;
//
//import java.io.IOException;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.ArrayList;
//
//public class Server {
//    private static final int PORT = 8080;
//    private static List<ClientHandler> clients = new ArrayList<>();
//
//    public static void main(String[] args) {
//        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
//            System.out.println("服务器已启动，等待客户端连接...");
//
//            while (true) {
//                Socket clientSocket = serverSocket.accept();
//                ClientHandler clientHandler = new ClientHandler(clientSocket);
//                clients.add(clientHandler);
//                new Thread(clientHandler).start();
//            }
//        } catch (IOException e) {
//            System.out.println("服务器启动失败: " + e.getMessage());
//        }
//    }
//
//    public static void broadcastMessage(String message, ClientHandler sender) {
//        for (ClientHandler client : clients) {
//            if (client != sender) {
//                client.sendMessage(message);
//            }
//        }
//    }
//
//    public static void removeClient(ClientHandler clientHandler) {
//        clients.remove(clientHandler);
//    }
//}