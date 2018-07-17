package com.mishadoff.counter.impl;

import com.mishadoff.counter.Counter;

public class SynchronizedCounter implements Counter {
	
	private long count = 0;

	@Override
	public synchronized void increment() {
		++count;
	}

	@Override
	public long getCounter() {
		return count;
	}

}
