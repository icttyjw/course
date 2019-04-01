package edu.ictt.course.socket.disruptor;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import edu.ictt.course.socket.common.intf.AbstractBlockHandler;
import edu.ictt.course.socket.disruptor.base.BaseEvent;
import edu.ictt.course.socket.disruptor.base.MessageConsumer;
import edu.ictt.course.socket.packet.BlockPacket;

@Component
public class DisruptorServerConsumer implements MessageConsumer{

	 private static Map<Byte, AbstractBlockHandler<?>> handlerMap = new HashMap<>();
	 private Logger logger = LoggerFactory.getLogger(getClass());
	    static {
	    }

	    @Override
	    public void receive(BaseEvent baseEvent) throws Exception {
	    	logger.info("收到消息");
	        BlockPacket blockPacket = baseEvent.getBlockPacket();
	        logger.info(blockPacket.getBody().toString());
	        Byte type = blockPacket.getType();
	        AbstractBlockHandler<?> handler = handlerMap.get(type);
	        if (handler == null) {
	            return;
	        }
	        handler.handler(blockPacket, baseEvent.getChannelContext());
	    }
}
