package edu.ictt.course.socket.disruptor;

import com.lmax.disruptor.EventHandler;

import edu.ictt.course.ApplicationContextProvider;
import edu.ictt.course.socket.disruptor.base.BaseEvent;

public class DisruptorClientHandler implements EventHandler<BaseEvent>{

	@Override
    public void onEvent(BaseEvent baseEvent, long sequence, boolean endOfBatch) throws Exception {
        ApplicationContextProvider.getBean(DisruptorClientConsumer.class).receive(baseEvent);
    }
}
