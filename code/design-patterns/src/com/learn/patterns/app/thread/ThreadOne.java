package com.learn.patterns.app.thread;

public class ThreadOne implements Runnable {

	@Override
	public void run() {
		ThreadHelper.executeSingleton("threadone");
	}
}
