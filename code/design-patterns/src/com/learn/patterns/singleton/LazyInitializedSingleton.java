package com.learn.patterns.singleton;

public class LazyInitializedSingleton implements Singleton {

	private String state;

	private int counter = 0;

	private static LazyInitializedSingleton instance;

	private LazyInitializedSingleton() {
		counter++;
		state = "LazyInitializedSingleton" + counter;
	}

	public static LazyInitializedSingleton getInstance() {
		if (instance == null) {
			instance = new LazyInitializedSingleton();
		}
		return instance;
	}

	@Override
	public String getState() {
		return state;
	}

	@Override
	public int getCounter() {
		return counter;
	}

}
