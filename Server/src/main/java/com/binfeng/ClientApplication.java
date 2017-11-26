package com.binfeng;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Created by bfYang on 2017/11/5
 */
public class ClientApplication extends AbstractApplication{
    public void run() throws Exception {
        try {
            Bootstrap b = new Bootstrap();
            b.group(bossGroup).channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(handler.newInstance());
                        }
                    });
            ChannelFuture future = b.connect("localhost", port).sync();
            Channel ch = future.channel();
            ch.writeAndFlush("kaixinjiuhao\r\n");
            ch.closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
        }
    }
}
