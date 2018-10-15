package com.ggar.framework.model;

public class Counter {
	private Integer counter;
	
	public Counter(Integer initial) {
		super();
		this.counter = initial;
	}

	public Integer get() {
		return this.counter;
	}
	
	public Integer increment() {
		return this.increment(1);
	}
	
	public Integer increment(Integer value) {
		this.counter += value;
		return counter;
	}
}
