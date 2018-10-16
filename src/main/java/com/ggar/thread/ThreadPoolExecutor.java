package com.ggar.thread;

import org.apache.log4j.Logger;

import com.ggar.framework.model.Event;
import com.ggar.thread.model.Task;
import com.ggar.thread.model.ThreadPoolExecutorHandler;

public class ThreadPoolExecutor extends Thread {

	private final static Logger LOG = Logger.getLogger(ThreadPoolExecutor.class);
	private final ThreadPool pool;
	private Integer currentWorkers;
	private Integer maxWorkers;
	
	public ThreadPoolExecutor(ThreadPool pool) {
		this(Runtime.getRuntime().availableProcessors(), pool);
	}

	public ThreadPoolExecutor(Integer maxWorkers, ThreadPool pool) {
		this.pool = pool;
		this.currentWorkers = 0;
		this.maxWorkers = maxWorkers;
	}

	@Override
	public void run() {
		Task<?> task = null;
		Thread thread = null;
		while (this.maxWorkers > 0) {
			if (this.currentWorkers < this.maxWorkers) {
				if ((task = this.pool.pop()) != null) {
					this.currentWorkers++;
					final ThreadPoolExecutorHandler handler = new ThreadPoolExecutorHandler(task) {};
					handler.on("terminated", new Event() {
						@Override public void execute() {
							synchronized (ThreadPoolExecutor.this) {
								System.out.println(Thread.currentThread().getName() + ": Worker terminated, reassigning...");
								--ThreadPoolExecutor.this.currentWorkers;
								handler.disregard();
							}
						}
					});
					handler.listen();
					thread = new Thread(handler);
					thread.start();
				}
			}
		}

	}
}
