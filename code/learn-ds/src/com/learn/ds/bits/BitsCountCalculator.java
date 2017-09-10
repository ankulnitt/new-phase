package com.learn.ds.bits;

public class BitsCountCalculator {


	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			System.out.println(i + " : " + getSetBitsCount1(i) + " : " + Integer.toBinaryString(i));
		}
	}
	

	public static int getSetBitsCount(int n) {
		int count = 0;
		while (n > 0) {
			count += n & 1;
			n >>= 1;
		}

		return count;
	}
	
	

	public static int getSetBitsCount1(int n) {
		int count = 0;
		while (n > 0) {
			n &= n - 1;
			count++;
		}

		return count;
	}

}
