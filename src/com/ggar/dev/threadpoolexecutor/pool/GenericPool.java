package com.ggar.dev.threadpoolexecutor.pool;

public class GenericPool<A> extends Pool<A> {

	@Override
	public void add(A a) {
		stack.push(a);
	}

	@Override
	public A get() {
		return !stack.isEmpty() ? stack.remove(0) : null;
	}

}
