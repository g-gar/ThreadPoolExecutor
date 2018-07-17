package com.mishadoff.counter.impl;

import com.mishadoff.counter.Counter;

public class CounterImpl implements Counter {

	private long value = 0;
	
	@Override
	public void increment() {
		++value;
	}

	@Override
	public long getCounter() {
		return value;
	}

}
