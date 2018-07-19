package com.ggar.dev.test.threadpoolexecutor.factorial.implementations;

import java.math.BigInteger;

import com.ggar.dev.threadpoolexecutor.Singleton.Singleton;
import com.ggar.dev.threadpoolexecutor.memoizer.ConcurrentMemoizer;
import com.ggar.dev.threadpoolexecutor.memoizer.Memoizer;

public class FactorialSingleton extends Singleton<Integer, BigInteger> {

	private Memoizer<Integer, BigInteger> memo = new ConcurrentMemoizer<Integer, BigInteger>(){};
	
	public FactorialSingleton() {
		this.configure(this);
	}
	
	@Override
	public BigInteger du(Integer value) {
		BigInteger result = BigInteger.ZERO;
		if (!this.memo.isComputed(value)) {
			System.out.println("Computing " + value + "!...");
			try {
				result = this.compute(value);
			} catch (Exception e) {
				System.out.println("catch body");
				e.printStackTrace();
			} finally {
				this.memo.set(value, result);
			}
		} else {
			result = this.memo.get(value);
		}
		return result;
	}

	private BigInteger compute(Integer n) {
		BigInteger result = BigInteger.ONE;
		//TODO compute knowing the maximum value computed for a better approach
		int i = 0; //TODO compute max recursion depth || number of recursion calls made by function
		int j = n ; //TODO compute step size for corecursion
		
		for (int k = 0; k - j < n; k += j) {
			Integer min = k - j;
			min = (min < 0) ? 0 : min;
			BigInteger temp = compute(k, min, result);
			result = result.equals(BigInteger.ONE) ? temp : result.multiply(temp);
		}
		return result;
	}
	private BigInteger compute(Integer n, BigInteger accumulator) {
		return compute(n, 1, accumulator);
//		return memo.isComputed(n) ? memo.get(n) : (n <= 1 ? accumulator : compute(n - 1, accumulator.multiply(BigInteger.valueOf(n))));
	}
	private BigInteger compute(Integer nmax, Integer nmin, BigInteger accumulator) {
//		if (memo.isComputed(nmax)) {
//			return memo.get(nmax);
//		} else if (nmax > nmin) {
//			if (nmax == 0)
//				return BigInteger.ONE;
//			else if (nmax == 1 || nmax.equals(nmin + 1)) 
//				return accumulator;
//			else
//				return compute(nmax - 1, nmin, accumulator.multiply(BigInteger.valueOf(nmax)));
//		} else {
//			return accumulator;
//		}
		if (!memo.isComputed(nmax)) {
			for (; nmax > 0 && nmax > nmin; nmax--) {
				accumulator = accumulator.multiply(BigInteger.valueOf(nmax));
			}
		} else accumulator = memo.get(nmax);
		return accumulator;
	}
}
