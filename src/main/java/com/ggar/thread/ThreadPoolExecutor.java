package com.ggar.thread;

import org.apache.log4j.Logger;

import com.ggar.thread.model.Processor;
import com.ggar.thread.model.Task;
import com.ggar.thread.util.Processors;

public class ThreadPoolExecutor extends Thread {

	private final static Logger LOG = Logger.getLogger(ThreadPoolExecutor.class);
	private final ThreadPool pool;
	
	public ThreadPoolExecutor(ThreadPool pool) {
		this(Runtime.getRuntime().availableProcessors(), pool);
	}

	public ThreadPoolExecutor(Integer nThreads, ThreadPool pool) {
		this.pool = pool;
	}

	@Override
	public void run() {
		while (true) {
			Task<?> task = null;
			Processor<Task, ?> processor = null;

			if ((task = this.pool.pop()) != null) {

				if (((processor = Processors.findByTask(task)) != null)) {
					processor.execute(task);
				}
			}
		}

	}
}
