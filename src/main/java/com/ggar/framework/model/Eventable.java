package com.ggar.framework.model;

import java.util.function.Predicate;

public interface Eventable {

	void on(String eventName, Event eventHandler);
	void emit(String eventName);
	void listen();
	void disregard();
}
