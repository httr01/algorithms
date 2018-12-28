package com.algo.array;

import org.junit.Assert;
import org.junit.Test;
/***
 * https://leetcode.com/contest/weekly-contest-116/problems/n-repeated-element-in-size-2n-array/**/
public class NRepeatedElementArrayOf2N {
   
    public int repeatedNTimes(int[] A) {
        int[] elementRepetedTimes = new int[10000];
         for ( int i = 0 ;i < A.length ; ++i) {
        	 	if (elementRepetedTimes[A[i]] >0) {
        	 		// this is repeated
        	 		return A[i];
        	 	} else {
        	 		elementRepetedTimes[A[i]]  = elementRepetedTimes[A[i]]+1;
        	 	}
         }    
         return -1;
    }
    
	@Test public void test1() {
		NRepeatedElementArrayOf2N algo = new NRepeatedElementArrayOf2N();
		int[] A =  {1,2,3,3};
		Assert.assertEquals(3, algo.repeatedNTimes(A));
	}
	
	@Test public void test2() {
		NRepeatedElementArrayOf2N algo = new NRepeatedElementArrayOf2N();
		int[] A =  {2,1,2,5,3,2};
		Assert.assertEquals(2, algo.repeatedNTimes(A));
	}
	
	@Test public void test3() {
		NRepeatedElementArrayOf2N algo = new NRepeatedElementArrayOf2N();
		int[] A =  {5,1,5,2,5,3,5,4};
		Assert.assertEquals(5, algo.repeatedNTimes(A));
	}
	
}
