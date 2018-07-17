package com.ggar.dev.threadpoolexecutor.pool;

import java.util.Stack;

public abstract class Pool<A> {
	
	protected Stack<A> stack;
	
	public Pool() {
		this.stack = new Stack<A>();
	}
	
	public abstract void add(A a);
	public abstract A get();
}
