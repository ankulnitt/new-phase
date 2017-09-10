package com.learn.ds.sorting;

public class QuickSort {

	public void quickSort(Integer[] arr, int a, int r) {
		if (a < r) {
			int p = partition(arr, a, r);
			quickSort(arr, a, p - 1);
			quickSort(arr, p + 1, r);
		}
	}

	private int partition(Integer[] a, int p, int r) {
		int x = a[r];
		int i = p-1;
		for (int j = p; j < r; j++) {
			if (a[j] <= x) {
				i++;
				swap(a, j, i);
			}
		}
		swap(a, i + 1, r);
		return i + 1;
	}

	private void swap(Integer[] a, int i, int j) {
		if(i == j)
			return;
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	public static void main(String[] args) {
		SortingAlgo<Integer> isort = new InsertionSort();
		Integer[] a = isort.createArray(100);
		QuickSort qSort = new QuickSort();
		int s = 0;
		int e = a.length - 1;
		System.out.println("befor sorting");
		isort.printArray(a);
		qSort.quickSort(a, s, e);
		System.out.println("after sorting");
		isort.printArray(a);
	}

}
