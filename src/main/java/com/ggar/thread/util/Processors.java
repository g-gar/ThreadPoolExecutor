package com.ggar.thread.util;

import com.ggar.framework.model.Mapper;
import com.ggar.thread.model.Processor;
import com.ggar.thread.model.Task;

public class Processors {
	
	private static Mapper<Class<? extends Task>, Processor<Task, ?>> mapper = new Mapper<Class<? extends Task>, Processor<Task, ?>>() {};
	
	public static Processor register(Class<? extends Task<?>> key, Processor<Task, ?> processor) {
		return Processors.mapper.register(key, processor);
	}

	public static <T, E extends Task<T>, R extends Processor<E, T>> R findByTask(E task) {
		return (R) Processors.mapper.get(task.getClass());
	}
	
}
