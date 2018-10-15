package com.ggar.thread;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.apache.log4j.Logger;

import com.ggar.framework.util.EnumUtils;
import com.ggar.thread.model.Priority;
import com.ggar.thread.model.Task;

public class ThreadPool {
	
	private final static Logger LOG = Logger.getLogger(ThreadPoolExecutor.class);
	private final Map<Priority, List<Task<?>>> tasks;
	
	public ThreadPool() {
		this.tasks = new HashMap<Priority, List<Task<?>>>();
		
		EnumUtils.iterate(Priority.class, new Function<Priority, Void>() {
			@Override public Void apply(Priority priority) {
				ThreadPool.this.tasks.put(priority, new ArrayList<Task<?>>());
				return null;
			}
		});
	}
	
	public synchronized Task<?> pop() {
		Task<?> result = null;
		Priority priority = null;
		
		try {
			while (this.tasks.isEmpty()) {
				LOG.debug("Waiting for a task...");
				this.wait();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			if ((priority = findNextPriority()) != null) {
				result = this.findByPriority(priority).remove(0);
				LOG.debug("Found " + result + ", with priority " + priority);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.notifyAll();
			return result;
		}
	}
	
	public synchronized Boolean add(Task<?> task) {
		this.notifyAll();
		return this.add(task, Priority.NORMAL);
	}
	
	public synchronized Boolean add(Task<?> task, Priority priority) {
		LOG.debug("Trying to add task" + task + ", with priority [" + priority + "]");
		Boolean result = null;
		List<Task<?>> list = null;
		
		try {
			list = this.findByPriority(priority);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (list == null) {
			list = new ArrayList<Task<?>>();
		}
		result = list.add(task);
		this.notify();
		return result;
	}
	
	private synchronized List<Task<?>> findByPriority(Priority priority) throws Exception {
		if (priority != null) {
			return this.tasks.get(priority);
		}
		throw new Exception("No tasks available");
	}
	
	private synchronized Priority findNextPriority() {
		return EnumUtils.iterate(Priority.class, new Function<Priority, Priority>() {
			public Priority apply(Priority priority) {
				List<Task<?>> tasks = ThreadPool.this.tasks.get(priority);
				return tasks != null && tasks.size() > 0 ? priority : null;
			}
		}, Comparator.reverseOrder());
	}
}
