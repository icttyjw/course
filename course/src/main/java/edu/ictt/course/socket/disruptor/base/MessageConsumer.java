package edu.ictt.course.socket.disruptor.base;

public interface MessageConsumer {

	void receive(BaseEvent baseEvent) throws Exception;
}
