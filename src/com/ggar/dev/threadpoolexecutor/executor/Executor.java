package com.ggar.dev.threadpoolexecutor.executor;

public interface Executor<A> {
	void start() throws Exception;
	void stop() throws Exception;
	ExecutorState getState();
}
