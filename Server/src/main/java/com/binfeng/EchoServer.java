package com.binfeng;

import com.binfeng.Handler.EchoServerHandler;

/**
 * Created by bfYang on 2017/11/5
 */
public class EchoServer extends ServerApplication {
    public static void main(String[] args) throws Exception {
        EchoServer server = new EchoServer();
        server.init(8080, EchoServerHandler.class);
        server.run();
    }
}
