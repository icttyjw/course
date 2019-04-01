package edu.ictt.course.socket.disruptor;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.tio.utils.json.Json;



import cn.hutool.core.util.StrUtil;
import edu.ictt.course.socket.body.BaseBody;
import edu.ictt.course.socket.common.intf.AbstractBlockHandler;
import edu.ictt.course.socket.disruptor.base.BaseEvent;
import edu.ictt.course.socket.disruptor.base.MessageConsumer;
import edu.ictt.course.socket.packet.BlockPacket;

@Component
public class DisruptorClientConsumer implements MessageConsumer{

	private static Map<Byte, AbstractBlockHandler<?>> handlerMap = new HashMap<>();
    private Logger logger = LoggerFactory.getLogger(getClass());

    static {
    }

    @Override
    public void receive(BaseEvent baseEvent) throws Exception {
        BlockPacket blockPacket = baseEvent.getBlockPacket();
        Byte type = blockPacket.getType();
        AbstractBlockHandler<?> blockHandler = handlerMap.get(type);
        if (blockHandler == null) {
            return;
        }

        //消费消息
        BaseBody baseBody = Json.toBean(new String(blockPacket.getBody()), BaseBody.class);
        logger.info("收到来自于<" + baseBody.getAppId() + ">针对msg<>的回应");

        //String appId = baseBody.getAppId();
        //if (StrUtil.equals(AppId.value, appId)) {
            //是本机
            //return;
        //}

        blockHandler.handler(blockPacket, baseEvent.getChannelContext());
    }
}
