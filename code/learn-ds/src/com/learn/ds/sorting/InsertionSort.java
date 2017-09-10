package com.learn.ds.sorting;

public class InsertionSort implements SortingAlgo<Integer> {

	@Override
	public void sort(Integer[] arr) {
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			int value = arr[i];
			int j = i;
			while (j > 0 && arr[j] > value) {
				arr[j] = arr[j - 1];
				j--;
			}
			arr[j] = value;
		}
	}
}
