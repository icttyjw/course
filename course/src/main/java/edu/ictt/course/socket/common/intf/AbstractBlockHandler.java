package edu.ictt.course.socket.common.intf;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.core.ChannelContext;
import org.tio.utils.json.Json;

import edu.ictt.course.common.Const;
import edu.ictt.course.common.FastJsonUtil;
import edu.ictt.course.socket.body.BaseBody;
import edu.ictt.course.socket.packet.BlockPacket;

/**
 * 基础handler
 * @author tanyaowu
 * 2017年3月27日 下午9:56:16
 */
public abstract class AbstractBlockHandler<T extends BaseBody> implements HandlerInterface {

	private Logger logger=LoggerFactory.getLogger(getClass());
	public AbstractBlockHandler() {
	}

	public abstract Class<T> bodyClass();

	@Override
	public Object handler(BlockPacket packet, ChannelContext channelContext) throws Exception {
		String jsonStr;
		T bsBody = null;
		if (packet.getBody() != null) {
			jsonStr = new String(packet.getBody(), Const.CHARSET);
			bsBody = FastJsonUtil.toTBean(jsonStr, bodyClass());
			logger.info(jsonStr+bsBody.getClass());
		}
		return handler(packet, bsBody, channelContext);
	}

	/**
	 * 实际的handler处理
	 * @param packet packet
	 * @param bsBody 解析后的对象
	 * @param channelContext channelContext
	 * @return 用不上
	 * @throws Exception Exception
	 */
	public abstract Object handler(BlockPacket packet, T bsBody, ChannelContext channelContext) throws Exception;

}
