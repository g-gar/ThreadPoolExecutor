package com.ggar.dev.threadpoolexecutor.operation;

import com.ggar.dev.threadpoolexecutor.Singleton.MultiplySingleton;
import com.ggar.dev.threadpoolexecutor.Singleton.Singleton;

public class MultiplyOperation implements Operation<Integer> {
		
	private final Integer number;
	
	public MultiplyOperation(Integer n) { number = n; }

	@Override
	public void run() {
		Singleton<Integer, Integer> singleton = MultiplySingleton.getInstance();
		System.out.println(this.number + ": " + singleton.du(this.number));
	}
	
}