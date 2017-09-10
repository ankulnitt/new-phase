package com.learn.ds.sorting;

public class SelectionSort implements SortingAlgo<Integer> {

	@Override
	public void sort(Integer[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			int tmp = arr[i];
			arr[i] = arr[min];
			arr[min] = tmp;
		}
	}

}
