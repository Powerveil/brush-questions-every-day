package com.power.net_1011;

import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 崔帅
 * @version 1.0
 */
public class UdpTranslateServer extends UdpEchoServer{
    public UdpTranslateServer(int port) throws SocketException {
        super(port);
    }

    @Override
    public String process(String request) {
        Map<String,String> map = new HashMap<>();
        map.put("小猫","cat");
        map.put("cat","小猫");
        map.put("小狗","dog");
        map.put("dog","小狗");
        map.put("老鼠","mouse");
        map.put("mouse","老鼠");
        return map.getOrDefault(request,"服务器中没有这个词");
    }

    public static void main(String[] args) throws IOException {
        UdpTranslateServer udpTranslateServer = new UdpTranslateServer(9090);
        udpTranslateServer.start();
    }
}
