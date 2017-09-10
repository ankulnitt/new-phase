package com.learn.patterns.app.thread;

import com.learn.patterns.singleton.EagerInitializedSingleton;
import com.learn.patterns.singleton.LazyInitializedSingleton;
import com.learn.patterns.singleton.Singleton;

public class ThreadHelper {
	
	public static Singleton getInstance(){
		return lazyInitialized();
	}
	
	public static Singleton lazyInitialized() {
		return LazyInitializedSingleton.getInstance();
	}
	
	public static Singleton eagerInitialized() {
		return EagerInitializedSingleton.getInstance();
	}
	
	public static void printInstanceState(Singleton singleton, String threadName) {
		System.out.println(threadName + " InstanceCounter : " + singleton.getCounter());
		System.out.println(threadName + " state : " + singleton.getState());
		System.out.println(threadName + " instace : " + singleton);
	}
	
	public static void executeSingleton(String threadName){
		Singleton singleton = getInstance();
		printInstanceState(singleton, threadName);
	}

}
