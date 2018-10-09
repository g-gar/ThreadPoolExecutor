package com.ggar.thread;

import java.util.HashMap;
import java.util.Map;

public class Processors {
	
	private static Map<Class<? extends Task>, Processor<Task<?>, ?>> processors = new HashMap<Class<? extends Task>, Processor<Task<?>, ?>>();
	
	public static Boolean register(Class<? extends Task<?>> key, Processor processor) {
		return Processors.processors.put(key, processor) != null;
	}

	public static <T, E extends Task<T>, R extends Processor<E, T>> R findByTask(E task) {
		return (R) Processors.processors.get(task.getClass());
	}
	
}
