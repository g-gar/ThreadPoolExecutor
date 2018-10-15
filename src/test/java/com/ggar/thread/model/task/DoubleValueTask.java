package com.ggar.thread.model.task;

import com.ggar.thread.model.Task;

public class DoubleValueTask implements Task<Integer> {
	
	private final Integer value;

	public DoubleValueTask(Integer value) {
		super();
		this.value = value;
	}

	@Override
	public Integer execute() {
		return this.value * 2;
	}

	@Override
	public String toString() {
		return "DoubleValueTask [ " + this.value + " ]";
	}

}
