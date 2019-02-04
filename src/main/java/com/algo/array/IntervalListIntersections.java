package com.algo.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import junit.framework.Assert;

/**
 * https://leetcode.com/contest/weekly-contest-122/problems/interval-list-intersections/
 * Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

(Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)
 
Example 1:
 
Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.
 **/

/** Steps
 * 1. Start from first element 
 * 2. Select if  we found a common interval in current intervals
 * 3. Increase A 's index if We have chosen from A's array
 * 4. Increase B 's index if We have chosen from B's array**/
public class IntervalListIntersections {
	  public class Interval {
		      int start;
		      int end;
		      Interval() { start = 0; end = 0; }
		      Interval(int s, int e) { start = s; end = e; }
		  }
	 
	   public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
	       List<Interval> commonIntervalList =  new ArrayList<>(); 
	       	int i=0;
	    	   	int j=0;
	    	   	int maxStart =0;
	    	   	int minEnd= 0;
	    	   	while(i<A.length && j<B.length ) {
	    	   		  maxStart=Math.max(A[i].start,B[j].start);
	    	   		  minEnd=Math.min(A[i].end,B[j].end);
	    	   		if(minEnd >= maxStart) //#2
	    	   			commonIntervalList.add(new Interval(maxStart , minEnd));
	    	   		if (minEnd == A[i].end) ++i;//#3
	    	   		if (minEnd == B[j].end) ++j;//#4
	    	   	
	    	   		 
	    	   	}//while
	        return convert(commonIntervalList);
	    }//intervalIntersection
	    
	   public Interval[] convert(List<Interval> commonIntervalList) {
		   Interval[] intervals = new Interval[commonIntervalList.size()] ;
		   int i = 0;
		   for(Interval interval:commonIntervalList) {
			   intervals[i++] = interval;
		   }
		   return intervals;
	   }

	   @Test
	   public void test_1__onecommon() {
		   IntervalListIntersections algo = new IntervalListIntersections();
		   Interval[] A = new Interval[1];
		   Interval[]  B = new Interval[1];
		   A[0] = new Interval(0,2);
		    
		   B[0] = new Interval (1,5);
		   ;
		   Interval[]  intervals = algo.intervalIntersection(A, B);
		   Assert.assertEquals(1, intervals.length);
		   Assert.assertEquals(1, intervals[0].start);
		   Assert.assertEquals(2, intervals[0].end);
	
	   }
	   @Test
	   public void test_2__NoneCommon() {
		   IntervalListIntersections algo = new IntervalListIntersections();
		   Interval[] A = new Interval[1];
		   Interval[]  B = new Interval[1];
		   A[0] = new Interval(0,2);
		    
		   B[0] = new Interval (3,5);
		   ;
		   Interval[]  intervals = algo.intervalIntersection(A, B);
		   Assert.assertEquals(0, intervals.length);
	   }
	   @Test
	   public void test_3__onecommon() {
		   IntervalListIntersections algo = new IntervalListIntersections();
		   Interval[] A = new Interval[1];
		   Interval[]  B = new Interval[1];
		   A[0] = new Interval(0,2);
		    
		   B[0] = new Interval (2,5);
		 
		   Interval[]  intervals = algo.intervalIntersection(A, B);
		   Assert.assertEquals(1, intervals.length);
		   Assert.assertEquals(2, intervals[0].start);
		   Assert.assertEquals(2, intervals[0].end);
	
	   }
	   
	   @Test
	   public void test_4__onecommon() {
		   IntervalListIntersections algo = new IntervalListIntersections();
		   Interval[] A = new Interval[1];
		   Interval[]  B = new Interval[1];
		   A[0] = new Interval(0,0);
		    
		   B[0] = new Interval (0,0);
		 
		   Interval[]  intervals = algo.intervalIntersection(A, B);
		   Assert.assertEquals(1, intervals.length);
		   Assert.assertEquals(0, intervals[0].start);
		   Assert.assertEquals(0, intervals[0].end);
	
	   }
	   
	   
	   @Test
	   public void test_5__onecommon() {
		   IntervalListIntersections algo = new IntervalListIntersections();
		   Interval[] A = new Interval[1];
		   Interval[]  B = new Interval[1];
		   A[0] = new Interval(0,0);
		    
		   B[0] = new Interval (0,2);
		 
		   Interval[]  intervals = algo.intervalIntersection(A, B);
		   Assert.assertEquals(1, intervals.length);
		   Assert.assertEquals(0, intervals[0].start);
		   Assert.assertEquals(0, intervals[0].end);
	
	   }
	   
	   @Test
	   public void test_6__nonecommon() {
		   IntervalListIntersections algo = new IntervalListIntersections();
		   Interval[] A = new Interval[1];
		   Interval[]  B = new Interval[1];
		   A[0] = new Interval(0,0);
		    
		   B[0] = new Interval (1,2);
		 
		   Interval[]  intervals = algo.intervalIntersection(A, B);
		   Assert.assertEquals(0, intervals.length);
		   
	
	   }
	   
	   @Test
	   public void test_7() {
		   IntervalListIntersections algo = new IntervalListIntersections();
		   Interval[] A = new Interval[4];
		   Interval[]  B = new Interval[4];
		   A[0] = new Interval(0,2);
		   A[1] = new Interval(5,10);
		   A[2] = new Interval(13,23);
		   A[3] = new Interval(24,25);
		   B[0] = new Interval (1,5);
		   B[1] = new Interval (8,12);
		   B[2] = new Interval (15,24);
		   B[3] = new Interval (25,26);
		   Interval[]  intervals = algo.intervalIntersection(A, B);
		   Assert.assertEquals(6, intervals.length);
		   Assert.assertEquals(1, intervals[0].start);
		   Assert.assertEquals(2, intervals[0].end);
		   
		   Assert.assertEquals(5, intervals[1].start);
		   Assert.assertEquals(5, intervals[1].end);
		   Assert.assertEquals(8, intervals[2].start);
		   Assert.assertEquals(10, intervals[2].end);
		   
		   Assert.assertEquals(15, intervals[3].start);
		   Assert.assertEquals(23, intervals[3].end);
		   
		   Assert.assertEquals(24, intervals[4].start);
		   Assert.assertEquals(24, intervals[4].end);
		   
		   Assert.assertEquals(25, intervals[5].start);
		   Assert.assertEquals(25, intervals[5].end);
	
	   }

	   
	   @Test
	   public void test_8() {
		   IntervalListIntersections algo = new IntervalListIntersections();
		   Interval[] A = new Interval[1];
		   Interval[]  B = new Interval[2];
		   A[0] = new Interval(0,3);
		    
		   B[0] = new Interval (1,2);
		   B[1] = new Interval (3,12);
		   
		   Interval[]  intervals = algo.intervalIntersection(A, B);
		   Assert.assertEquals(2, intervals.length);
		   Assert.assertEquals(1, intervals[0].start);
		   Assert.assertEquals(2, intervals[0].end);
		   
		   Assert.assertEquals(3, intervals[1].start);
		   Assert.assertEquals(3, intervals[1].end);
		    
	
	   }
	   
	   @Test
	   public void test_9() {
		   IntervalListIntersections algo = new IntervalListIntersections();
		   Interval[] A = new Interval[1];
		   Interval[]  B = new Interval[3];
		   A[0] = new Interval(8,15);
		    
		   B[0] = new Interval (2,6);
		   B[1] = new Interval (8,10);
		   B[2] = new Interval (12,20);
		   
		   Interval[]  intervals = algo.intervalIntersection(A, B);
		   Assert.assertEquals(2, intervals.length);
		   Assert.assertEquals(8, intervals[0].start);
		   Assert.assertEquals(10, intervals[0].end);
		   
		   Assert.assertEquals(12, intervals[1].start);
		   Assert.assertEquals(15, intervals[1].end);
		    
	
	   }
	   
	   @Test
	   public void test_10() {
		   IntervalListIntersections algo = new IntervalListIntersections();
		   Interval[] A = new Interval[1];
		   Interval[]  B = new Interval[3];
		   A[0] = new Interval(1,3);
		    
		   B[0] = new Interval (2,6);
		   B[1] = new Interval (8,10);
		   B[2] = new Interval (12,20);
		   
		   Interval[]  intervals = algo.intervalIntersection(A, B);
		   Assert.assertEquals(1, intervals.length);
		   Assert.assertEquals(2, intervals[0].start);
		   Assert.assertEquals(3, intervals[0].end);
	
	   }
	   
	   @Test
	   public void test_11() {
		   IntervalListIntersections algo = new IntervalListIntersections();
		   Interval[] A = new Interval[1];
		   Interval[]  B = new Interval[3];
		   A[0] = new Interval(1,8);
		    
		   B[0] = new Interval (2,6);
		   B[1] = new Interval (8,10);
		   B[2] = new Interval (12,20);
		   
		   Interval[]  intervals = algo.intervalIntersection(A, B);
		   Assert.assertEquals(2, intervals.length);
		   Assert.assertEquals(2, intervals[0].start);
		   Assert.assertEquals(6, intervals[0].end);
		   
		   Assert.assertEquals(8, intervals[1].start);
		   Assert.assertEquals(8, intervals[1].end);
	
	   }
	   
	   @Test
	   public void test_12() {
		   IntervalListIntersections algo = new IntervalListIntersections();
		   Interval[] A = new Interval[2];
		   Interval[]  B = new Interval[4];
		   A[0] = new Interval(10,12);
		   A[1] = new Interval(18,19);
		    
		   B[0] = new Interval (1,6);
		   B[1] = new Interval (8,11);
		   B[2] = new Interval (13,17);
		   B[3] = new Interval (19,20);
		   
		   Interval[]  intervals = algo.intervalIntersection(A, B);
		   Assert.assertEquals(2, intervals.length);
		   Assert.assertEquals(10, intervals[0].start);
		   Assert.assertEquals(11, intervals[0].end);
		   
		   Assert.assertEquals(19, intervals[1].start);
		   Assert.assertEquals(19, intervals[1].end);
	
	   }
	   
	   @Test
	   public void test_13() {
		   IntervalListIntersections algo = new IntervalListIntersections();
		   Interval[] A = new Interval[3];
		   Interval[]  B = new Interval[1];
		   A[0] = new Interval(4,6);
		   A[1] = new Interval(7,8);
		   A[2] = new Interval(10,17);
		    
		   B[0] = new Interval (5,10);
		    
		   
		   Interval[]  intervals = algo.intervalIntersection(A, B);
		   Assert.assertEquals(3, intervals.length);
		   Assert.assertEquals(5, intervals[0].start);
		   Assert.assertEquals(6, intervals[0].end);
		   Assert.assertEquals(7, intervals[1].start);
		   Assert.assertEquals(8, intervals[1].end);
		   Assert.assertEquals(10, intervals[2].start);
		   Assert.assertEquals(10, intervals[2].end);
		    
	
	   }
	   
}
