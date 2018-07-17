package com.ggar.dev.test.threadpoolexecutor.factorial;

import java.util.Scanner;

import com.ggar.dev.test.threadpoolexecutor.factorial.implementations.FactorialOperation;
import com.ggar.dev.test.threadpoolexecutor.factorial.implementations.FactorialOperationPool;
import com.ggar.dev.test.threadpoolexecutor.factorial.implementations.FactorialSingleton;
import com.ggar.dev.threadpoolexecutor.Main;
import com.ggar.dev.threadpoolexecutor.executor.Executor;
import com.ggar.dev.threadpoolexecutor.executor.GenericExecutor;
import com.ggar.dev.threadpoolexecutor.operation.Operation;
import com.ggar.dev.threadpoolexecutor.pool.Pool;

public class Factorial implements Main  {
	public void run() {
		new FactorialSingleton();
		Scanner sc = new Scanner(System.in);
		Pool<FactorialOperation> pool = new FactorialOperationPool();
		Executor executor = new GenericExecutor(pool);
		String line;
		
		try {
			System.out.println("Factorial calculator");
			executor.start();
			while (sc.hasNextLine() && !(line = sc.nextLine().trim().toLowerCase()).equals("stop")) {
				int number = Integer.parseInt(line);
				Operation<Integer> op = new FactorialOperation(number);
				if (!op.equals(null))
					pool.add((FactorialOperation) op);
			}
			executor.stop();
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
