package com.learn.misc.inheritance;

public class InheritanceApp {

	public static void main(String[] args) {
		SuperInf inf = new SubClass();
		inf.abstractMethod();
		
		SuperClass sp = new SubClass();
		sp.abstractMethod();
	}

}
