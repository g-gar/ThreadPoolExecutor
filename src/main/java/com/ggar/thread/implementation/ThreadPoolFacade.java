package com.ggar.thread.implementation;

public interface ThreadPoolFacade {
	
	Thread findAvailableThread();
	void clearThread(Thread thread);
	
}
