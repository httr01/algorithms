package com.algo.sort;

import org.junit.Assert;
import org.junit.Test;

public class CountingSort {
	/***
	 * Assumption Values of the array are from 0 ...k
	 * Time Complexity 3 * O(n) + ka ~=  O(n + k)
	 * */
	public int[] countingsort(int[] numsArr) {
		if (numsArr.length< 2) return numsArr;
		
		int[] sortedArray  =  new int[numsArr.length];
		
		int maxNumber = Integer.MIN_VALUE;
		//O(n)
		for (int i =0; i< numsArr.length ; ++i) {
			if (numsArr[i]> maxNumber) maxNumber = numsArr[i];
		}
		int[] howManyTimesEachNum = new int[maxNumber+1];
		
		//O(n)
		for (int i =0; i< numsArr.length ; ++i) {
			++howManyTimesEachNum[numsArr[i]] ;
		}
		//O(n)
		int  sortedArrayIndex =0;
		for (int i =0; i< howManyTimesEachNum.length ; ++i) {
			for (int j = 1 ; j<= howManyTimesEachNum[i] ; ++j) {
				sortedArray[sortedArrayIndex++] =  i;
			}
		}
		
		return sortedArray;
	}
	
	@Test
	public  void test_1() {
		CountingSort cs =  new CountingSort();
		int[] numsArr = {10,7,3,2,11,3};
		int[] sorted_expected_arr = {2,3,3,7,10,11};
		Assert.assertArrayEquals(sorted_expected_arr, cs.countingsort(numsArr));
	}
	@Test
	public  void test_2() {
		CountingSort cs =  new CountingSort();
		int[] numsArr = {10,7,3,2,15,11,1,3, 0,15};
		int[] sorted_expected_arr = {0,1,2,3,3,7,10,11,15,15};
		Assert.assertArrayEquals(sorted_expected_arr, cs.countingsort(numsArr));
	}
	@Test
	public  void test_3() {
		CountingSort cs =  new CountingSort();
		int[] numsArr = {};
		int[] sorted_expected_arr = {};
		Assert.assertArrayEquals(sorted_expected_arr, cs.countingsort(numsArr));
	}
	@Test
	public  void test_4() {
		CountingSort cs =  new CountingSort();
		int[] numsArr = {10};
		int[] sorted_expected_arr = {10};
		Assert.assertArrayEquals(sorted_expected_arr, cs.countingsort(numsArr));
	}
	@Test
	public  void test_5() {
		CountingSort cs =  new CountingSort();
		int[] numsArr = {10,7};
		int[] sorted_expected_arr = {7,10};
		Assert.assertArrayEquals(sorted_expected_arr, cs.countingsort(numsArr));
	}
	@Test
	public  void test_6() {
		CountingSort cs =  new CountingSort();
		int[] numsArr = {7,8};
		int[] sorted_expected_arr = {7,8};
		Assert.assertArrayEquals(sorted_expected_arr, cs.countingsort(numsArr));
	}
	@Test
	public  void test_7() {
		CountingSort cs =  new CountingSort();
		int[] numsArr = {0,0};
		int[] sorted_expected_arr = {0,0};
		Assert.assertArrayEquals(sorted_expected_arr, cs.countingsort(numsArr));
	}
}
