package com.learn.ds.heap;

import com.learn.ds.sorting.SortingUtil;

public class Heap {

	private static Integer heapSize;

//	private Integer parent(Integer i) {
//		return i / 2;
//	}

	private Integer left(Integer i) {
		return 2 * i + 1;
	}

	private Integer right(Integer i) {
		return 2 * i + 2;
	}

	private void maxHeapifyRec(Integer[] a, Integer i) {
		Integer l = left(i);
		Integer r = right(i);
		Integer largest = i;
		if (l < heapSize && a[l] > a[i]) {
			largest = l;
		}

		if (r < heapSize && a[r] > a[largest]) {
			largest = r;
		}

		if (i != largest) {
			swap(a, i, largest);
			maxHeapifyRec(a, largest);
		}
	}

	private void maxHeapifyIteration(Integer[] a, Integer i) {
		while (i <= heapSize / 2) {
			Integer l = left(i);
			Integer r = right(i);
			Integer largest = i;
			if (a[l] > a[i]) {
				largest = l;
			}
			if (a[r] > largest) {
				largest = r;
			}

			if (i != largest) {
				swap(a, i, largest);
				i = largest;
			}
		}
	}

	private void buildMaxHeap(Integer[] a) {
		heapSize = a.length;
		for (Integer i = (a.length) / 2 - 1; i > 0; i--) {
			maxHeapifyRec(a, i);
		}
	}

	private void buildMaxHeapItr(Integer[] a) {
		heapSize = a.length;
		for (Integer i = heapSize / 2; i > 0; i--) {
			maxHeapifyIteration(a, i);
		}
	}

	public void heapSort(Integer[] a) {
		buildMaxHeap(a);
		for (Integer i = (a.length) / 2 - 1; i > 1; i--) {
			swap(a, i, 1);
			heapSize = heapSize - 1;
			maxHeapifyRec(a, 1);
		}
	}

	public void heapSortItr(Integer[] a) {
		buildMaxHeapItr(a);
		for (Integer i = (a.length) / 2 - 1; i > 1; i--) {
			swap(a, i, 1);
			heapSize = heapSize - 1;
			maxHeapifyIteration(a, i);
		}
	}

	private void swap(Integer[] a, Integer i, Integer p) {
		Integer t = a[i];
		a[i] = a[p];
		a[p] = t;
	}
	
	public static void main(String[] args) {
		Integer[] a = new Integer[] { 1, 16, 10, 8, 14, 3, 9, 4, 7, 2 };

		Heap heap = new Heap();
		SortingUtil.printArray(a);
		heap.heapSort(a);
		SortingUtil.printArray(a);
		Integer[] arr = new Integer[] { 257, 254, 491, 445, 126, 322, 714, 561, 128, 96, 773, 223, 492, 96, 59, 139, 62,
				335, 747, 759 };
//		heap.heapSortItr(arr);
		SortingUtil.printArray(arr);

	}
}
