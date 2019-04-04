package win.ccav.tacmal.nettySocketDemo.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import win.ccav.tacmal.nettySocketDemo.client.initializer.ClientSocketChannelInitializer;

public class SocketClient {
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup eventExecutors=new NioEventLoopGroup();
        try{
            Bootstrap bootstrap=new Bootstrap();
            bootstrap.group(eventExecutors).channel(NioSocketChannel.class)
                    .handler(new ClientSocketChannelInitializer());
            ChannelFuture future=bootstrap.connect("127.0.0.1",10086).sync();
            future.channel().closeFuture().sync();
        }finally {
            eventExecutors.shutdownGracefully();
        }
    }
}
