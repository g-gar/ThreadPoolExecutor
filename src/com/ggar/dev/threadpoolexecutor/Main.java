package com.ggar.dev.threadpoolexecutor;

import com.ggar.dev.threadpoolexecutor.Singleton.Singleton;
import com.ggar.dev.threadpoolexecutor.executor.Executor;
import com.ggar.dev.threadpoolexecutor.operation.Operation;
import com.ggar.dev.threadpoolexecutor.pool.Pool;

public abstract class Main {
	
	protected Singleton singleton;
	protected Pool<Operation<?>> pool;
	protected Executor executor;
	
	public Main(Singleton s, Pool<? extends Operation<?>> p, Executor e) {
		this.singleton = s;
		this.pool = (Pool<Operation<?>>) p;
		this.executor = e;
		
		this.executor.setPool(this.pool);
	}
	
	public abstract void run();
	
}
