package com.ggar.thread;

public class PrintLnProcessor implements Processor<Task, Void> {

	@Override
	public Void execute(Task task) {
		System.out.println("Executed task " + task + " with value: " + task.execute().toString());
		return null;
	}

}
