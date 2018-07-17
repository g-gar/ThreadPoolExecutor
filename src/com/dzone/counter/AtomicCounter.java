package com.dzone.counter;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicCounter {
    private AtomicLong count;
 
    public AtomicCounter() {
        count = new AtomicLong(0);
    }
    void  incrementByOne() { count.incrementAndGet(); }
    long getCount() { return count.get(); }
}
