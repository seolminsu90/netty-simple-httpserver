package handler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;

//@Sharable
public class ChildHandler extends ChannelInitializer<SocketChannel> {

    // 핸들러의 순서가 의외로 중요하다?
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline p = ch.pipeline();
        p.addLast(new HttpRequestDecoder()); // Http 용
        p.addLast(new HttpResponseEncoder()); // Http 용

        p.addLast(new TestChannelRegisteredHandler());

        // p.addLast(new TestSimpleChannelInboundHandler()); // Byte Stream Test 용
        p.addLast(new TestCustomHttpServerHandler()); // Http 용

        p.addLast(new TestChannelReadComplete());

        p.addLast(new TestUserEventTriggered());
    }

}
