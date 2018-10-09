package com.ggar.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Test {

	public static void main(String[] args) {
		
		Processors.register(DoubleValueTask.class, new PrintLnProcessor());
		Processors.register(TestTask.class, new PrintLnProcessor());
		
		int num = Runtime.getRuntime().availableProcessors();
		System.out.println("ThreadPool size" + num);
		final ThreadPool pool = new ThreadPool();
		ThreadPoolExecutor executor = new ThreadPoolExecutor(num, pool);
		
		executor.start();
		
		final Counter counter = new Counter(0);
		Timer t = new Timer();
		TimerTask tt = new TimerTask() {
			
			@Override
			public void run() {
				Priority[] priorities = Priority.values();
				Random random = new Random();
				
				Task task = new DoubleValueTask(counter.get());
				Integer index = random.nextInt(priorities.length);
				
				pool.add(task, priorities[index]);
				System.out.println("Added task" + task + ", with priority [" + priorities[index] + "]");
				counter.increment();
			}
			
		};
		t.schedule(tt, 0, 1000);
	}
	
}
 class Counter {
	private Integer counter;
	
	public Counter(Integer initial) {
		super();
		this.counter = initial;
	}

	public Integer get() {
		return this.counter;
	}
	
	public Integer increment() {
		return this.increment(1);
	}
	
	public Integer increment(Integer value) {
		this.counter += value;
		return counter;
	}
}
