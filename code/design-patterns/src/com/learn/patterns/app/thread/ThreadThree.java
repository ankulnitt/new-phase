package com.learn.patterns.app.thread;

public class ThreadThree implements Runnable {

	@Override
	public void run() {
		ThreadHelper.executeSingleton("thread three");
	}

}
