package com.ggar.dev.threadpoolexecutor.executor;

import com.ggar.dev.threadpoolexecutor.pool.Pool;

public class GenericExecutor<A> implements Executor<A> {
	
	private ExecutorState state;
	private Pool<A> pool;
	private Thread runner;
	
	public GenericExecutor(Pool p) { 
		this.pool = p;
		this.runner = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (true) {
					try {
						Runnable r = (Runnable) pool.get();
						if (!r.equals(null)) {
							new Thread(r).run();
							Thread.sleep(1000);
						}
					} catch (Exception e) {
						
					}
				}
			}
		});
	}
	
	@Override
	public void start() throws Exception {
		this.runner.start();
		this.state = ExecutorState.RUNNING;
	}

	@Override
	public void stop() throws Exception {
		this.runner.stop();
		this.state = ExecutorState.STOPPED;
	}
	
	@Override
	public ExecutorState getState() {
		return state;
	}
	
}
