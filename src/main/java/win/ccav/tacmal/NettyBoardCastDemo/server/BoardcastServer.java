package win.ccav.tacmal.NettyBoardCastDemo.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import win.ccav.tacmal.NettyBoardCastDemo.server.initializer.BoardcastServerInitializer;
public class BoardcastServer {
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup boss=new NioEventLoopGroup();
        EventLoopGroup worker=new NioEventLoopGroup();
        try{
            ServerBootstrap bootstrap=new ServerBootstrap();
            bootstrap.group(boss,worker).channel(NioServerSocketChannel.class)
                    .childHandler(new BoardcastServerInitializer());
            ChannelFuture future=bootstrap.bind(10010).sync();
            future.channel().closeFuture().sync();
        }finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }
}
