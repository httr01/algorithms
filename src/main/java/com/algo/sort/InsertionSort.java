package com.algo.sort;

import org.junit.Assert;

import org.junit.Test;

/***
 * This will perform in-place insertion sort. 
 * Reference Material : http://web.mit.edu/1.124/LectureNotes/sorting.html
 * Time Complexity - Worst case = (N^2)/2
 ***/
public class InsertionSort {
	public void insertionSort(int[] A) {
		if (  A.length < 2 )  return;
		for (int  i=1 ;i<A.length;++i) {
			int current = A[i];
			int j=i-1;
			while(j>=0 && A[j] > current) {	 
					A[j+1] = A[j];				 
				--j;
			}
			A[j+1] = current;
		}
	}
	
	@Test
	public void happyCase() {
		int[] A = {4,5,1,4,9,10,2};
		int[] A_sorted = {1,2,4,4,5,9,10};
		insertionSort(A);
		Assert.assertArrayEquals(A_sorted,A );
	}
 
	@Test
	public void negativetCase_empty() {
		int[] A = {};
		int[] A_sorted = {};
		insertionSort(A);
		Assert.assertArrayEquals(A_sorted, A);
	}
	
	@Test
	public void happyCase_oneElement() { 
		int[] A = {4};
		int[] A_sorted = {4};
		insertionSort(A);
		Assert.assertArrayEquals(A_sorted, A);
	}
	
	@Test
	public void happyCase_bigArray1() {
		int[] A = {4,5,1,4,9,10,2,21,12,15,3,8,20};
		int[] A_sorted = {1,2,3,4,4,5,8,9,10,12,15,20,21};
		insertionSort(A);
		Assert.assertArrayEquals(A_sorted, A);
	}
	@Test
	public void happyCase_duplicate() {
		int[] A = {4,4,4,4,4,4};
		int[] A_sorted = {4,4,4,4,4,4};
		insertionSort(A);
		Assert.assertArrayEquals(A_sorted, A);
	}
	
	@Test
	public void happyCase_bigArray2() {
		int[] A = {4,5,1,4,9,10,2,21,12,15,3,8,20,51,31,18,13,35};
		int[] A_sorted = {1,2,3,4,4,5,8,9,10,12,13,15,18,20,21,31,35,51};
		insertionSort(A);
		Assert.assertArrayEquals(A_sorted, A);
	}
	
	@Test
	public void happyCase_negativeNumbers(){
		int[] A = {-4,4,4,4,-4,4};
		int[] A_sorted = {-4,-4,4,4,4,4};
		insertionSort(A);
		Assert.assertArrayEquals(A_sorted, A);
	}
	
}
