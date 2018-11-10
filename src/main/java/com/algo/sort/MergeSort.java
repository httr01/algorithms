package com.algo.sort;

import org.junit.Assert;
import org.junit.Test;

/**
 * Recursive function for merge sort.
 * Steps
 * 1. Divide array in half.
 * 2. mergesort: first half
 * 3. mergesort: second half
 * 4. merge : first sorted half and second sorted half
 * 
 * Time Complexity: NLog(N)
 ***/
public class MergeSort {
	
	public void  mergesort(int[] arr, int startIndex, int endIndex) {
		if (endIndex-startIndex ==0) return ;
		int midPoint = (endIndex-startIndex)/2; // #1 step
		mergesort(arr,startIndex,startIndex+midPoint); // #2 step
		mergesort(arr,startIndex+midPoint+1,endIndex); // #3 step
		merge(arr,startIndex,startIndex+midPoint,endIndex);	 //#4 step
	}
	private  void merge(int[] arr, int startIndex, int midIndex, int endIndex) {
		int[] L = new int[midIndex-startIndex+1];
		int[] R = new int[endIndex - midIndex];
		//Make a copy of Array
		int i=0;
		for (int index=startIndex ;index<= midIndex;++index) L[i++]=arr[index];
		int j = 0;
		for (int index=midIndex+1 ;index<= endIndex;++index) R[j++ ]=arr[index];
		
		//we should sort from startIndex
		int sortedIndex =startIndex;
		i=j=0;
		while(i<=L.length-1 && j<=R.length-1) {
			if (L[i]<= R[j]) {
				arr[sortedIndex++]=L[i++];
			}else {
				arr[sortedIndex++]=R[j++];
			}
		}
		// take remaining elements and copy.
		if (i<= L.length-1) {
			for (int index=i ;index<= L.length-1;++index) arr[sortedIndex++]=L[index];
		}
		if (j<= R.length-1) {
			for (int index=j ;index<= R.length-1;++index) arr[sortedIndex++]=R[index];
		}
		
		//return sortedArr;
	}
	@Test
	public void happyPathSort_veryLargeArray() {
		int[] A = {4,5,1,8,2,45,40,30,41,37,42,39,28,15,10};
		int[] A_sorted_expected = {1,2,4,5,8,10,15,28,30,37,39,40,41,42,45};
		mergesort(A,0,A.length-1);
		Assert.assertArrayEquals(A_sorted_expected, A);
	}	
	@Test
	public void happyPathSort_largeArray() {
		int[] A = {4,5,1,8,2};
		int[] A_sorted_expected = {1,2,4,5,8};
		mergesort(A,0,A.length-1);
		Assert.assertArrayEquals(A_sorted_expected, A);
	}
	@Test
	public void happyPathSort() {
		int[] A = {4,5,1};
		int[] A_sorted_expected = {1,4,5};
		 mergesort(A,0,A.length-1);
		Assert.assertArrayEquals(A_sorted_expected, A);
	}
	
	@Test
	public void happyPathSort_oneelement() {
		int[] A = {4};
		int[] A_sorted_expected = {4};
		 mergesort(A,0,A.length-1);
		Assert.assertArrayEquals(A_sorted_expected, A);
	}
	@Test
	public void happyPathSort_twoelement() {
		int[] A = {4,0};
		int[] A_sorted_expected = {0,4};
		 mergesort(A,0,A.length-1);
		Assert.assertArrayEquals(A_sorted_expected, A);
	}
	
	@Test
	public void happyPathSort_negValues() {
		int[] A = {-4,-0};
		int[] A_sorted_expected = {-4,0};
		 mergesort(A,0,A.length-1);
		Assert.assertArrayEquals(A_sorted_expected, A);
	}
}


