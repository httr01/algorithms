package com.algo.array.heap;

import org.junit.Assert;
import org.junit.Test;

public class HeapSort {
	/**
	 * Time  complexity : n log(n)
	 * Space Complexity : o(n)  **/
	public int[] heapSort(int[] dataArr) {
		
		int[] sortedArray = new int[dataArr.length];
		int currentUnsortedArrayLength = dataArr.length;
		int sortedArrayIndex = 0;
		
		if (dataArr.length == 0 )  return sortedArray;
		// 1. build Max heap 
		buildMaxHeap(dataArr);
		// 2. Remove 0th element , put last element at 0th position and apply  heapifyAtIndex at 0th index  
		for(int i = dataArr.length-1 ;i >= 1; --i) {
			sortedArray[sortedArrayIndex++] = dataArr[0];
			dataArr[0] = dataArr[currentUnsortedArrayLength-1];
			heapifyAtIndex(dataArr,0,currentUnsortedArrayLength--);
			
		}
		// pick last element
		sortedArray[sortedArrayIndex++] = dataArr[0];
		return sortedArray;
	}
	
	public void buildMaxHeap(int[] dataArr) {
		int startingRoot = dataArr.length/2 -1;
		for(int rootIndex = startingRoot;rootIndex>=0; --rootIndex) {
			heapifyAtIndex(dataArr,rootIndex,dataArr.length);
		}
		//return dataArr;
	}
	
	public void heapifyAtIndex(int[] dataArr , int currRoot, int totalArrayLength) {
		int leftIndex = currRoot*2+1;
		int rightIndex= leftIndex+1;
		//there are no left and right index
		if (leftIndex>=totalArrayLength) return;
		
		if (rightIndex>=totalArrayLength && dataArr[leftIndex] > dataArr[currRoot]) {
			// we only have left index
			swap(dataArr,leftIndex,currRoot);
			heapifyAtIndex(dataArr,leftIndex,totalArrayLength);
		} 
		if (rightIndex <totalArrayLength && dataArr[leftIndex] > dataArr[rightIndex] && dataArr[leftIndex] > dataArr[currRoot]) {
			swap(dataArr,leftIndex,currRoot);
			heapifyAtIndex(dataArr,leftIndex,totalArrayLength);
		}else if ( rightIndex <totalArrayLength && dataArr[rightIndex ] > dataArr[leftIndex] && dataArr[rightIndex] > dataArr[currRoot]) {
			swap(dataArr,rightIndex,currRoot);
			heapifyAtIndex(dataArr,rightIndex,totalArrayLength);
		}
	}
	
	public void swap(int[] dataArr, int index1,int index2) {
			int temp = dataArr[index1];
			dataArr[index1] =  dataArr[index2];
			dataArr[index2] =  temp;
	}
	
	@Test
	public void buildHeap_happyCase_small_3() {
		int[] A = {9,10,2};
		int[] A_heapSorted_expected = {10,9,2};
			
		buildMaxHeap(A);
		Assert.assertArrayEquals(A_heapSorted_expected, A);
	}
	
	@Test
	public void buildHeap_happyCase_small_4() {
		int[] A = {9,10,2,7};
		int[] A_heapSorted_expected = {10,9,2,7};
			
		buildMaxHeap(A);
		Assert.assertArrayEquals(A_heapSorted_expected, A);
	}
	
	@Test
	public void buildHeap_happyCase_7_element() {
		int[] A = {5,29,6,2,35,15,10};
		int[] A_heapSorted_expected = {35,29,15,2,5,6,10};
			
		buildMaxHeap(A);
		Assert.assertArrayEquals(A_heapSorted_expected, A);
	}
	
	
	@Test
	public void buildHeap_happyCase_12_element() {
		int[] A = {4,5,1,9,10,2,21,12,15,3,8,20};
		int[] A_heapSorted_expected = {21,15,20,12,10,4,1,5,9,3,8,2};
			
		buildMaxHeap(A);
		Assert.assertArrayEquals(A_heapSorted_expected, A);
	}
	@Test
	public void buildHeap_happyCase_20_element() {
		int[] A = {4,5,1,9,10,2,21,12,15,3,8,20,54,35,18,27,25,22,6,13};
		int[] A_heapSorted_expected = {54,27,35,25,13,20,21,12,22,10,8,1,2,4,18,5,9,15,6,3};
			
		buildMaxHeap(A);
		Assert.assertArrayEquals(A_heapSorted_expected, A);
	}
	
	@Test
	public void sortHeap_happyCase_20_element() {
		int[] A = {4,5,1,9,10,2,21,12,15,3,8,20,54,35,18,27,25,22,6,13};
		int[] A_heapSorted_expected = {54,35,27,25,22,21,20,18,15,13,12,10,9,8,6,5,4,3,2,1};
		Assert.assertArrayEquals(A_heapSorted_expected, heapSort(A));
	}
	
	
	@Test
	public void sortHeap_happyCase_25_element() {
		int[] A = {4,5,1,9,10,2,21,12,15,3,8,20,54,35,18,27,25,22,6,13,24,55,49,29,17};
		int[] A_heapSorted_expected = {55,54,49,35,29,27,25,24,22,21,20,18,17,15,13,12,10,9,8,6,5,4,3,2,1};
		Assert.assertArrayEquals(A_heapSorted_expected, heapSort(A));
	}
	
	@Test
	public void sortHeap_happyCase_27_element() {
		int[] A = {4,5,1,9,10,2,21,12,15,3,8,20,54,35,18,27,25,22,6,13,24,55,49,29,17,42,43};
		int[] A_heapSorted_expected = {55,54,49,43,42,35,29,27,25,24,22,21,20,18,17,15,13,12,10,9,8,6,5,4,3,2,1};
		Assert.assertArrayEquals(A_heapSorted_expected, heapSort(A));
	}
	
	@Test
	public void sortHeap_happyCase_3_element() {
		int[] A = {9,10,2};
		int[] A_heapSorted_expected = {10,9,2};
		Assert.assertArrayEquals(A_heapSorted_expected, heapSort(A));
	}
	@Test
	public void sortHeap_happyCase_1_element() {
		int[] A = {2};
		int[] A_heapSorted_expected = {2};
		Assert.assertArrayEquals(A_heapSorted_expected, heapSort(A));
	}
	@Test
	public void sortHeap_happyCase_2_element() {
		int[] A = {11,71};
		int[] A_heapSorted_expected = {71,11};
		Assert.assertArrayEquals(A_heapSorted_expected, heapSort(A));
	}
	
	@Test
	public void sortHeap_happyCase_4_element() {
		int[] A = {9,10,2,11};
		int[] A_heapSorted_expected = {11,10,9,2};
		Assert.assertArrayEquals(A_heapSorted_expected, heapSort(A));
	}
	@Test
	public void sortHeap_happyCase_0_element() {
		int[] A = {};
		int[] A_heapSorted_expected = {};
		Assert.assertArrayEquals(A_heapSorted_expected, heapSort(A));
	}
}
