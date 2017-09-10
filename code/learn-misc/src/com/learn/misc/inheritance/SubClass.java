package com.learn.misc.inheritance;

public class SubClass extends SuperClass implements SuperInf {

	@Override
	public void doSomething() {
		System.out.println("in subclass");
	}

	@Override
	public void abstractMethod() {
		System.out.println("in abstract class");
	}
	
	public static void main(String[] args) {
		SuperClass inf = new SuperClass() {
		};
		inf.abstractMethod();
		inf = new SubClass();
		inf.abstractMethod();
	}

}
