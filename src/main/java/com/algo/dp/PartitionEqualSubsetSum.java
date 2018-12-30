package com.algo.dp;

import org.junit.Assert;
import org.junit.Test;

public class PartitionEqualSubsetSum {
/**
 * https://leetcode.com/problems/partition-equal-subset-sum/
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the 
 * sum of elements in both subsets is equal.
 * **/
		public boolean canPartition(int[] nums) {
			if  (nums.length < 2) return false;
			if (nums.length==2 && nums[0] ==nums[1]) return true;
			else if (nums.length==2 && nums[0] !=nums[1]) return false;
			int totalSum=0;
			for (int i =0; i< nums.length  ;++i) {
				totalSum+=nums[i];
			}
			// check if sum is even, otherwise , it is not possible to divide array
			if  (totalSum%2 !=0) return false;
			int sumOfOneSubArray = totalSum/2+1;
			boolean[][] magicTable = new boolean[nums.length+1][sumOfOneSubArray];
			
			//init column zero true;
			for (int i =0 ; i< nums.length ; ++i) 		magicTable[i][0] =true;
				
			for (int i =1 ; i<= nums.length ; ++i) {
				for (int j =1 ; j< sumOfOneSubArray ; ++j) {
					//figure out magicTable[i][i] 
					if (nums[i-1] == j || ( magicTable[i-1][j] ) ) 	magicTable[i][j]=true;
					else  {
						int j1=j- nums[i-1];
						if ( j1>=0) magicTable[i][j] =magicTable[i-1][j1];
					}
				}//for
				//Optimization if  we can make one sub array with target sum, we can quit;
				if ( magicTable[i][sumOfOneSubArray-1]) return true;
			}//for
			return false;
		}

	@Test
	public void test_1() {
		int[] nums = {1, 5, 11, 5}; 
		PartitionEqualSubsetSum algo =  new PartitionEqualSubsetSum();
		Assert.assertTrue(algo.canPartition(nums));
	}

	@Test
	public void test_2() {
		int[] nums = {1, 2, 3, 5}; 
		PartitionEqualSubsetSum algo =  new PartitionEqualSubsetSum();
		Assert.assertFalse(algo.canPartition(nums));
	} 
	
	@Test
	public void test_3() {
		int[] nums = {2, 5, 13, 6}; 
		PartitionEqualSubsetSum algo =  new PartitionEqualSubsetSum();
		Assert.assertTrue(algo.canPartition(nums));
	} 
	
	@Test
	public void test_4() {
		int[] nums = {1, 5, 11, 6,1,2}; 
		PartitionEqualSubsetSum algo =  new PartitionEqualSubsetSum();
		Assert.assertTrue(algo.canPartition(nums));
	} 
	
	@Test
	public void test_5() {
		int[] nums = {5,4}; 
		PartitionEqualSubsetSum algo =  new PartitionEqualSubsetSum();
		Assert.assertFalse(algo.canPartition(nums));
	} 
	
	@Test
	public void test_6() {
		int[] nums = {5,5}; 
		PartitionEqualSubsetSum algo =  new PartitionEqualSubsetSum();
		Assert.assertTrue(algo.canPartition(nums));
	} 
	
	
	@Test
	public void test_7() {
		int[] nums = {4}; 
		PartitionEqualSubsetSum algo =  new PartitionEqualSubsetSum();
		Assert.assertFalse(algo.canPartition(nums));
	} 
	
	@Test
	public void test_8() {
		int[] nums = {}; 
		PartitionEqualSubsetSum algo =  new PartitionEqualSubsetSum();
		Assert.assertFalse(algo.canPartition(nums));
	} 
}
