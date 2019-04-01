package edu.ictt.course.socket.client;


import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

import org.tio.client.intf.ClientAioHandler;
import org.tio.core.ChannelContext;
import org.tio.core.Tio;
import org.tio.core.exception.AioDecodeException;
import org.tio.core.intf.Packet;

import edu.ictt.course.ApplicationContextProvider;
import edu.ictt.course.common.Const;
import edu.ictt.course.common.FastJsonUtil;
import edu.ictt.course.socket.body.StateBody;
import edu.ictt.course.socket.common.AbstractAioHandler;
import edu.ictt.course.socket.disruptor.base.BaseEvent;
import edu.ictt.course.socket.disruptor.base.MessageProducer;
import edu.ictt.course.socket.packet.BlockPacket;
import edu.ictt.course.socket.packet.PacketType;

/**
 * 客户端handler分发处
 */
public class BlockClientAioHandler extends AbstractAioHandler implements ClientAioHandler {

    @Override
    public BlockPacket heartbeatPacket() {
        //心跳包的内容就是隔一段时间向别的节点获取一次下一步区块（带着自己的最新Block获取别人的next Block）
        //return NextBlockPacketBuilder.build();
    	StateBody sb=new StateBody();
		sb.setId("2");
		sb.setIp("223");
		sb.setName("sss");
		BlockPacket bs=new BlockPacket();
		bs.setType(PacketType.HEART_BEAT);
		try {
			bs.setBody(FastJsonUtil.toJSONString(sb).getBytes(Const.CHARSET));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }

    /**
     * 调用handler中的具体的方法
     * @throws Exception 
     */
    @Override
    public void handler(Packet packet, ChannelContext channelContext) throws Exception  {
    	BlockPacket blockPacket = (BlockPacket) packet;
       
        //使用Disruptor来publish消息。所有收到的消息都进入Disruptor，同BlockServerAioHandler
        ApplicationContextProvider.getBean(MessageProducer.class).publish(new BaseEvent(blockPacket, channelContext));
    }

	
}
