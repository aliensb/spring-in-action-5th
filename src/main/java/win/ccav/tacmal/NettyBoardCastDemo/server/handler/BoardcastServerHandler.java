package win.ccav.tacmal.NettyBoardCastDemo.server.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BoardcastServerHandler extends SimpleChannelInboundHandler<String> {

    private static ChannelGroup channelGroup=new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        log.info("recieve msg from {} msg is {}",ctx.channel().remoteAddress(),msg);
        ctx.writeAndFlush("server has got you msg \n");
        channelGroup.forEach(ch->{
            if(ch==ctx.channel()){
                ch.writeAndFlush("my msg "+msg+"\n");
            }else{
                ch.writeAndFlush(ctx.channel().remoteAddress()+"send a msg:"+msg+"\n");
            }
        });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.info("exceptionCaught",cause);
        ctx.close();
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        channelGroup.writeAndFlush("welcome user from :"+ctx.channel().remoteAddress()+"\n");
        channelGroup.add(ctx.channel());


    }


}
