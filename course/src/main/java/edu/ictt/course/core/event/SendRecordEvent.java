package edu.ictt.course.core.event;

import org.springframework.context.ApplicationEvent;

import edu.ictt.course.socket.body.RecordBody;

public class SendRecordEvent extends ApplicationEvent{

	public SendRecordEvent(RecordBody source) {
		super(source);
	}

}
