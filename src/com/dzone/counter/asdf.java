package com.dzone.counter;

public class asdf {
	public static void main(String[] args) {
        AtomicCounter counter = new AtomicCounter();
 
        Thread thread1 = new Thread(() -> {
            for (long index = 0; index < 500000000L; index++) {
                counter.incrementByOne();
            }
        });
        Thread thread2 = new Thread(() -> {
            for (long index = 0; index < 500000000L; index++) {
                counter.incrementByOne();
            }
        });
        long startTime = System.currentTimeMillis();
 
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + " ms");
        System.out.println("Value is: " + counter.getCount());
    }
}
