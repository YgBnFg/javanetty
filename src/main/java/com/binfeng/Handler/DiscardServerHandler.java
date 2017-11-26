package com.binfeng.Handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * Created by bfYang on 2017/11/5
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf inMsgBuf = (ByteBuf) msg;
        try {
            System.out.println(inMsgBuf.toString(io.netty.util.CharsetUtil.US_ASCII));
        } finally {
            ReferenceCountUtil.release(msg);
        }

        System.out.println("Yes, A new client in = " + ctx.name());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
