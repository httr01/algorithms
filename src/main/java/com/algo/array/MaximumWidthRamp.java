package com.algo.array;

import org.junit.Assert;
import org.junit.Test;

public class MaximumWidthRamp {
/*****
 * https://leetcode.com/contest/weekly-contest-116/problems/maximum-width-ramp/
 *Maximum Width Ramp
User Accepted: 10
User Tried: 21
Total Accepted: 10
Total Submissions: 22
Difficulty: Medium
Given an array A of integers, a ramp is a tuple (i, j) for which i < j and A[i] <= A[j].  The width of such a ramp is j - i.

Find the maximum width of a ramp in A.  If one doesn't exist, return 0. 
 */
	
	public int maxWidthRamp(int[] A) {
		int maxWidth =0;
		for (int i =0 ; i< A.length ; ++i) {
			for (int j =A.length-1 ; j > i+maxWidth  ; --j) {
				if (A[j] >= A[i]) {
					maxWidth = j-i;
					break;
				}
			}
			
		}
		return maxWidth;
    }
	
	
	@Test public void test1() {
		MaximumWidthRamp algo = new MaximumWidthRamp();
		int[] A =  {6,0,8,2,1,5};
		Assert.assertEquals(4, algo.maxWidthRamp(A));
	}
	
	@Test public void test2() {
		MaximumWidthRamp algo = new MaximumWidthRamp();
		int[] A =  {9,8,1,0,1,9,4,0,4,1};
		Assert.assertEquals(7, algo.maxWidthRamp(A));
	}
	
	@Test 
	public void test3() {
		MaximumWidthRamp algo = new MaximumWidthRamp();
		int[] A =  {7,2};
		Assert.assertEquals(0, algo.maxWidthRamp(A));
	}
	
	@Test 
	public void test_4() {
		MaximumWidthRamp algo = new MaximumWidthRamp();
		int[] A =  {7,2,9,2,3,5,7,8,9,10};
		Assert.assertEquals(9, algo.maxWidthRamp(A));
	}

}
