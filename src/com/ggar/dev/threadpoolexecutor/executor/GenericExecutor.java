package com.ggar.dev.threadpoolexecutor.executor;

import com.ggar.dev.threadpoolexecutor.operation.Operation;
import com.ggar.dev.threadpoolexecutor.pool.Pool;

public class GenericExecutor<A> implements Executor<A> {
	
	private ExecutorState state;
	private Pool<A> pool;
	private Thread runner;
	
	public GenericExecutor() {
		setPool(null);
	};
	
	public GenericExecutor(Pool<A> p) { 
		setPool(p);
	}
	
	@Override
	public void start() throws Exception {
		if (!pool.equals(null)) {
			this.runner.start();
			this.state = ExecutorState.RUNNING;
		} else throw new Exception("Pool not found");
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

	@Override
	public void setPool(Pool p) {
		this.runner = setRunner(this.pool = p);
	}
	
	private Thread setRunner(Pool p) {
		return new Thread(new Runnable() {
					
					@Override
					public void run() {
						while (true) {
							try {
								A r = GenericExecutor.this.pool.get();
								if (r!= null && !r.equals(null)) {
									((Runnable) r).run();
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
				});
	}
}
