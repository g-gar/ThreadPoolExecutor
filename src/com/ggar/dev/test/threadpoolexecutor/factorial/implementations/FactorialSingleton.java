package com.ggar.dev.test.threadpoolexecutor.factorial.implementations;

import java.math.BigInteger;

import com.ggar.dev.threadpoolexecutor.Singleton.Singleton;
import com.ggar.dev.threadpoolexecutor.memoizer.Memoizer;

public class FactorialSingleton extends Singleton<Integer, BigInteger> {

	private Memoizer<Integer, BigInteger> memo = new FactorialMemoizer();
	
	public FactorialSingleton() {
		this.configure();
	}
	
	@Override
	protected void configure() {
		this.INSTANCE = this;
	}
	
	@Override
	public BigInteger du(Integer value) {
		BigInteger result;
		if (!this.memo.isComputed(value)) {
			System.out.println("Computing " + value + "!...");
			result = this.computeFactorial(value);
			this.memo.set(value, result);
		} else {
			result = this.memo.get(value);
		}
		return result;
	}

	private BigInteger computeFactorial(Integer n) {
		return computeFactorial(n, BigInteger.valueOf(1));
	}
	private BigInteger computeFactorial(Integer n, BigInteger accumulator) {
		return memo.isComputed(n) ? memo.get(n) : (n <= 1 ? accumulator : computeFactorial(n - 1, accumulator.multiply(BigInteger.valueOf(n))));
	}
}