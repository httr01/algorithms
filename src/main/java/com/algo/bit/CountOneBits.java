package com.algo.bit;

import org.junit.Assert;
import org.junit.Test;

/*** Count hoe many bits have 1 in a number*/
public class CountOneBits {
	//CountOneBits 
	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {
	        	int numberOfOne=0;
		int mask =1;
		int r= 0;
	
		for (int i = 1 ;i <= 32 ; ++i) {
			r= n & mask;
			if (r > 0 ) 
				++numberOfOne;
			mask=mask<<1;
		}//for
		return numberOfOne;
	 }//hammingWeight
	
	@Test
	public void test_1() {
		int n  =10;
		CountOneBits algo = new CountOneBits();
		Assert.assertEquals(2, algo.hammingWeight(n));	
	}

	@Test
	public void test_2() {
		int n  =19;
		CountOneBits algo = new CountOneBits();
		Assert.assertEquals(3, algo.hammingWeight(n));	
	}
	
	@Test
	public void test_3() {
		int n  =13;
		CountOneBits algo = new CountOneBits();
		Assert.assertEquals(3, algo.hammingWeight(n));	
	}
	
	
}//CountOneBits
