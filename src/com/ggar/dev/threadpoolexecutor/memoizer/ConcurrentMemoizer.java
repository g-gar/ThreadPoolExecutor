package com.ggar.dev.threadpoolexecutor.memoizer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class ConcurrentMemoizer<A, B> implements Memoizer<A, B> {
	protected static Memoizer INSTANCE;
	
	protected Map<A, B> memo;
	
	public ConcurrentMemoizer() {
		memo = new ConcurrentHashMap<A, B>();
	}

	@Override
	public void set(A key, B value) {
		memo.put(key, value);
	}

	@Override
	public B get(A key) {
		return memo.get(key);
	}

	@Override
	public boolean isComputed(A key) {
		return memo.containsKey(key) && !memo.get(key).equals(null);
	}
}
