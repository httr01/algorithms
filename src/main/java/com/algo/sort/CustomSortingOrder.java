package com.algo.sort;

import org.junit.Assert;
import org.junit.Test;

public class CustomSortingOrder {
	/** S already sorted
	Now sort T based on sort order defined by S*/
   public String customSortString(String S, String T) {
		int[] sortingOrder = new int[26];
		for (int i =0 ;i< S.length(); ++i) {
			char c = S.charAt(i);
			sortingOrder[c-'a']=i+1;
		}
		
		char[] t_CharArray = T.toCharArray();

		//char[] sortedChars = mergeSort(sortingOrder,t_CharArray,0, t_CharArray.length-1);
		heapSort( sortingOrder,  t_CharArray);
		return String.copyValueOf(t_CharArray);

    }//customSortString
   
   public void heapSort(int[] sortingOrder,char[] t_CharArray) {
	   heapify(sortingOrder,t_CharArray);
	   int heapLength = t_CharArray.length;
	   for (int i =0 ; i<heapLength; ++i) {
		   //char minItem =  t_CharArray[0];
		   swap(t_CharArray, 0,heapLength-1);
		   --heapLength;
		   heapify(  sortingOrder, t_CharArray,  0,   heapLength);
		   
	   }
   }
   
   private void heapify(int[] sortingOrder, char[] t_CharArray) {
	   
	   for (int i=t_CharArray.length/2-1 ;i>=0 ;--i ) {
		   heapify(sortingOrder,t_CharArray,i,t_CharArray.length);
	   }//for
	   
   }
   //max heapify
   private void heapify(int[] sortingOrder, char[] t_CharArray,int i, int heapLength) {
	   
	   int left = 2*i+1;
	   int right = left+1;
	   if (left>heapLength)
		   return;
	   boolean compareBoth = false, compareLeft = false, compareRight=false;
	   if (right < heapLength && sortingOrder[t_CharArray[i] -'a'] !=0) {
		   if (  sortingOrder[t_CharArray[right] -'a'] !=0 && sortingOrder[t_CharArray[left] -'a'] !=0) {
			   compareBoth = true;
		   }else if (  sortingOrder[t_CharArray[right] -'a'] !=0 ) {
			   compareRight=  true;
		   }else if (  sortingOrder[t_CharArray[left] -'a'] !=0) {
			   compareLeft=  true;
		   }
	   }else if (left < heapLength && sortingOrder[t_CharArray[i] -'a'] !=0) {
		   if ( sortingOrder[t_CharArray[i] -'a'] !=0) {
			   compareLeft=  true;
		   }
	   }
	   
	   if (compareBoth) {
		   //both child
		   int orderL_i = sortingOrder[t_CharArray[left] -'a']- sortingOrder[t_CharArray[i] -'a'];
		   int  orderL_R =sortingOrder[t_CharArray[left] -'a']- sortingOrder[t_CharArray[right] -'a'];
		   
		   int orderR_i = sortingOrder[t_CharArray[right] -'a']- sortingOrder[t_CharArray[i] -'a'];
		   int  orderR_L =sortingOrder[t_CharArray[right] -'a']- sortingOrder[t_CharArray[left] -'a'];
		   if (orderL_i>0 &&orderL_R>0) {
			   swap(t_CharArray, left,i);
			   heapify(  sortingOrder, t_CharArray,  left,   heapLength);
		   } else if (orderR_i>0 &&orderR_L>0) {
			   swap(t_CharArray, right,i);
			   heapify(  sortingOrder, t_CharArray,  right,   heapLength);
		   }
					  
	   }else if (compareLeft) {
		   int orderL_i = sortingOrder[t_CharArray[left] -'a']- sortingOrder[t_CharArray[i] -'a'];
		   
		   if (orderL_i>0  ) {
			   swap(t_CharArray, left,i);
			   heapify(  sortingOrder, t_CharArray,  left,   heapLength);
		   }
	   }else if (compareRight) {
		   int orderR_i = sortingOrder[t_CharArray[right] -'a']- sortingOrder[t_CharArray[i] -'a'];
		   
		   if (orderR_i>0  ) {
			   swap(t_CharArray, right,i);
			   heapify(  sortingOrder, t_CharArray,  right,   heapLength);
		   }
	   }
	   
   }
   
   private void swap(char[] t_CharArray,int i, int j) {
	   char temp = t_CharArray[i];
	   t_CharArray[i] = t_CharArray[j];
	   t_CharArray[j] = temp;
   }
   
