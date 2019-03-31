package com.algo.dp;

import org.junit.Assert;
import org.junit.Test;

public class SchedulingForMaxPoints {
	
	/*** This is scheduling problem where we have given time slots and  salary for each slot.
	 *   We need to figure out max  salary we can earn by choosing different slot such that 
	 *   we maximize the salary. We will use dynamic programming for this.
	 *   https://www.youtube.com/watch?v=cr6Ip0J9izc
	 *     **/
	//Schedule Time: { {1,3} , {2,5} , {4,6} , {6,7} , {5,8} , {}}
	//salary in $ {5,6,5,4,11}
	
	public int finsMaxPointsScheduing(int[][] schedules, int[] salary ){
		if (schedules.length == 0 || salary.length == 0 )  return 0;
		if (schedules.length == 1)  return salary[0];
		int []  profitCombine  =  arrayCopy(salary);
		int maxProfit = 0;
		mergesort(schedules, 0,schedules.length-1);
		for (int i =1; i <schedules.length ; ++i) {
				for (int j =0; j <i ; ++j) {
					int newProfit = salary[i] > salary[j] ?salary[i] :salary[j] ;;
					if (noOverlap(schedules , j,i)){
				 			newProfit = profitCombine[j] +salary[i];
					}//if 
					
					if (newProfit > profitCombine[i]) 
						profitCombine[i] = newProfit;
		 
					if (newProfit > maxProfit)  
						maxProfit = newProfit;
				}//for
		}
		return maxProfit;
	}
	
	public boolean noOverlap(int[][] schedules , int i, int j){
		return (schedules[i][1]<= schedules[j][0]);
	}
	
	//Schedule { {1,3} , {2,5} , {4,6} , {6,7} , {5,8} , {}}
	private void mergesort(int[][] schedules, int start, int end) {
		if (end<=start) return ;
		int mid = (end - start)/2;
		mergesort(schedules, start,  start+mid);
		mergesort(schedules,   start+mid+1, end);
		merge(schedules, start, start+mid, end);
	}//sort
	
	private  void  merge(final int[][]  sourceArr, int start , int mid, int end) {
		int i = 0; int j=0;
		final int[][] leftArr = fillArray(sourceArr , start, mid,  mid-start+1);
		final int[][] rightArr = fillArray(sourceArr , mid+1, end,end-mid);
		
		
		int index = start;
		while (i<mid-start+1 && j < end-mid) {
			if (leftArr[i][1] < rightArr[j][1]) {
				sourceArr[index][0] = 	leftArr[i][0];
				sourceArr[index++][1] = 	leftArr[i++][1];
			}else {
				sourceArr[index][0] = 	rightArr[j][0];
				sourceArr[index++][1] = 	rightArr[j++][1];
			}//if
			 
		}//while
		// left over from Array
		while (i<mid-start+1){
			sourceArr[index][0] = 	leftArr[i][0];
			sourceArr[index++][1] = 	leftArr[i++][1];
		}
		while (j < end-mid){
			sourceArr[index][0] = 	rightArr[j][0];
			sourceArr[index++][1] = 	rightArr[j++][1];
		}
	}//merge
	
	public int[][] fillArray(final int[][] arr ,int  start,  int end,  int size) {
			int index =0;
			int[][] target =  new int[size][2];
			for (int i = start ; i<=end ; ++i) {
				target[index][0] = arr[i][0];
				target[index++][1] = arr[i][1];
		}
			return target;
	}
	
	private int[] arrayCopy(int[] profit) {
		int[] copy = new int[profit.length];
		int index =0;
		for (int i = 0 ; i< profit.length ; ++i) {
			copy[index++] = profit[i]; 
		} 
		return copy;
	} //arrayCopy
	

	@Test
	public void test_0() {
		SchedulingForMaxPoints algo =  new SchedulingForMaxPoints();
		int[][] schedules = {   {2,5} ,{ 1,3 } };
		int[] profit		 = {5,6};
		
		Assert.assertEquals(6, algo.finsMaxPointsScheduing(schedules, profit));
	}// test 
	
	@Test
	public void test_1() {
		SchedulingForMaxPoints algo =  new SchedulingForMaxPoints();
		int[][] schedules = { {1,3} , {2,5} , {4,6} , {6,7}  ,{5,8},{7,9}  };
		int[] profit		 = {5,6,5,4,11,2};
		
		Assert.assertEquals(17, algo.finsMaxPointsScheduing(schedules, profit));
	}// test 
	
	@Test
	public void test_2() {
		SchedulingForMaxPoints algo =  new SchedulingForMaxPoints();
		int[][] schedules = { {4,6} , {1,3} , {6,7}  ,{5,8},{7,9}, {2,5}  };
		int[] profit		 = {5,6,5,4,11,2};
		Assert.assertEquals(17, algo.finsMaxPointsScheduing(schedules, profit));
	}// test 
	@Test
	public void test_3() {
		SchedulingForMaxPoints algo =  new SchedulingForMaxPoints();
		int[][] schedules = {   {2,5}   };
		int[] profit		 = {6};
		
		Assert.assertEquals(6, algo.finsMaxPointsScheduing(schedules, profit));
	}// test 
	
	@Test
	public void test_4() {
		SchedulingForMaxPoints algo =  new SchedulingForMaxPoints();
		int[][] schedules = {     };
		int[] profit		 = {};
		
		Assert.assertEquals(0, algo.finsMaxPointsScheduing(schedules, profit));
	}// test

}