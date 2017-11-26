package com.binfeng;

import com.binfeng.Handler.EchoClientHandler;

/**
 * Created by bfYang on 2017/11/5
 */
public class EchoClient extends ClientApplication {

    public static void main(String[] args) throws Exception {
        EchoClient client = new EchoClient();
        client.init(8080, EchoClientHandler.class);
        client.run();
    }
}
