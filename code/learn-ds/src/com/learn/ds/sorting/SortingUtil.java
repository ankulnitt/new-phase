package com.learn.ds.sorting;

import java.util.concurrent.ThreadLocalRandom;

public class SortingUtil {

	@SuppressWarnings("unchecked")
	public static <T> T[] createArray(int size) {
		Integer[] a = new Integer[size];
		for (int i = 0; i < size; i++) {
			a[i] = ThreadLocalRandom.current().nextInt(-100, 1000);
		}
		return (T[]) a;
	}

	public static <T> void printArray(T[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			System.out.print(a[i] + ",");
		}
		System.out.println(a[a.length - 1]);
	}
}
