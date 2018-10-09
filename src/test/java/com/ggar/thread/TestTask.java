package com.ggar.thread;

public class TestTask implements Task<String> {
	
	private final String string;
	
	public TestTask(String string) {
		this.string = string;
	}

	@Override
	public String execute() {
		return this.string;
	}

}
