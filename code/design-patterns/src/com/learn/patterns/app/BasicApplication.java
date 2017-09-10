package com.learn.patterns.app;

import com.learn.patterns.app.thread.ThreadOne;
import com.learn.patterns.app.thread.ThreadThree;
import com.learn.patterns.app.thread.ThreadTwo;
import com.learn.patterns.singleton.Singleton;

public abstract class BasicApplication {

	public void threadeUnsafeExecution(Singleton... singletons ) {
		
		for (int i = 0; i < singletons.length; i++) {
			extracted(singletons[i]);
		}
	}

	private void extracted(Singleton s1) {
		System.out.println("state " + s1.getState());
		System.out.println("counter " + s1.getCounter());
		System.out.println("instance " + s1);
	}

	public void threadSafeEagerExecution() {
		ThreadOne r1 = new ThreadOne();
		Thread t1 = new Thread(r1);
		t1.start();

		ThreadTwo r2 = new ThreadTwo();
		Thread t2 = new Thread(r2);
		t2.start();

		ThreadThree r3 = new ThreadThree();
		Thread t3 = new Thread(r3);
		t3.start();
	}

}
