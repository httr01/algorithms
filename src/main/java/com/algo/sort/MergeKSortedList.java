package com.algo.sort;

import static org.junit.Assume.assumeNoException;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

 
/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * ***/
public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
    		if (lists.length == 0) return  null;
    		int index =1;
    		// First index in the lists will always be merged array
        while (index< lists.length) {
        		lists[0] = merge(lists[0],lists[index++]);
        }
        	return  lists[0];
    }
    /**Merge B into A**/
    private ListNode merge(ListNode A, ListNode B) {
    		ListNode head =  new ListNode(0);
	    	ListNode ca = A;
	    	ListNode cb = B;
	    	ListNode mergedList = head;
	    	while (ca!=null && cb!= null) {
	    		if (ca.val <= cb.val) {
	    			mergedList.next  = new ListNode(ca.val);
	    			ca = ca.next;
	    		}else {
	    			mergedList.next = new ListNode(cb.val);
	    			cb =  cb.next;
	    		}
	    		mergedList =  mergedList.next;
	    	}
	    	while (ca != null) {
	    		mergedList.next  = new ListNode(ca.val);
	    		ca = ca.next;
	    		mergedList =  mergedList.next;
	    	}
	    	while (cb != null) {
	    		mergedList.next  = new ListNode(cb.val);
	    		cb =  cb.next;
	    		mergedList =  mergedList.next;
	    	}
	    	
	    	return head.next;
    }
   
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    
    @Test
    public void testHappyPath2() {
    	   int[] numArr1 ={8,15,18,21,25,30};
    	   int[] numArr2 ={10,17,19,20,24,28};
    	   ListNode[] listArr =  new ListNode[2];
 	   int[] numArrExpected ={8,10,15,17,18,19,20,21,24,25,28,30};
 	   
 	   listArr[0] =  generateLinkedList(numArr1);
 	   listArr[1] =  generateLinkedList(numArr2);
 	   
 	    ListNode A_sorted = mergeKLists(listArr);
 	    
		Assert.assertArrayEquals(numArrExpected, listNodeToIntArray(A_sorted));
    
    }
    @Test
    public void testHappyPath_3Array() {
    	   int[] numArr1 ={8};
    	   int[] numArr2 ={10};
    	   int[] numArr3 ={23};
    	   
    	   ListNode[] listArr =  new ListNode[3];
 	   int[] numArrExpected ={8,10,23};
 	   
 	   listArr[0] =  generateLinkedList(numArr1);
 	   listArr[1] =  generateLinkedList(numArr2);
 	   listArr[2] =  generateLinkedList(numArr3);
 	   
 	   
 	    ListNode A_sorted = mergeKLists(listArr);
 	    
		Assert.assertArrayEquals(numArrExpected, listNodeToIntArray(A_sorted));
    }  
    
    @Test
    public void testHappyPath_5Array() {
    	   int[] numArr1 ={8,15};
    	   int[] numArr2 ={10,17,30,33,35};
    	   int[] numArr3 ={23,29,31};
    	   int[] numArr4 ={45,49,50};
    	   int[] numArr5 ={40,46,48};
    	   ListNode[] listArr =  new ListNode[5];
 	   int[] numArrExpected ={8,10,15,17,23,29,30,31,33,35,40,45,46,48,49,50};
 	   
 	   listArr[0] =  generateLinkedList(numArr1);
 	   listArr[1] =  generateLinkedList(numArr2);
 	   listArr[2] =  generateLinkedList(numArr3);
 	   listArr[3] =  generateLinkedList(numArr4);
 	   listArr[4] =  generateLinkedList(numArr5);
 	   
 	    ListNode A_sorted = mergeKLists(listArr);
 	    
		Assert.assertArrayEquals(numArrExpected, listNodeToIntArray(A_sorted));
    }
    
    @Test
    public void testHappyPath_4Array() {
    	   int[] numArr1 ={8,15};
    	   int[] numArr2 ={10,17,30};
    	   int[] numArr3 ={23,29,31};
    	   int[] numArr4 ={45,49,50};
    	   ListNode[] listArr =  new ListNode[4];
 	   int[] numArrExpected ={8,10,15,17,23,29,30,31,45,49,50};
 	   
 	   listArr[0] =  generateLinkedList(numArr1);
 	   listArr[1] =  generateLinkedList(numArr2);
 	   listArr[2] =  generateLinkedList(numArr3);
 	   listArr[3] =  generateLinkedList(numArr4);
 	   
 	    ListNode A_sorted = mergeKLists(listArr);
 	    
		Assert.assertArrayEquals(numArrExpected, listNodeToIntArray(A_sorted));
    }
    @Test
    public void testHappyPath1() {
    	   int[] numArr1 ={8,15};
    	   int[] numArr2 ={10,17};
    	   ListNode[] listArr =  new ListNode[2];
 	   int[] numArrExpected ={8,10,15,17};
 	   
 	   listArr[0] =  generateLinkedList(numArr1);
 	   listArr[1] =  generateLinkedList(numArr2);
 	   
 	    ListNode A_sorted = mergeKLists(listArr);
 	    
		Assert.assertArrayEquals(numArrExpected, listNodeToIntArray(A_sorted));
    }
    @Test
    public void testHappyPath_oneElement() {
    	   int[] numArr1 ={8};
    	   int[] numArr2 ={10};
    	   ListNode[] listArr =  new ListNode[2];
 	   int[] numArrExpected ={8,10};
 	   
 	   listArr[0] =  generateLinkedList(numArr1);
 	   listArr[1] =  generateLinkedList(numArr2);
 	   
 	    ListNode A_sorted = mergeKLists(listArr);
 	    
		Assert.assertArrayEquals(numArrExpected, listNodeToIntArray(A_sorted));
    
    }
    
    @Test
    public void testHappyPath_emptyarray() {
    	   int[] numArr1 ={8};
    	   int[] numArr2 ={};
    	   ListNode[] listArr =  new ListNode[2];
 	   int[] numArrExpected ={8};
 	   
 	   listArr[0] =  generateLinkedList(numArr1);
 	   listArr[1] =  generateLinkedList(numArr2);
 	   
 	    ListNode A_sorted = mergeKLists(listArr);
 	    
		Assert.assertArrayEquals(numArrExpected, listNodeToIntArray(A_sorted));
    
    }
    
    
    private ListNode generateLinkedList(int[] data) {
 	   if (data.length ==0 ) return null;
 	   ListNode root =  new ListNode(data[0]);
 	   ListNode current =  root;
 	   for(int index =1 ; index<data.length; ++index ) {
 		   current.next = new ListNode(data[index]);
 		   current =  current.next;
 	   }
 	   return root;
    }
    
    private int[] listNodeToIntArray(ListNode root) {
    		ArrayList<Integer> arrList =  new ArrayList();
    		ListNode i = root;
    		while (i != null) {
    			arrList.add(new Integer(i.val));
    			i = i.next;
    		}
    		int[] x = new int[arrList.size()];
    		int index = 0;
    		for(Integer in: arrList) {
    			x[index++]=in.intValue();
    		}	
    		return x;

    		 
    		
    }
    

}

