package com.ggar.thread.model;

import com.ggar.thread.util.Processors;

public abstract class ThreadPoolExecutorHandler<T, E extends Task<T>, R> implements Runnable {

	private final E task;
	
	public ThreadPoolExecutorHandler(E task) {
		this.task = task;
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
	
}
