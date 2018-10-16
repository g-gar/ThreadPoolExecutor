package com.ggar.thread.model.processor;

import com.ggar.thread.model.Processor;
import com.ggar.thread.model.Task;

public class PrintLnProcessor implements Processor<Task, Void> {

	@Override
	public Void execute(Task task) {
		String name = Thread.currentThread().getName();
		System.out.println(name + ": Executed task " + task + " with value: " + task.execute().toString());
		return null;
	}

}
