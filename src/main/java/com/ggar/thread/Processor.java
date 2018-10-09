package com.ggar.thread;

public interface Processor<E extends Task<?>, R> {
	
	R execute(E task);
	
}
