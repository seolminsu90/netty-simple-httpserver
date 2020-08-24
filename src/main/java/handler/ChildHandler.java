package handler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;

//@Sharable
public class ChildHandler extends ChannelInitializer<SocketChannel> {

    // �ڵ鷯�� ������ �ǿܷ� �߿��ϴ�?
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline p = ch.pipeline();
        p.addLast(new HttpRequestDecoder()); // Http ��
        p.addLast(new HttpResponseEncoder()); // Http ��

        p.addLast(new TestChannelRegisteredHandler());

        // p.addLast(new TestSimpleChannelInboundHandler()); // Byte Stream Test ��
        p.addLast(new TestCustomHttpServerHandler()); // Http ��

        p.addLast(new TestChannelReadComplete());

        p.addLast(new TestUserEventTriggered());
    }

}
