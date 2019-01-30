package com.algo.string;

import org.junit.Assert;
import org.junit.Test;

public class StringWithoutAAABBB {
	
	 public String strWithout3a3b(int A, int B) {
		 StringBuffer buffer =  new StringBuffer();   
		 boolean turnA =  true;
		 if (B>A) turnA = false;
		 boolean appendedForAorB =  true;
		 while ( (A>0 || B>0 ) && appendedForAorB   ) {
			 appendedForAorB =  false;
			 if (turnA) {
				 boolean tryAOneTimeFirst  = false;
				 if (B>=A+1)  tryAOneTimeFirst = true;
				 if (tryAOneTimeFirst &&  A>0) {
					 buffer.append("a");
					 A=A-1;
				 }else {
					 if (A>1) {
						 buffer.append("aa");
						 A=A-2;
					 }else if (A>0)   {
						 buffer.append("a");
						 A=A-1;
						 
					 }
				 }
				 turnA = false;
				 appendedForAorB =  true;
			 } 
			 if (!turnA){
				 boolean tryBOneTimeFirst  = false;
				 if (A>=B+1)  tryBOneTimeFirst = true;
				 if (tryBOneTimeFirst && B>0) {
					 buffer.append("b");
					 B=B-1;
				 }else {
					 if (B>1) {
						 buffer.append("bb");
						 B=B-2;
					 }else if (B>0)  {
						 buffer.append("b");
						 B=B-1;
						 
					 }
				 }
				 turnA = true; 
				 appendedForAorB =  true;
				 
			 } 
		 }
		 return buffer.toString();
	 }
	 
	 @Test
	 public void test_1() {
		 
		 StringWithoutAAABBB algo =  new StringWithoutAAABBB();
		 String real = algo.strWithout3a3b(1,2);
		 Assert.assertTrue("abb".equals(real) ||  "bba".equals(real));
	 }
	 
	 @Test
	 public void test_2() {
		 
		 StringWithoutAAABBB algo =  new StringWithoutAAABBB();
		 String real = algo.strWithout3a3b(4,1);
		 Assert.assertEquals("aabaa",real );
	 }
	 
	 @Test
	 public void test_3() {
		 
		 StringWithoutAAABBB algo =  new StringWithoutAAABBB();
		 String real = algo.strWithout3a3b(1,1);
		 Assert.assertEquals("ab",real );
	 }
	 
	 @Test
	 public void test_4() {
		 
		 StringWithoutAAABBB algo =  new StringWithoutAAABBB();
		 String real = algo.strWithout3a3b(1,2);
		 Assert.assertTrue("abb".equals(real) || "bba".equals(real) );
	 }
	 
	 @Test
	 public void test_5() {
		 
		 StringWithoutAAABBB algo =  new StringWithoutAAABBB();
		 String real = algo.strWithout3a3b(2,1);
		 Assert.assertEquals("aab",real );
	 }
	 
	 @Test
	 public void test_6() {
		 
		 StringWithoutAAABBB algo =  new StringWithoutAAABBB();
		 String real = algo.strWithout3a3b(3,3);
		 Assert.assertEquals("aabbab",real );
	 }
	 @Test
	 public void test_8() {
		 
		 StringWithoutAAABBB algo =  new StringWithoutAAABBB();
		 String real = algo.strWithout3a3b(0,2);
		 Assert.assertEquals("bb",real );
	 }
	 @Test
	 public void test_7() {
		 
		 StringWithoutAAABBB algo =  new StringWithoutAAABBB();
		 String real = algo.strWithout3a3b(2,0);
		 Assert.assertEquals("aa",real );
	 }
	 
	 @Test
	 public void test_9() {
		 
		 StringWithoutAAABBB algo =  new StringWithoutAAABBB();
		 String real = algo.strWithout3a3b(0,0);
		 Assert.assertEquals("",real );
	 }
	 
	 @Test
	 public void test_10() {
		 
		 StringWithoutAAABBB algo =  new StringWithoutAAABBB();
		 String real = algo.strWithout3a3b(1,3);
		 Assert.assertEquals("bbab",real );
	 }
	 
	 @Test
	 public void test_11() {
		 
		 StringWithoutAAABBB algo =  new StringWithoutAAABBB();
		 String real = algo.strWithout3a3b(2,5);
		 Assert.assertEquals("bbabbab",real );
	 }
	 
	 @Test
	 public void test_12() {
		 
		 StringWithoutAAABBB algo =  new StringWithoutAAABBB();
		 String real = algo.strWithout3a3b(5,2);
		 Assert.assertEquals("aabaaba",real );
	 }
	 
	 
	 @Test
	 public void test_13() {
		 
		 StringWithoutAAABBB algo =  new StringWithoutAAABBB();
		 String real = algo.strWithout3a3b(2,6);
		 Assert.assertEquals("bbabbabb",real );
	 }
}
