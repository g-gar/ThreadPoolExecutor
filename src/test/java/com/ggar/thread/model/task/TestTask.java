package com.ggar.thread.model.task;

import com.ggar.thread.model.Task;

public class TestTask implements Task<String> {
	
	private final String string;
	
	public TestTask(String string) {
		this.string = string;
	}

	public String execute() {
		return this.string;
	}

}
