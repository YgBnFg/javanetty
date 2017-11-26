package com.binfeng.Handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * Created by bfYang on 2017/11/5
 */
public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        System.out.println("Connected");
        ctx.writeAndFlush(Unpooled.copiedBuffer("This msg form client", CharsetUtil.UTF_8));
    }

//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) {
//        ByteBuf inMsgBuf = (ByteBuf) msg;
//        System.out.println("Msg form server: " + inMsgBuf.toString(CharsetUtil.UTF_8));
//
//    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        System.out.println("Msg form server: " + byteBuf.toString(CharsetUtil.UTF_8));
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
