package com.algo.bit;

import org.junit.Assert;
import org.junit.Test;

/**Find if a number is power of  two.
 * Negative number is not considered power of two.
 * **/
public class PowerOfTwo {
	 public boolean isPowerOfTwo(int n) {
		 if (n<0)  return false;
		 n= Math.abs(n);
		return (n & (n-1)) ==0;
	 
	 }
	 public boolean isPowerOfTwo_v2(int n) {
		 if (n<0)  return false;
		 boolean valid = true;
		  while (valid && n>1) {
			  if (n %2 !=0 ) 
				  	valid = false;
			  n = n/2;
		  }
		  return valid && n==1;
	 }
   
	 @Test
	 public void test_1() {
		 PowerOfTwo algo =  new PowerOfTwo();
		 Assert.assertEquals(true, algo.isPowerOfTwo(2));
	 }
	 
	 @Test
	 public void test_2() {
		 PowerOfTwo algo =  new PowerOfTwo();
		 Assert.assertEquals(true, algo.isPowerOfTwo(1));
	 }
	 @Test
	 public void test_3() {
		 PowerOfTwo algo =  new PowerOfTwo();
		 Assert.assertEquals(false, algo.isPowerOfTwo(3));
	 }
	 
	 @Test
	 public void test_4() {
		 PowerOfTwo algo =  new PowerOfTwo();
		 Assert.assertEquals(true, algo.isPowerOfTwo(8));
	 }
	 
	 @Test
	 public void test_5() {
		 PowerOfTwo algo =  new PowerOfTwo();
		 Assert.assertEquals(false, algo.isPowerOfTwo(6));
	 }
	 
	 @Test
	 public void test_6() {
		 PowerOfTwo algo =  new PowerOfTwo();
		 Assert.assertEquals(false, algo.isPowerOfTwo(-2147483648));
	 }
	 
	 
	 @Test
	 public void test_7() {
		 PowerOfTwo algo =  new PowerOfTwo();
		 Assert.assertEquals(false, algo.isPowerOfTwo(-2147483646));
	 }
	 @Test
	 public void test_8() {
		 PowerOfTwo algo =  new PowerOfTwo();
		 Assert.assertEquals(false, algo.isPowerOfTwo(-16));
	 }
	 
	 @Test
	 public void test_9() {
		 PowerOfTwo algo =  new PowerOfTwo();
		 Assert.assertEquals(false, algo.isPowerOfTwo(-8));
	 }
	 
	 
}
