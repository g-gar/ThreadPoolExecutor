package com.ggar.thread.model;

import java.util.HashMap;
import java.util.Map;

import com.ggar.framework.model.Event;
import com.ggar.framework.model.Eventable;

public class ThreadPoolExecutorHandlerListener implements Eventable {
	
	private final Map<String, Event> events;
	private Thread listener;
	
	public ThreadPoolExecutorHandlerListener() {
		this.events = new HashMap<String, Event>();
	}

	@Override
	public void on(String eventName, Event eventHandler) {
		this.events.put(eventName, eventHandler);
	}

	@Override
	public void emit(String eventName) {
		if (this.events.containsKey(eventName)) {
			Event event = this.events.get(eventName);
			event.execute();
		}
	}

	@Override
	public void listen() {
		this.listener = new Thread(new Runnable() {

			@Override public void run() {
				while (ThreadPoolExecutorHandlerListener.this.listener != null) {
					for (String eventName : ThreadPoolExecutorHandlerListener.this.events.keySet()) {
						ThreadPoolExecutorHandlerListener.this.emit(eventName);
					}
				}
			}
			
		});
		this.listener.start();
	}

	@Override
	public void disregard() {
		this.listener.stop();
	}

}
