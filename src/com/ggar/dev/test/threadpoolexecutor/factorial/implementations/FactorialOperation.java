package com.ggar.dev.test.threadpoolexecutor.factorial.implementations;

import java.math.BigInteger;
import java.util.Date;

import com.ggar.dev.threadpoolexecutor.Singleton.Singleton;
import com.ggar.dev.threadpoolexecutor.operation.Operation;

public class FactorialOperation implements Operation<Integer> {
	
	private Integer number;

	public FactorialOperation(int number) {
		this.number = number;
	}

	@Override
	public void run() {
		Singleton<Integer, Integer> singleton = FactorialSingleton.getInstance();
		long before = new Date().getTime();
		Object temp = singleton.du(this.number);
		long after = new Date().getTime();
		System.out.println(this.number + ": " + temp);
		System.out.println("Computed in " + (after-before) + "ms");
	}

}
