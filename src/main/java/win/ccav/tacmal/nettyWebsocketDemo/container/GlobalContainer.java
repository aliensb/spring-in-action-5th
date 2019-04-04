package win.ccav.tacmal.nettyWebsocketDemo.container;

import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GlobalContainer {

    /**
     * 第一个String 用于按业务类型来分组存放用户channel，如果管理上下线的用户都放在key为online_user的map中，
     * 第二个String 是用户的标示，如token,userid,用来将用户和channel绑定
     */
    private static final Map<String, Map<String, Channel>> channelMap = new ConcurrentHashMap<>();

    /**
     * 第一个String 用于按业务类型来分组存放用户channel,ChannelGroup用于存放一组用户，便于消息的批量推送
     */
    private static Map<String, ChannelGroup> channelGroupMap = new ConcurrentHashMap<>();
}
