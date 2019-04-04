package win.ccav.tacmal.nettySocketDemo.server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
public class ServerSocketChannelHandler extends SimpleChannelInboundHandler<String> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String msg) throws Exception {
        log.info("recieve msg from {},msg is {}:",channelHandlerContext.channel().remoteAddress(),msg);
        channelHandlerContext.writeAndFlush("from server "+ UUID.randomUUID());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.error("exception caught ",cause);
        ctx.close();
    }
}
