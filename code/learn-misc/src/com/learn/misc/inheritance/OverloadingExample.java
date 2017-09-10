package com.learn.misc.inheritance;

public class OverloadingExample {

	public void overloadedM(Object obj){
		System.out.println("object called");
	}
	
	public void overloadedM(Integer obj){
		System.out.println("Integer called");
	}	
	
	public void overloaddM(int i){
		System.out.println("int called");
	}
	
	
	public static void main(String[] args) {
		OverloadingExample objj = new OverloadingExample();
		int i = 8;
		objj.overloadedM(i);
	}
	
}
