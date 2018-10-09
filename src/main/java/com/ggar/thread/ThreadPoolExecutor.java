package com.ggar.thread;

public class ThreadPoolExecutor extends Thread {

	private final Thread[] threads;
	private final ThreadPool pool;
	
	public ThreadPoolExecutor(Integer nThreads, ThreadPool pool) {
		//int numCores = Runtime.getRuntime().availableProcessors();
		this.threads = new Thread[nThreads];
		this.pool = pool;
	}

	@Override
	public void run() {
		System.out.println(1);
		synchronized(this) {
			System.out.println(2);
			while (true) {
				Task<?> task = null;
				Processor<Task, ?> processor = null;
				
				if ((task = this.pool.pop()) != null) {
					System.out.println(task);
					
					if (((processor = Processors.findByTask(task)) != null)) {
						System.out.println(processor);
					}
				}
				
				if (task != null && processor != null) {
					processor.execute(task);
				}
				pool.notify();
			}
		}
	}
	
}
