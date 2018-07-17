package com.ggar.dev.threadpoolexecutor.properties;

import java.util.HashMap;
import java.util.Map;

public class Properties<A,B> {
	
	private Map<A, B> properties;
	
	public Properties() {
		this.properties = new HashMap<A, B>();
	}
	
	public void set(A key, B value) {
		properties.put(key, value);
	}
	
	public B get(A key) {
		return properties.get(key);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Properties [properties=").append(properties).append("]");
		return builder.toString();
	}
	
	
}
