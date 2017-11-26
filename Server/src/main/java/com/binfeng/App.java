package com.binfeng;

import com.binfeng.Handler.DiscardServerHandler;

/**
 * Hello world!
 */
public class App extends ServerApplication {

    public static void main(String[] args) throws Exception {
        App app = new App();
        app.init(8080, DiscardServerHandler.class);
        app.run();
    }
}
