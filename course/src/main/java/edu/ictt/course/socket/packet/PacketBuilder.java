package edu.ictt.course.socket.packet;

import org.tio.utils.json.Json;

import edu.ictt.course.common.FastJsonUtil;
import edu.ictt.course.socket.body.BaseBody;


public class PacketBuilder<T extends BaseBody> {
	/**
     * 消息类型，其值在Type中定义
     */
    private byte type;

    private T body;

    public PacketBuilder<T> setType(byte type) {
        this.type = type;
        return this;
    }

    public PacketBuilder<T> setBody(T body) {
        this.body = body;
        return this;
    }

    public BlockPacket build() {
        return new BlockPacket(type, FastJsonUtil.toJSONString(body));
    }
}
