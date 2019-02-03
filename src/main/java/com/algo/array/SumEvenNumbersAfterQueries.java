package com.algo.array;

public class SumEvenNumbersAfterQueries {
	/***
	 * https://leetcode.com/contest/weekly-contest-122/problems/sum-of-even-numbers-after-queries/
	 * 
	 * 985. Sum of Even Numbers After Queries My SubmissionsBack to Contest
User Accepted: 2279
User Tried: 2373
Total Accepted: 2328
Total Submissions: 3395
Difficulty: Easy
We have an array A of integers, and an array queries of queries.

For the i-th query val = queries[i][0], index = queries[i][1], we add val to A[index].  Then, the answer to the i-th query is the sum of the even values of A.

(Here, the given index = queries[i][1] is a 0-based index, and each query permanently modifies the array A.)

Return the answer to all queries.  Your answer array should have answer[i] as the answer to the i-th query.

 

Example 1:

Input: A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
Output: [8,6,2,4]
Explanation: 
At the beginning, the array is [1,2,3,4].
After adding 1 to A[0], the array is [2,2,3,4], and the sum of even values is 2 + 2 + 4 = 8.
After adding -3 to A[1], the array is [2,-1,3,4], and the sum of even values is 2 + 4 = 6.
After adding -4 to A[0], the array is [-2,-1,3,4], and the sum of even values is -2 + 4 = 2.
After adding 2 to A[3], the array is [-2,-1,3,6], and the sum of even values is -2 + 6 = 4.
 
 */
	/***
	 * Explanation
	 * Step1 : First get sum of the array, so we do not need to add all the array element again.
	 * Step2 : Loop through each query and calculate new sum.*/
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
    		int[] finalEvenValues =  new int[A.length];
    		//#1 Get sum of the array, So we do not have to calculate it every time
    		//   
        int sum = 0;
    		for (int i = 0;i< A.length ; ++i)  {
    			int currVal = Math.abs(A[i]);
    			if (currVal%2 ==0) // Only add even numbers to sum
    				sum+=A[i];
    		}
    		//#2
    		for (int i = 0;i< queries.length ; ++i) {
    			//
    			int index = queries[i][1];
    			int newsum=sum;
    			// Since we need to overwrite on this A[index]
    			// We need to adjust sum. This index value would have been aded in sum if it was even
    			if (A[index]%2 ==0) // 
    				newsum = sum -A[index];
    			// Add value from query array in A[index]
    			A[index] += queries[i][0] ; // add the value in the A
    			
    			// if new value is even, add it to sum
    			if (A[index]%2 ==0)
    				newsum +=A[index];
    			// This newsum becomes, ith value in final response
    			finalEvenValues[i] =  newsum;
    			
    			sum=newsum;
    			
    		}//
    		
    		 return finalEvenValues;
    		
        	
    }//sumEvenAfterQueries
    
}