   public char[] mergeSort(int[] sortingOrder,char[] t_CharArray , int start, int end) {
		if (start == end  ) {
			// nothing to sort
			char[] newArr =  new char[1];
			newArr[0] = t_CharArray[start];
			return newArr;
		}

		int mid = start + (end-start)/2;
		char[] leftSortedArr = mergeSort( sortingOrder, t_CharArray ,   start,   mid);
		char[] rightSortedArr =mergeSort( sortingOrder, t_CharArray ,   mid+1,   end);
		
		char[] sortedArr = merge(sortingOrder, leftSortedArr,rightSortedArr);
		return sortedArr;
   }//merge  sort

   private char[] merge(int[] sortingOrder, char[] leftSortedArr, char [] rightSortedArr) {
		char[] sortedArr = new char[leftSortedArr.length +rightSortedArr.length];	
		int sortedIndex = 0;
		
		int leftIndex = 0;
		int rightIndex =0;
		while (leftIndex<leftSortedArr.length && rightIndex<rightSortedArr.length ) {
			if (sortingOrder [leftSortedArr[leftIndex]-'a' ] ==0 ) {
				// not part of sorting order
				sortedArr[sortedIndex++]=leftSortedArr[leftIndex++];
				continue;
			}
			if (sortingOrder [rightSortedArr[rightIndex]-'a' ] ==0){
				//sortedArr[sortedIndex++]=rightSortedArr[rightIndex++];
				sortedArr[sortedIndex++]=leftSortedArr[leftIndex++];
				continue;
			}
			int order = sortingOrder [leftSortedArr[leftIndex]-'a' ] -  sortingOrder [rightSortedArr[rightIndex]-'a' ];
			
			if (order> 0  ){
				sortedArr[sortedIndex++]=rightSortedArr[rightIndex++];
			}else {
				sortedArr[sortedIndex++]=leftSortedArr[leftIndex++];
			}
		}//while
		
		while (leftIndex<leftSortedArr.length) {
			sortedArr[sortedIndex++]=leftSortedArr[leftIndex++];
		}
		
		while (rightIndex<rightSortedArr.length){
			sortedArr[sortedIndex++]=rightSortedArr[rightIndex++];
		}
		return sortedArr;
   }//merge
   
   @Test
   public void test_0() {
	   String  S = "ba";
	   String  T = "ab";
	   CustomSortingOrder algo =  new CustomSortingOrder();
	   String actual = algo.customSortString(S, T);
	   Assert.assertEquals("ba", actual);
   }
   
   @Test
   public void test_1() {
	   String  S = "ba";
	   String T= "abd";
	   CustomSortingOrder algo =  new CustomSortingOrder();
	   String actual = algo.customSortString(S, T);
	   Assert.assertEquals("bad", actual);
   }
   @Test
   public void test_2() {
	   String  S = "cba";
	   String T= "abcd";
	   CustomSortingOrder algo =  new CustomSortingOrder();
	   String actual = algo.customSortString(S, T);
	   Assert.assertEquals(  "cbad", actual);
   }
   
   
   @Test
   public void test_3() {
	   String  S = "cba";
	   String T= "abdc";
	   CustomSortingOrder algo =  new CustomSortingOrder();
	   String actual = algo.customSortString(S, T);
	   Assert.assertEquals("dcba", actual);
   }
   
   @Test
   public void test_4() {
	   String  S = "cba";
	   String T= "abddc";
	   CustomSortingOrder algo =  new CustomSortingOrder();
	   String actual = algo.customSortString(S, T);
	   Assert.assertEquals("baddc", actual);
   }
   
   @Test
   public void test_5() {
	   String  S = "cba";
	   String T= "abddcf";
	   CustomSortingOrder algo =  new CustomSortingOrder();
	   String actual = algo.customSortString(S, T);
	   Assert.assertEquals("baddcf", actual);
   }
   
   @Test
   public void test_6() {
	   String  S = "cb";
	   String T= "abddcf";
	   CustomSortingOrder algo =  new CustomSortingOrder();
	   String actual = algo.customSortString(S, T);
	   Assert.assertEquals("abddcf", actual);
   }
   /*
    * 
    * Input:
	"hwokrzpb"
	"hbwqpozrkp"
	Output:
	"hwokrzpbqp"
	Expected:
	"hwokrzppbq"
*/
}

