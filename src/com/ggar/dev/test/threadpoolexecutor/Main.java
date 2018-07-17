package com.ggar.dev.test.threadpoolexecutor;

import java.util.Scanner;

import com.ggar.dev.threadpoolexecutor.Singleton.MultiplySingleton;
import com.ggar.dev.threadpoolexecutor.executor.Executor;
import com.ggar.dev.threadpoolexecutor.executor.GenericExecutor;
import com.ggar.dev.threadpoolexecutor.operation.MultiplyOperation;
import com.ggar.dev.threadpoolexecutor.operation.Operation;
import com.ggar.dev.threadpoolexecutor.pool.MultiplyOperationPool;
import com.ggar.dev.threadpoolexecutor.pool.Pool;

public class Main {
//	public static void main(String[] args) {
//		new MultiplySingleton().configure(4);
//		Scanner sc = new Scanner(System.in);
//		Pool<MultiplyOperation> pool = new MultiplyOperationPool();
//		Executor executor = new GenericExecutor(pool);
//		String line;
//		
//		try {
//			executor.start();
//			while (sc.hasNextLine() && !(line = sc.nextLine().trim().toLowerCase()).equals("stop")) {
//				int number = Integer.parseInt(line);
//				Operation<Integer> op = new MultiplyOperation(number);
//				if (!op.equals(null))
//					pool.add((MultiplyOperation) op);
//			}
//			executor.stop();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}
