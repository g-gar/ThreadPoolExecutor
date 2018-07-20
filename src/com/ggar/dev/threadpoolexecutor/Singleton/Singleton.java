package com.ggar.dev.threadpoolexecutor.Singleton;

public abstract class Singleton<A, T> {
	
	protected static Singleton INSTANCE;
	
	public static Singleton getInstance() {
		return Singleton.INSTANCE;
	}
	
	protected void configure(Singleton singleton) {
		INSTANCE = singleton;
	}
	
	public abstract T du(A value);

}
