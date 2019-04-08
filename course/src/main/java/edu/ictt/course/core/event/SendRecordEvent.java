package edu.ictt.course.core.event;

import org.springframework.context.ApplicationEvent;

import edu.ictt.course.socket.body.RecordBody;

public class SendRecordEvent extends ApplicationEvent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1887260726288331978L;

	public SendRecordEvent(RecordBody source) {
		super(source);
	}

	public RecordBody getsource(){
		return (RecordBody)source;
	}
}
