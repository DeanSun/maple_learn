package com.netty.demo.writeandflush;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.nio.charset.StandardCharsets;

public class RequestSampleHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String data = ((ByteBuf)msg).toString(CharsetUtil.UTF_8);
        ResponseSample response = new ResponseSample(data,"OK", System.currentTimeMillis());
        ctx.channel().writeAndFlush(response);
    }
}
