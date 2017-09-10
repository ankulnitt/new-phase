package com.learn.misc.inheritance;

import java.io.FileNotFoundException;

public abstract class SuperClass {
	
	public void doSomething() throws FileNotFoundException{
		System.out.println("in super class");
	}
	
	public void abstractMethod(){
		System.out.println("abstract method in abstract class");
	}

}
