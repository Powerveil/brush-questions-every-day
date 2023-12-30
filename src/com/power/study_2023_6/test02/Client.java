//package com.power.study_2023_6.test02;
//
//import java.io.*;
//import java.net.Socket;
//
//public class Client {
//    private static final String SERVER_IP = "127.0.0.1";
//    private static final int SERVER_PORT = 8080;
//
//    public static void main(String[] args) {
//        try (Socket socket = new Socket(SERVER_IP, SERVER_PORT);
//             BufferedReader inputReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//             BufferedWriter outputWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//             BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
//
//            System.out.println("已连接到聊天室服务器");
//
//            // 接收服务器消息的线程
//            new Thread(() -> {
//                try {
//                    String receivedMessage;
//                    while ((receivedMessage = inputReader.readLine()) != null) {
//                        System.out.println(receivedMessage);
//                    }
//                } catch (IOException e) {
//                    System.out.println("与服务器断开连接: " + e.getMessage());
//                }
//            }).start();
//
//            // 发送消息给服务器
//            String message;
//            while ((message = consoleReader.readLine()) != null) {
//                outputWriter.write(message + "\n");
//                outputWriter.flush();
//            }
//        } catch (IOException e) {
//            System.out.println("连接服务器失败: " + e.getMessage());
//        }
//    }
//}