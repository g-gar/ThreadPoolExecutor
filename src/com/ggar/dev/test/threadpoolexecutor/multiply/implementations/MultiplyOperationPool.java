package com.ggar.dev.test.threadpoolexecutor.multiply.implementations;

import com.ggar.dev.threadpoolexecutor.pool.Pool;

public class MultiplyOperationPool extends Pool<MultiplyOperation> {

	@Override
	public void add(MultiplyOperation a) {
		stack.push(a);
	}
	
	@Override
	public MultiplyOperation get() {
		return !stack.isEmpty() ? stack.remove(0) : null;
	}
}
