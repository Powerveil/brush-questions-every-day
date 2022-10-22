package com.power.net_1013;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 崔帅
 * @version 1.0
 */
public class TcpTranslateServer extends TcpEchoServer{
    public TcpTranslateServer(int port) throws IOException {
        super(port);
    }

    @Override
    public String process(String request) {
        Map<String,String> map = new HashMap<>();
        map.put("cat","小猫");
        map.put("小猫","cat");
        map.put("dog","小狗");
        map.put("小狗","dog");

        return map.getOrDefault(request,"词典没有收录该词！");
    }

    public static void main(String[] args) throws IOException {
        TcpTranslateServer server = new TcpTranslateServer(9090);
        server.start();
    }
}
