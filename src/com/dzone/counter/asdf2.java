package com.dzone.counter;

public class asdf2 {
	public static void main(String[] args) {
        AtomicCounter counter = new AtomicCounter();
 
        Runnable r = new Runnable() {

			@Override
			public void run() {
				for (long index = 0; index < 500000000L; index++) {
					counter.incrementByOne();
					if (index == 500000000L - 1) System.out.println(this.hashCode() + " - " + counter.getCount());
				}
			}
        	
        };
        
        Thread thread1 = new Thread(r);
        Thread thread2 = new Thread(r);
        Thread thread3 = new Thread(r);
        long startTime = System.currentTimeMillis();
 
        thread1.start();
        thread2.start();
//        thread3.start();
        try {
            thread1.join();
            thread2.join();
//            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + " ms");
        System.out.println("Value is: " + counter.getCount());
    }
}
