package handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class TestChannelReadComplete extends ChannelInboundHandlerAdapter {

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("TestHandler3 channelReadComplete");
        ctx.fireUserEventTriggered("channelReadComplete - fireUserEventTriggered call");
        ctx.flush();
    }
}
