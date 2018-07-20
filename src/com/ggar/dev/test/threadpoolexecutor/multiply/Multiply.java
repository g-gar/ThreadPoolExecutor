package com.ggar.dev.test.threadpoolexecutor.multiply;

import java.util.Scanner;

import com.ggar.dev.test.threadpoolexecutor.multiply.implementations.MultiplyOperation;
import com.ggar.dev.test.threadpoolexecutor.multiply.implementations.MultiplyOperationPool;
import com.ggar.dev.test.threadpoolexecutor.multiply.implementations.MultiplySingleton;
import com.ggar.dev.threadpoolexecutor.Main;
import com.ggar.dev.threadpoolexecutor.executor.Executor;
import com.ggar.dev.threadpoolexecutor.executor.GenericExecutor;
import com.ggar.dev.threadpoolexecutor.operation.Operation;
import com.ggar.dev.threadpoolexecutor.pool.GenericPool;
import com.ggar.dev.threadpoolexecutor.pool.Pool;

public class Multiply extends Main {
	
	public Multiply() {
		super(new MultiplySingleton(), new GenericPool<MultiplyOperation>(), new GenericExecutor());
		((MultiplySingleton)this.singleton).configure(4);
	}
	
	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		String line;
		
		try {
			executor.start();
			while (sc.hasNextLine() && !(line = sc.nextLine().trim().toLowerCase()).equals("stop")) {
				int number = Integer.parseInt(line);
				MultiplyOperation op = new MultiplyOperation(number);
				if (!op.equals(null))
					pool.add(op);
			}
			executor.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
