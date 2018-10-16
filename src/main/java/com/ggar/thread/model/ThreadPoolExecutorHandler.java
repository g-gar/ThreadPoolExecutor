package com.ggar.thread.model;

import com.ggar.framework.model.Event;
import com.ggar.framework.model.Eventable;
import com.ggar.thread.util.Processors;

public abstract class ThreadPoolExecutorHandler<T, E extends Task<T>, R> implements Runnable, Eventable {

	private final E task;
	private ThreadPoolExecutorHandlerListener listener;
	
	public ThreadPoolExecutorHandler(E task) {
		this.task = task;
		this.listener = new ThreadPoolExecutorHandlerListener();
	}
	
	@Override
	public void run() {
		R result = null;
		
		try {
			Processor<E, R> processor = (Processor<E, R>) Processors.findByTask(this.task);
			result = (R) processor.execute(task);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void on(String eventName, Event eventHandler) {
		this.listener.on(eventName, eventHandler);
	}

	@Override
	public void emit(String eventName) {
		this.listener.emit(eventName);
	}

	@Override
	public void listen() {
		this.listener.listen();
	}

	@Override
	public void disregard() {
		this.listener.disregard();
	}	
	
}
