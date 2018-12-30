package com.algo.array;

import org.junit.Assert;
import org.junit.Test;
/***
 * 
 * https://leetcode.com/problems/maximum-subarray/
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.*/
public class MaximumSumSubarray {
    public int maxSubArray(int[] nums) {
	    	if (nums.length == 0) return 0;
	    	else if (nums.length == 1) return nums[0];
	    	int CS = nums[0];
	    	int M= CS;
		for (int i =1 ;i< nums.length ; ++i) {
			 if (CS< 0) {
				 CS = nums[i];
			 }else {
				 CS +=nums[i];
			 }
			 if (CS> M) M=CS;
			 
		}//for
	    	return M;
	    	
    }//maxSubArray

    @Test
    public void test_1() {
    		int nums[] = { -3,4,-1,2,1,-5,4};
    		MaximumSumSubarray algo = new MaximumSumSubarray();
    		Assert.assertTrue(algo.maxSubArray(nums) ==6);
    }
    @Test
    public void test_2() {
    		int nums[] = { -3,4};
    		MaximumSumSubarray algo = new MaximumSumSubarray();
    		Assert.assertTrue(algo.maxSubArray(nums) ==4);
    }
    @Test
    public void test_3() {
    		int nums[] = { -3};
    		MaximumSumSubarray algo = new MaximumSumSubarray();
    		Assert.assertTrue(algo.maxSubArray(nums) ==-3);
    }
    @Test
    public void test_4() {
    		int nums[] = { -3,-7};
    		MaximumSumSubarray algo = new MaximumSumSubarray();
    		Assert.assertTrue(algo.maxSubArray(nums) ==-3);
    }
}
