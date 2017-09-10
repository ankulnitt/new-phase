package com.learn.patterns.singleton;

public class EagerInitializedSingleton implements Singleton {

	private static EagerInitializedSingleton instance = new EagerInitializedSingleton();

	private String state;

	private int counter = 0;

	private EagerInitializedSingleton() {
		counter++;
		state = "basic singleton" + counter;
	}

	public static EagerInitializedSingleton getInstance() {
		return instance;
	}

	public String getState() {
		return state;
	}

	public int getCounter() {
		return counter;
	}
}
