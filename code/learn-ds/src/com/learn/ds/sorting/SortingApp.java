package com.learn.ds.sorting;

import java.time.LocalDateTime;

public class SortingApp {

	public static void main(String[] args) {

		SortingAlgo<Integer> sortingAlgo = getSortingAlog();

		Integer[] a = sortingAlgo.createArray(100000);
		sortingAlgo.printArray(a);
		LocalDateTime t1 = LocalDateTime.now();
		sortingAlgo.sort(a);
		printTimeDiff(t1);
		sortingAlgo.printArray(a);

		System.out.println("********Merge sort *************");
		SortingAlgo<Integer> mergeSort = getMergeSort();
		Integer[] arr = sortingAlgo.createArray(10);
		LocalDateTime t2 = LocalDateTime.now();
		mergeSort.sort(arr);
		printTimeDiff(t2);
		mergeSort.printArray(arr);

	}

	private static void printTimeDiff(LocalDateTime t1) {
		long diffInSeconds = java.time.Duration.between(t1, LocalDateTime.now()).getSeconds();
		int diffInNano = java.time.Duration.between(t1, LocalDateTime.now()).getNano();
		System.out.println(diffInSeconds + " :" + diffInNano);
	}

	private static SortingAlgo<Integer> getSortingAlog() {
		// return new SelectionSort();
		return new InsertionSort();
	}

	private static SortingAlgo<Integer> getMergeSort() {
		return new MergeSort();
	}

}
