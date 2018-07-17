package com.ggar.dev.threadpoolexecutor.Singleton;

public abstract class Singleton<A, T> {
	
	protected static Singleton INSTANCE;
	
	public static Singleton getInstance() {
		return Singleton.INSTANCE;
	}
	
	protected abstract void configure();
	
	public abstract T du(A value);

}
