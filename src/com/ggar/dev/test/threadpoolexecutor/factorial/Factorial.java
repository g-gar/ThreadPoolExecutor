package com.ggar.dev.test.threadpoolexecutor.factorial;

import java.util.Scanner;

import com.ggar.dev.test.threadpoolexecutor.factorial.implementations.FactorialOperation;
import com.ggar.dev.test.threadpoolexecutor.factorial.implementations.FactorialSingleton;
import com.ggar.dev.threadpoolexecutor.Main;
import com.ggar.dev.threadpoolexecutor.Singleton.Singleton;
import com.ggar.dev.threadpoolexecutor.executor.Executor;
import com.ggar.dev.threadpoolexecutor.executor.GenericExecutor;
import com.ggar.dev.threadpoolexecutor.operation.Operation;
import com.ggar.dev.threadpoolexecutor.pool.GenericPool;
import com.ggar.dev.threadpoolexecutor.pool.Pool;

public class Factorial implements Main  {
	
	private Singleton singleton;
	private Pool pool;
	private Executor executor;
	
	public Factorial() {
		singleton = new FactorialSingleton();
		pool = new GenericPool<FactorialOperation>();
		executor = new GenericExecutor(pool);
	}
	
	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		String line;
		
		try {
			System.out.println("Factorial calculator");
			executor.start();
			while (sc.hasNextLine() && !(line = sc.nextLine().trim().toLowerCase()).equals("stop")) {
				int number = Integer.parseInt(line);
				Operation<Integer> op = new FactorialOperation(number);
				if (!op.equals(null))
					pool.add(op);
			}
			executor.stop();
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
