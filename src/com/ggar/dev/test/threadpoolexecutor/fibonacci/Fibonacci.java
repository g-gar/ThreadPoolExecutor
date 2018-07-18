package com.ggar.dev.test.threadpoolexecutor.fibonacci;

import java.math.BigInteger;
import java.util.Scanner;

import com.ggar.dev.test.threadpoolexecutor.factorial.implementations.FactorialOperation;
import com.ggar.dev.test.threadpoolexecutor.fibonacci.implementations.FibonacciOperation;
import com.ggar.dev.test.threadpoolexecutor.fibonacci.implementations.FibonacciSingleton;
import com.ggar.dev.threadpoolexecutor.Main;
import com.ggar.dev.threadpoolexecutor.Singleton.Singleton;
import com.ggar.dev.threadpoolexecutor.executor.Executor;
import com.ggar.dev.threadpoolexecutor.executor.GenericExecutor;
import com.ggar.dev.threadpoolexecutor.operation.Operation;
import com.ggar.dev.threadpoolexecutor.pool.GenericPool;
import com.ggar.dev.threadpoolexecutor.pool.Pool;

public class Fibonacci implements Main {

	@Override
	public void run() {
		
		Singleton<Integer, BigInteger> singleton = new FibonacciSingleton();
		Scanner sc = new Scanner(System.in);
		Pool<Operation> pool = new GenericPool();
		Executor executor = new GenericExecutor(pool);
		String line;
		
		try {
			System.out.println("Fibonacci calculator");
			executor.start();
			while (sc.hasNextLine() && !(line = sc.nextLine().trim().toLowerCase()).equals("stop")) {
				int number = Integer.parseInt(line);
				if (true) {
					Operation<Integer> op = new FibonacciOperation(number);
					if (!op.equals(null))
						pool.add(op);
				}
			}
			executor.stop();
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}