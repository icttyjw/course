package edu.ictt.course.socket.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.client.intf.ClientAioListener;
import org.tio.core.Tio;
import org.tio.core.ChannelContext;
import org.tio.core.intf.Packet;
import org.tio.utils.json.Json;

import edu.ictt.course.ApplicationContextProvider;
import edu.ictt.course.core.event.NodesConnectedEvent;




/**
 * 暂时没用上
 * client端对各个server连接的情况回调。</p>
 * 当某个server的心跳超时（2min）时，Aio会从group里remove掉该连接，需要在重新connect后重新加入group
 *
 */
public class BlockClientAioListener implements ClientAioListener {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onAfterConnected(ChannelContext channelContext, boolean isConnected, boolean isReconnect) throws Exception {
        if (isConnected) {
            logger.info("连接成功：server地址为-" + channelContext.getServerNode());
           // Tio.bindGroup(channelContext, Const.GROUP_NAME);
        } else {
            logger.info("连接失败：server地址为-" + channelContext.getServerNode());
        }
        ApplicationContextProvider.publishEvent(new NodesConnectedEvent(channelContext));
    }

    @Override
    public void onBeforeClose(ChannelContext channelContext, Throwable throwable, String s, boolean b) {
        logger.info("连接关闭：server地址为-" + channelContext.getServerNode());
        Tio.unbindGroup(channelContext);
    }

    @Override
    public void onAfterDecoded(ChannelContext channelContext, Packet packet, int i) throws Exception {

    }

    @Override
    public void onAfterReceivedBytes(ChannelContext channelContext, int i) throws Exception {

    }

    @Override
    public void onAfterSent(ChannelContext channelContext, Packet packet, boolean b) throws Exception {
    	logger.info("onAfterSent channelContext:{}, packet:{}, packetSize:{}",channelContext,Json.toJson(packet),b);
    }

    @Override
    public void onAfterHandled(ChannelContext channelContext, Packet packet, long l) throws Exception {
    	
    }

}
