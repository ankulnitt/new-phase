package com.learn.ds.array;

/**
 * 
 * @author ankul
 * Solution implementation to find peak element from an array which is first increasing and then decreasing.
 *
 */
public class ArraysPeakProblem {

	public int findPeak(int[] a, int l, int h) {
		if (l == h)
			return l;
		//if there are two elements in array.
		if (h == l + 1) {
			if (a[l] >= a[h])
				return l;
			else
				return h;
		}

		//find mid
		int m = (l + h) / 2;
		//if mid element is greater than previous and next elements, then mid is peak.
		if (a[m] > a[m + 1] && a[m] > a[m - 1])
			return m;
		// if mid element is greater than its next element and smaller than its
		// previous element, then peak must be in first half.
		// else in second half
		if (a[m] > a[m + 1] && a[m] < a[m - 1])
			return findPeak(a, l, m - 1);
		else
			return findPeak(a, m + 1, h);
	}

	public static void main(String[] args) {
		ArraysPeakProblem app = new ArraysPeakProblem();
		int[] a = { 1, 10, 11, 16, 19, 20, 5, 3, 2, 1 };
		int peak = app.findPeak(a, 0, a.length - 1);
		System.out.println(peak);
	}
}
