package com.ggar.dev.test.threadpoolexecutor.fibonacci.implementations;

import java.math.BigInteger;

import com.ggar.dev.threadpoolexecutor.Singleton.Singleton;
import com.ggar.dev.threadpoolexecutor.memoizer.ConcurrentMemoizer;
import com.ggar.dev.threadpoolexecutor.memoizer.Memoizer;

public class FibonacciSingleton extends Singleton<Integer, BigInteger> {
	
	private Memoizer<Integer, BigInteger> memo = new ConcurrentMemoizer<Integer, BigInteger>(){};
	
	public FibonacciSingleton() {
		this.configure(this);
	}

	@Override
	public BigInteger du(Integer value) {
		BigInteger result;
		if (!memo.isComputed(value)) {
			result = compute(value);
			memo.set(value, result);
		} else {
			result = memo.get(value);
		}
		return result;
	}
	
	private BigInteger compute(Integer n) {
		return compute(n, BigInteger.ONE);
	}
	
	private BigInteger compute(Integer n, BigInteger accumulator) {
		return  memo.isComputed(n) ? memo.get(n) : ( n >= 0 && n <= 1 ? accumulator : compute( n - 1, accumulator.add(b(n-1).add(b(n-2)))) );
	}

	private BigInteger b(Integer a) {
		return BigInteger.valueOf(a);
	}
}
