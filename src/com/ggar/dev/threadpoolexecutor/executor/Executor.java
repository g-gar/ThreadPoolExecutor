package com.ggar.dev.threadpoolexecutor.executor;

import com.ggar.dev.threadpoolexecutor.pool.Pool;

public interface Executor<A> {
	void start() throws Exception;
	void stop() throws Exception;
	ExecutorState getState();
	
	void setPool(Pool p);
}
