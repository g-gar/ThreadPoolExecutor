package com.ggar.dev.threadpoolexecutor.memoizer;

public interface Memoizer<A, B> {
	void set(A key, B value);
	B get(A key);
	boolean isComputed(A key);
}
