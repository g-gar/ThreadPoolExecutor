package com.ggar.framework.model;

import java.util.HashMap;
import java.util.Map;

public abstract class Mapper<T1, T2> {

	private final Map<T1, T2> mappings;
	
	public Mapper() {
		this.mappings = new HashMap<T1, T2>();
	}
	
	public T2 register(T1 key, T2 value) {
		return this.mappings.put(key, value);
	}
	
	public T2 unregister (T1 key) {
		return this.mappings.remove(key);
	}
	
	public T2 get(T1 key) {
		return this.mappings.get(key);
	}
}
