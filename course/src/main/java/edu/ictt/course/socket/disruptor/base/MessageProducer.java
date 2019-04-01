package edu.ictt.course.socket.disruptor.base;

public interface MessageProducer {

	void publish(BaseEvent baseEvent);
}
