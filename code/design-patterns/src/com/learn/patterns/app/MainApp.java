package com.learn.patterns.app;

import com.learn.patterns.singleton.EagerInitializedSingleton;
import com.learn.patterns.singleton.LazyInitializedSingleton;
import com.learn.patterns.singleton.Singleton;

public class MainApp {

	public static void main(String[] args) {
		eagerInitializedSingleton();
//		lazyInitializedSingleton();
	}

	private static void lazyInitializedSingleton() {
		BasicApplication app = new LazyInitializedSingletonApplication();
		Singleton s1 = LazyInitializedSingleton.getInstance();
		Singleton s2 = LazyInitializedSingleton.getInstance();
		Singleton s3 = LazyInitializedSingleton.getInstance();
		execute(app, s1, s2, s3);
	}

	private static void eagerInitializedSingleton() {
		BasicApplication app = new EagerInitializedSingletonApplication();
		Singleton s1 = EagerInitializedSingleton.getInstance();
		Singleton s2 = EagerInitializedSingleton.getInstance();
		Singleton s3 = EagerInitializedSingleton.getInstance();
		execute(app, s1, s2, s3);
	}

	private static void execute(BasicApplication app, Singleton... singletons) {
		app.threadeUnsafeExecution(singletons);
		app.threadSafeEagerExecution();
	}
}
