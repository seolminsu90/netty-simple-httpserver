package handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class TestChannelRegisteredHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("TestHandler4 channelRegistered");
        ctx.fireUserEventTriggered("channelRegistered - fireUserEventTriggered call");
        super.channelReadComplete(ctx);
    }
}
