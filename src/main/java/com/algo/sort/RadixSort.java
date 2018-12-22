package com.algo.sort;

import java.util.ArrayList;
 
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
 

public class RadixSort {
	private static int RADIX = 10;
	/*** Assume that we are using positive numbers**/
	public int[] sort(int[] dataArr, int maxDigits) {
		return sortRadix(dataArr, maxDigits , 10,1);
	}
	
	private int[] sortRadix(int[] dataArr,   int currentDigitPosition, int modByTens, int divideByTens) {
		ArrayList<Integer>[] bucketForEachNumber = new ArrayList[RADIX];
		if (currentDigitPosition <=0 ) return dataArr;
		
		for ( int i =0 ;i <dataArr.length; ++i) {
			int valueToSort =  dataArr[i];
			int currentDigitValue = (valueToSort % modByTens);
			currentDigitValue = currentDigitValue/ divideByTens;
			
			List<Integer> existingValuesArrayAtAnIndex =  bucketForEachNumber[currentDigitValue];
			if (existingValuesArrayAtAnIndex == null) {
				ArrayList<Integer> newValuesArrayAtAnIndex =  new ArrayList<Integer>  ();
				newValuesArrayAtAnIndex.add(valueToSort);
				bucketForEachNumber[currentDigitValue]= newValuesArrayAtAnIndex;
			}else  existingValuesArrayAtAnIndex.add(valueToSort);
		}
		
		int[] sortedArray = new int[dataArr.length];
		int sortedArrayIndex=0;
		for (int i=0 ; i<RADIX ; ++i) {
			List<Integer> newValuesArrayAtAnIndex = bucketForEachNumber[i];
			if (newValuesArrayAtAnIndex !=null ) {
				for (int j = 0 ;j < newValuesArrayAtAnIndex.size() ; ++j ) {
					sortedArray[sortedArrayIndex++] = newValuesArrayAtAnIndex.get(j).intValue();
				}
			}
		}
		
		return sortRadix(sortedArray, currentDigitPosition-1 ,modByTens* 10, divideByTens *10);
	}
	
	@Test
	public void test_1() {
		int[] dataArr = {23,4,348,47};
		RadixSort rs = new RadixSort();
		int[] expectedSortedArr = {4,23,47,348}; 
		 
		Assert.assertArrayEquals(expectedSortedArr, rs.sort(dataArr, 3));
	}
	
	@Test
	public void test_2() {
		int[] dataArr = {23};
		RadixSort rs = new RadixSort();
		int[] expectedSortedArr = {23}; 
		 
		Assert.assertArrayEquals(expectedSortedArr, rs.sort(dataArr, 1));
	}
	@Test
	public void test_3() {
		int[] dataArr = {};
		RadixSort rs = new RadixSort();
		int[] expectedSortedArr = {}; 
		 
		Assert.assertArrayEquals(expectedSortedArr, rs.sort(dataArr, 0));
	}
	
	@Test
	public void test_4() {
		int[] dataArr = {124,0,478,23,56,4,348,47};
		RadixSort rs = new RadixSort();
		int[] expectedSortedArr = {0,4,23,47,56,124,348,478}; 
		Assert.assertArrayEquals(expectedSortedArr, rs.sort(dataArr, 3));
	}
	
	@Test
	public void test_5() {
		int[] dataArr = {124,0,478,23,2415,56,4,348,47};
		RadixSort rs = new RadixSort();
		int[] expectedSortedArr = {0,4,23,47,56,124,348,478,2415}; 
		Assert.assertArrayEquals(expectedSortedArr, rs.sort(dataArr, 4));
	}
}
