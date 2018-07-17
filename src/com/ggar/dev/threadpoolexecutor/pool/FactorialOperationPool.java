package com.ggar.dev.threadpoolexecutor.pool;

import com.ggar.dev.threadpoolexecutor.operation.FactorialOperation;

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
