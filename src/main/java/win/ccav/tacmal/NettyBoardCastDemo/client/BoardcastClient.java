package win.ccav.tacmal.NettyBoardCastDemo.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import win.ccav.tacmal.NettyBoardCastDemo.client.initializer.BoardcastClientInitializer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BoardcastClient {
    public static void main(String[] args) throws Exception {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap=new Bootstrap();
            bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class)
                    .handler(new BoardcastClientInitializer());
            Channel channel=bootstrap.connect("127.0.0.1",10010).sync().channel();
            BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
            while (true){
                channel.writeAndFlush(reader.readLine()+"\r\n");
            }
        } finally {
            eventLoopGroup.shutdownGracefully();
        }
    }
}
