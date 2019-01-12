package com.algo.dp;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class MostProfitAssignedwork {

	public class Point{
		public int d;
		public int p;
		public int p_collected;
		
		public Point(int d, int p) {
			this.d = d;
			this.p =p;
		}
	}   
		
	Point[] point_d_p = null;
	public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
	       if (worker.length ==0) return 0;
	       point_d_p = new Point[difficulty.length+1];
	       point_d_p[0] =  new Point(0,0);
	       // 0th index has profit as 0 
	        for (int i =0 ; i<difficulty.length ; ++i  ) {
	        		point_d_p[i+1] =  new Point(difficulty[i], profit[i]);
	        		
	        }// for
	       Arrays.sort(point_d_p, (a,b)->a.d-b.d);
	       Arrays.sort(worker);
	       int maxProfit = Integer.MIN_VALUE;
	       for (int i = 0 ;i <point_d_p.length ; ++i) { 
	    	   		if (point_d_p[i].p > maxProfit ) {
	    	   			point_d_p[i].p_collected = point_d_p[i].p;
	    	   			maxProfit= point_d_p[i].p;
	    	   		}else {
	    	   			point_d_p[i].p = maxProfit;
	    	   		}
	       }
	       
	       int last_big_workerIndex = 0;
	       int max_work_done =0;
		  
	      for (int i = 0 ;i <worker.length ; ++i) { 
	    	  	int foundPointIndex = find(worker[i] ,last_big_workerIndex, point_d_p.length-1 );
	    	  	 
	    	  	 if (foundPointIndex<0 || point_d_p[last_big_workerIndex].p > point_d_p[foundPointIndex].p) {
	    	  		// did not find any capability
	    	  		max_work_done +=point_d_p[last_big_workerIndex].p;
	    	  	}else {
	    	  		max_work_done +=point_d_p[foundPointIndex].p;
	    	  		last_big_workerIndex 	=foundPointIndex;
	    	  	}//if	
	    	  	 
	      } //for	
	     return max_work_done;	
}//maxProfitAssignment

	public int find(int worker  , int startPointIndex, int endPointIndex ) {
			 
		if  (startPointIndex - endPointIndex>0 ) return -1;
		
		if (startPointIndex ==  endPointIndex && worker >= point_d_p[startPointIndex].d)
			return startPointIndex;
		else if (startPointIndex == endPointIndex )
			return -1;
		
		int midPoint =startPointIndex+( endPointIndex-startPointIndex)/2+1;
		 
		if(worker >= point_d_p[midPoint].d)
			return find( worker  ,   midPoint,   endPointIndex );
		else 
			return  find(  worker  ,   startPointIndex, midPoint-1 );
		 
	}
	
	
	@Test
	public void test_1() {
		MostProfitAssignedwork algo = new MostProfitAssignedwork();
		int[] difficulty = {2,4,6,8,10};
		int[] profit = {10,20,30,40,50};
		int[] worker = {4,5,6,7};
		
		int mostProfitActual = algo.maxProfitAssignment(difficulty, profit, worker);
		Assert.assertEquals(100, mostProfitActual);
	}
	
	@Test
	public void test_2() {
		MostProfitAssignedwork algo = new MostProfitAssignedwork();
		int[] difficulty = {4,6};
		int[] profit = {20,30};
		int[] worker = {5};
		
		int mostProfitActual = algo.maxProfitAssignment(difficulty, profit, worker);
		Assert.assertEquals(20, mostProfitActual);
	}
	
	@Test
	public void test_3() {
		MostProfitAssignedwork algo = new MostProfitAssignedwork();
		int[] difficulty = {2,4,6,8,10};
		int[] profit = {10,20,30,40,50};
		int[] worker = {4,5,6,7,8,11};
		
		int mostProfitActual = algo.maxProfitAssignment(difficulty, profit, worker);
		Assert.assertEquals(190, mostProfitActual);
	}
	
	@Test
	public void test_4() {
		MostProfitAssignedwork algo = new MostProfitAssignedwork();
		int[] difficulty = {2,4,6,8,10,15};
		int[] profit = {10,20,30,40,50,60};
		int[] worker = {4,5,6,7,8,11,14};
		
		int mostProfitActual = algo.maxProfitAssignment(difficulty, profit, worker);
		Assert.assertEquals(240, mostProfitActual);
	}
	
	@Test
	public void test_5() {
		MostProfitAssignedwork algo = new MostProfitAssignedwork();
		int[] difficulty = {2,4,6,8,10,15};
		int[] profit = {10,20,30,40,50,60};
		int[] worker = {4,5,6,7,8,11,14,15};
		
		int mostProfitActual = algo.maxProfitAssignment(difficulty, profit, worker);
		Assert.assertEquals(300, mostProfitActual);
	}
	
	@Test
	public void test_6() {
				 
		MostProfitAssignedwork algo = new MostProfitAssignedwork();
		int[] difficulty = {68,35,52,47,86};
		int[] profit = {67,17,1,81,3};
		int[] worker = {92,10,85,84,82};
		
		int mostProfitActual = algo.maxProfitAssignment(difficulty, profit, worker);
		Assert.assertEquals(324, mostProfitActual);
	}
	
	@Test
	public void test_7() {
	 
				 
		MostProfitAssignedwork algo = new MostProfitAssignedwork();
		int[] difficulty = {5,50,92,21,24,70,17,63,30,53};
		int[] profit = {68,100,3,99,56,43,26,93,55,25};
		int[] worker = {96,3,55,30,11,58,68,36,26,1};
		
		int mostProfitActual = algo.maxProfitAssignment(difficulty, profit, worker);
		Assert.assertEquals(765, mostProfitActual);
	}

	
}
