package com.ggar.thread;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class ThreadPool {
	
	private final Map<Priority, List<Task<?>>> tasks;
	
	public ThreadPool() {
		this.tasks = new HashMap<Priority, List<Task<?>>>();
	}
	
	public synchronized Task<?> pop() {
		System.out.println("Trying to get next task");
		Task<?> result = null;
		Priority priority = null;
		
		try {
			try {
				if ((priority = findNextPriority()) != null) {
					result = this.findByPriority(priority).get(0);
				}
				this.notifyAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} finally {
			return result;
		}
	}
	
	public synchronized Boolean add(Task<?> task) {
		this.notify();
		return this.add(task, Priority.NORMAL);
	}
	
	public synchronized Boolean add(Task<?> task, Priority priority) {
		System.out.println("Trying to add task" + task + ", with priority [" + priority + "]");
		Boolean result = null;
		List<Task<?>> list;
		try {
			list = this.findByPriority(priority);
			if (list == null) {
				list = new ArrayList<Task<?>>();
			}
			result = list.add(task);
			this.notifyAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return result;
		}
	}
	
	private List<Task<?>> findByPriority(Priority priority) throws Exception {
		if (priority != null) {
			return this.tasks.get(priority);
		}
		throw new Exception("No tasks available");
	}
	
	private Priority findNextPriority() {
		return EnumUtils.iterate(Priority.MAXIMUM, new Function<Priority, Priority>() {
			@Override
			public Priority apply(Priority priority) {
				List<Task<?>> tasks = ThreadPool.this.tasks.get(priority);
				return tasks != null && tasks.size() > 0 ? priority : null;
			}
		}, Comparator.reverseOrder());
	}
}
