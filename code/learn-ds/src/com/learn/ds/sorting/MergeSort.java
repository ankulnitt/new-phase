package com.learn.ds.sorting;

public class MergeSort implements SortingAlgo<Integer> {

	@Override
	public void sort(Integer[] arr) {
		int n = arr.length;
		if (n < 2) {
			return;
		}

		int m = n / 2;
		Integer[] l = new Integer[m];
		Integer[] r = new Integer[n - m];
		for (int i = 0; i < m; i++) {
			l[i] = arr[i];
		}

		for (int i = m; i < n; i++) {
			r[i - m] = arr[i];
		}

		sort(l);
		sort(r);
		merge(l, r, arr);
		
	}

	public static void main(String[] args) {
		MergeSort mergeSort = new MergeSort();
		Integer[] arr = mergeSort.createArray(1000);
		mergeSort.printArray(arr);
		mergeSort.sort(arr);
		mergeSort.printArray(arr);
	}

	private void merge(Integer[] l, Integer[] r, Integer[] a) {
		int ln = l.length;
		int rn = r.length;

		int i = 0;
		int j = 0;
		int k = 0;

		while (i < ln && j < rn) {
			if (l[i] <= r[j]) {
				a[k] = l[i++];
			} else {
				a[k] = r[j++];
			}
			k++;
		}

		while (i < ln) {
			a[k++] = l[i++];
		}

		while (j < rn) {
			a[k++] = r[j++];
		}
	}
}
