package com.learn.patterns.app.thread;

public class ThreadTwo implements Runnable {

	@Override
	public void run() {
		ThreadHelper.executeSingleton("threadtwo");
	}

}
