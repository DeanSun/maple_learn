package com.netty.demo.writeandflush;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.nio.charset.StandardCharsets;

public class ResponseSampleEncoder extends MessageToByteEncoder<ResponseSample> {

    @Override
    protected void encode(ChannelHandlerContext ctx, ResponseSample msg, ByteBuf out) throws Exception {
        out.writeBytes(msg.getCode().getBytes(StandardCharsets.UTF_8));
        out.writeBytes(msg.getData().getBytes(StandardCharsets.UTF_8));
        out.writeLong(msg.getTimestamp());
    }
}
