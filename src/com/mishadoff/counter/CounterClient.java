package com.mishadoff.counter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import com.mishadoff.counter.impl.AtomicCounter;
import com.mishadoff.counter.impl.CASCounter;

public class CounterClient implements Runnable {

	private Counter c;
    private int num;

    public CounterClient(Counter c, int num) {
        this.c = c;
        this.num = num;
    }

    @Override
    public void run() {
        for (int i = 0; i < num; i++) {
            c.increment();
        }
    }
    
    public static void main(String[] args) throws Exception {
    	int NUM_OF_THREADS = 1000;
    	int NUM_OF_INCREMENTS = 100000;
    	ExecutorService service = Executors.newFixedThreadPool(NUM_OF_THREADS);
    	Counter counter = new CASCounter();
    	long before = System.currentTimeMillis();
    	for (int i = 0; i < NUM_OF_THREADS; i++) {
    	    service.submit(new CounterClient(counter, NUM_OF_INCREMENTS));
    	}
    	service.shutdown();
    	service.awaitTermination(1, TimeUnit.MINUTES);
    	long after = System.currentTimeMillis();
    	System.out.println("Counter result: " + counter.getCounter());
    	System.out.println("Time passed in ms:" + (after - before));
	}

}
