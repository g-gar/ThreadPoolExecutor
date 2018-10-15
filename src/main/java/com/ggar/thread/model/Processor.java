package com.ggar.thread.model;

public interface Processor<E extends Task<?>, R> {
	
	R execute(E task);
	
}
