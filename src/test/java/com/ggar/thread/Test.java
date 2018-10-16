package com.ggar.thread;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.ggar.framework.model.Counter;
import com.ggar.thread.model.Priority;
import com.ggar.thread.model.Task;
import com.ggar.thread.model.processor.PrintLnProcessor;
import com.ggar.thread.model.task.DoubleValueTask;
import com.ggar.thread.model.task.TestTask;
import com.ggar.thread.util.Processors;

public class Test {
	
	private final static Logger LOG = Logger.getLogger(Test.class);

	public static void main(String[] args) {
		
		BasicConfigurator.configure();
		
		Processors.register(DoubleValueTask.class, new PrintLnProcessor());
		Processors.register(TestTask.class, new PrintLnProcessor());
		
		int num = Runtime.getRuntime().availableProcessors();
		LOG.debug("ThreadPool size " + num);
		final ThreadPool pool = new ThreadPool();
		ThreadPoolExecutor executor = new ThreadPoolExecutor(num, pool);
		
		final Counter counter = new Counter(0);		
		Thread another = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (counter) {
					while(counter.get() < 100) {
						Priority[] priorities = Priority.values();
						Random random = new Random();
						
						Task task = new DoubleValueTask(counter.get());
						Integer index = random.nextInt(priorities.length);
						
						pool.add(task, priorities[index]);
						LOG.debug("Added task" + task + ", with priority [" + priorities[index] + "]");
						counter.increment();
					}
				}
			}
		});
		
		executor.start();
		another.start();
	}
	
}
