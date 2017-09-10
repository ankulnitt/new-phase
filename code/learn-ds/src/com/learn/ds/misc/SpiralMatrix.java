package com.learn.ds.misc;

public class SpiralMatrix {

	public void printInSpiral(int[][] a, int m, int n) {

		int i, k = 0, l = 0;

		while (k < m && l < n) {
			for (i = l; i < n; i++) {
				System.out.print(a[k][i] + " ");
			}
			k++;

			for (i = k; i < m; i++) {
				System.out.print(a[i][n - 1] + " ");
			}
			n--;

			if (k < m) {
				for (i = n - 1; i >= l; i--) {
					System.out.print(a[m - 1][i] + " ");
				}
				m--;
			}

			if (l < n) {
				for (i = m - 1; i >= k; i--) {
					System.out.print(a[i][l] + " ");
				}
				l++;
			}
		}
	}

	public static void main(String[] args) {
		SpiralMatrix spiralMatrix = new SpiralMatrix();

//		int m = 3;
//		int n = 6;
//		int a[][] = { { 1, 2, 3, 4, 5, 6 }, 
//					  { 7, 8, 9, 10, 11, 12 }, 
//					  { 13, 14, 15, 16, 17, 18 } };
		//1 2 3 4 5 6 12 18 17 16 15 14 13 7 8 9 10 11
		//1 2 3 4 5 6 12 18 17 16 15 14 13 7 8 9 10 11 
		int m = 4;
		int n = 4;
		int a[][] = { { 1, 2, 3, 4 }, 
					  { 5, 6, 7, 8 }, 
					  { 9, 10, 11, 12 }, 
					  { 13, 14, 15, 16 } };
		
		 spiralMatrix.printInSpiral(a, m, n);
		 //1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
         //1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10  
        
	}

}
