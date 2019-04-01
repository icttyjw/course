package edu.ictt.course.socket.server;



import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.ChannelContext;
import org.tio.core.GroupContext;
import org.tio.core.exception.AioDecodeException;
import org.tio.core.intf.Packet;
import org.tio.server.intf.ServerAioHandler;

import edu.ictt.course.ApplicationContextProvider;
import edu.ictt.course.socket.common.AbstractAioHandler;
import edu.ictt.course.socket.disruptor.base.BaseEvent;
import edu.ictt.course.socket.disruptor.base.MessageProducer;
import edu.ictt.course.socket.packet.BlockPacket;

/**
 * server端处理所有client请求的入口
 * @author wuweifeng wrote on 2018/3/12.
 */
public  class BlockServerAioHandler extends AbstractAioHandler  implements ServerAioHandler{

    /**
     * 自己是server，此处接收到客户端来的消息。这里是入口
     * @throws Exception 
     */
	Logger logger=LoggerFactory.getLogger(getClass());
    @Override
    public void handler(Packet packet, ChannelContext channelContext) throws Exception {
    	BlockPacket blockPacket = (BlockPacket) packet;
        logger.info(blockPacket.getBody().toString());
        //使用Disruptor来publish消息。所有收到的消息都进入Disruptor，同BlockClientAioHandler
       ApplicationContextProvider.getBean(MessageProducer.class).publish(new BaseEvent(blockPacket, channelContext));
    }

    

	

	
}
