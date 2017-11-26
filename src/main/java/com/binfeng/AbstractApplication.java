package com.binfeng;

import com.binfeng.Handler.DiscardServerHandler;
import com.binfeng.Handler.EchoServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by bfYang on 2017/11/5
 */
public abstract class AbstractApplication {
    EventLoopGroup bossGroup = new NioEventLoopGroup();

    EventLoopGroup workerGroup = new NioEventLoopGroup();

    Class<? extends ChannelInboundHandlerAdapter> handler;

    int port;

    public void init(int port, Class<? extends ChannelInboundHandlerAdapter> handler) {
        this.port = port;
        this.handler = handler;
    }

    public abstract void run() throws Exception;
}
