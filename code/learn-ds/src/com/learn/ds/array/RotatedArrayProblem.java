package com.learn.ds.array;

/**
 * 
 * @author ankul
 * Find an element in a rotated sorted array.
 *
 */
public class RotatedArrayProblem {

	public int search(int[] a, int k) {
		return binarySearch(a, 0, a.length - 1, k);
	}

	private int binarySearch(int[] a, int l, int h, int k) {

		if (l > h)
			return -1;
		int m = (l + h) / 2;
		if (a[m] == k)
			return m;
		if (a[l] <= a[m]) {
			//first half is sorted.
			if (k >= a[l] && k < a[m]) {
				return binarySearch(a, l, m - 1, k);
			}
			return binarySearch(a, m + 1, h, k);
		} else {
			if (k >= a[m + 1] && k <= a[h]) {
				return binarySearch(a, m + 1, h, k);
			}
			return binarySearch(a, l, m - 1, k);
		}
	}
	
	public static void main(String[] args) {
		int[] a = new int[] { 4, 6, 8, 10, 12, 16, 20, 1, 2, 3, 4 };
		RotatedArrayProblem rap = new RotatedArrayProblem();
		System.out.println(rap.search(a, 8));
	}

}
