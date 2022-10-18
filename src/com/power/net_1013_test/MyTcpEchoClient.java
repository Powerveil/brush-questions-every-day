package com.power.net_1013_test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author 崔帅
 * @version 1.0
 */
public class MyTcpEchoClient {
    private Socket socket = null;

    public MyTcpEchoClient(String serverIp, int serverPort) throws IOException {
        socket = new Socket(serverIp,serverPort);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()) {
            while (true) {
                System.out.print("-> ");
                String request = scanner.next();

                PrintWriter printWriter = new PrintWriter(outputStream);
                printWriter.println(request);
                printWriter.flush();

                Scanner respScanner = new Scanner(inputStream);
                String response = respScanner.next();
                System.out.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }




//        while (true) {
//            try (InputStream inputStream = socket.getInputStream();
//                 OutputStream outputStream = socket.getOutputStream()) {
//                System.out.print("-> ");
//
//                String request = scanner.next();
//
//                PrintWriter printWriter = new PrintWriter(outputStream);
//                printWriter.println(request);
//                printWriter.flush();
//
//                Scanner respScanner = new Scanner(inputStream);
//                String response = respScanner.next();
//                System.out.println(response);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }

    public static void main(String[] args) throws IOException {
        MyTcpEchoClient client = new MyTcpEchoClient("127.0.0.1", 9090);
        client.start();
    }
}
