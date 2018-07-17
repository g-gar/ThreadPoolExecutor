package com.ggar.dev.test.threadpoolexecutor.factorial.implementations;

import com.ggar.dev.threadpoolexecutor.pool.Pool;

public class FactorialOperationPool extends Pool<FactorialOperation> {

	@Override
	public void add(FactorialOperation a) {
		stack.push(a);
	}

	@Override
	public FactorialOperation get() {
		return !stack.isEmpty() ? stack.remove(0) : null;
	}

}
