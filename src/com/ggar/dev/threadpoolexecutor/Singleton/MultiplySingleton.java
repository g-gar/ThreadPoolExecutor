package com.ggar.dev.threadpoolexecutor.Singleton;

public class MultiplySingleton extends Singleton<Integer, Integer> {

	private Integer number;
	
	@Override
	protected void configure() {
		this.INSTANCE = this;
	}
	
	public void configure(Integer value) {
		this.number = value;
		this.configure();
	}

	@Override
	public Integer du(Integer value) {
		return this.number * value;
	}

}
