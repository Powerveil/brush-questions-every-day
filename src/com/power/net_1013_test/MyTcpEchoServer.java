package com.power.net_1013_test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 崔帅
 * @version 1.0
 */
public class MyTcpEchoServer {
    private ServerSocket listSocket = null;

    public MyTcpEchoServer(int port) throws IOException {
        listSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动!");
        ExecutorService service = Executors.newCachedThreadPool();
        while (true) {
            Socket socket = listSocket.accept();


            service.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        processConnection(socket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

        }
    }

    private void processConnection(Socket socket) throws IOException {
        System.out.printf("[%s:%d] 客户端上线!\n",socket.getInetAddress().toString(),socket.getPort());


        try (InputStream inputStream = socket.getInputStream();
                 OutputStream outputStream = socket.getOutputStream()) {
                while (true) {
                    Scanner scanner = new Scanner(inputStream);
                    if (!scanner.hasNext()) {
                        System.out.printf("[%s:%d] 客户端下线\n",socket.getInetAddress().toString(),socket.getPort());
                        break;
                    }

                    String request = scanner.next();

                    String response = process(request);


                    PrintWriter printWriter = new PrintWriter(outputStream);
                    printWriter.println(response);
                    printWriter.flush();

                    System.out.printf("[%s:%d] req: %s; resp: %s\n",socket.getInetAddress().toString(),socket.getPort(),
                            request, response);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                socket.close();
            }
    }

    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        MyTcpEchoServer server = new MyTcpEchoServer(9090);
        server.start();
    }
}
