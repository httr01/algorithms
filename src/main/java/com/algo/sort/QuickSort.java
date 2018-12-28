
package com.algo.sort;

import org.junit.Assert;
import org.junit.Test;
public class QuickSort{
public void quicksort(int[] arr){
		if (arr.length >1 )  
			quickSort(arr, 0, arr.length-1);
}	

	private void quickSort(int[] arr ,int start, int end ){
		if (start<end) {
			int pivotIndex = partition (arr,start,end);
			quickSort(arr, start ,pivotIndex-1);
			quickSort(arr,pivotIndex+1, end);
		}
	}

private int partition(int[] arr ,int start, int end ) {
	int pIndex = start;
	int pivot = end;
	for (int index =start ; index <= end-1; ++index){
             	if (arr[index] < arr[pivot]) {
             		swap(arr,pIndex,index);
             		++pIndex;
             	}
	}
	swap(arr, pIndex,pivot);

	return  pIndex;
}
private void swap(int[] arr ,int index1, int index2 ) {
		int temp = arr[index1];
		arr[index1] =  arr[index2];
		arr[index2] =  temp;
}

@Test
public void test_1() {
	QuickSort qs=  new QuickSort();
	int[] dataArr = {5,2,15};
	int[] expectedDataArr = {2,5,15};
	qs.quicksort(dataArr);	
	Assert.assertArrayEquals(expectedDataArr, dataArr);
}

@Test
public void test_2() {
	QuickSort qs=  new QuickSort();
	int[] dataArr = {5,25,16,2,10,18,15};
	int[] expectedDataArr = {2,5,10,15,16,18,25};
	qs.quicksort(dataArr);	
	Assert.assertArrayEquals(expectedDataArr, dataArr);
}

@Test
public void test_3() {
	QuickSort qs=  new QuickSort();
	int[] dataArr = {5,25,16,2,10,18,15,3,17};
	int[] expectedDataArr = {2,3,5,10,15,16,17,18,25};
	qs.quicksort(dataArr);	
	Assert.assertArrayEquals(expectedDataArr, dataArr);
}
}
