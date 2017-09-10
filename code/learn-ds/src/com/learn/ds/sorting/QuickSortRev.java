package com.learn.ds.sorting;

public class QuickSortRev {

	public void quickSort(Integer[] arr, int s, int e, int k) {
		int i = 0;
		if (s < e && i < k) {
			i++;
			int p = partition(arr, s, e);
			quickSort(arr, s, p - 1, k);
			quickSort(arr, p + 1, e, k);
		}
	}

	public int partition(Integer[] a, int s, int e) {
		int p = a[s];
		int pi = e;

		for (int i = e; i >= s + 1; i--) {
			if (a[i] <= p) {
				swap(a, i, pi);
				pi--;
			}
			swap(a, pi, s);
		}
		return pi;
	}

	private void swap(Integer[] a, int i, int p) {
		int t = a[i];
		a[i] = a[p];
		a[p] = t;
	}
	
	public static void main(String[] args) {
		InsertionSort sort = new InsertionSort();
		Integer[] a = new Integer[] { 257, 254, 491, 445, 126, 322, 714, 561, 128, 96, 773, 223, 492, 96, 59, 139, 62,
				335, 747, 759 };
		sort.printArray(a);
		int k = 5;
		QuickSortRev qrev = new QuickSortRev();
		qrev.quickSort(a, 0, a.length - 1, k);
		sort.printArray(a);
		for(int i = 0; i <= k; i++){
			System.out.print(a[i] + " ");
		}
	}
}
