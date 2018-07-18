package com.ggar.dev.test.threadpoolexecutor.fibonacci.implementations;

import java.math.BigInteger;

import com.ggar.dev.threadpoolexecutor.Singleton.Singleton;
import com.ggar.dev.threadpoolexecutor.operation.Operation;

public class FibonacciOperation implements Operation<Integer> {
	
	private Integer number;
	private Singleton<Integer, BigInteger> singleton;

	public FibonacciOperation(Integer number) {
		super();
		this.number = number;
		this.singleton = FibonacciSingleton.getInstance();
	}

	@Override
	public void run() {
		System.out.println(this.number + ": " + this.singleton.du(this.number));
	}

}
