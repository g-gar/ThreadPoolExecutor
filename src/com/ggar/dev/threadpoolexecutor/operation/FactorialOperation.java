package com.ggar.dev.threadpoolexecutor.operation;

import com.ggar.dev.threadpoolexecutor.Singleton.FactorialSingleton;
import com.ggar.dev.threadpoolexecutor.Singleton.Singleton;

public class FactorialOperation implements Operation {
	
	private Integer number;

	public FactorialOperation(int number) {
		this.number = number;
	}

	@Override
	public void run() {
		Singleton<Integer, Integer> singleton = FactorialSingleton.getInstance();
		System.out.println(this.number + ": " + singleton.du(this.number));
	}

}
