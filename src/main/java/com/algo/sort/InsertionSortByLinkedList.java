package com.algo.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

public class InsertionSortByLinkedList {
	/***
	 * Here is one example of how insertion sort can be implemented using LinkedList.
	 * https://leetcode.com/problems/insertion-sort-list/
	 * 
	 * **/
   public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
    }
   public ListNode insertionSortList(ListNode head) {
       if (head ==  null || head.next ==  null) return head;
       ListNode newHead  = new ListNode(head.val);
       ListNode orig =  head.next;
       
       while (orig !=null) {
    	   	   ListNode  origNextToProcess = orig.next;
	       ListNode curr = newHead, prev =  newHead;
	       //ListNode nodeToPlace= orig;
	       while ( curr!=null && orig.val > curr.val) {
	    	       prev = curr;
	    	       curr = curr.next;
	       }
	       if (prev == curr) {
	    	   		//the case when we have only one element
	    	   		newHead = orig;
	    	   		orig.next =curr;
	       }else {
	    	   	prev.next=orig;
	    	   	orig.next =curr;
	       }
	       
	       orig = origNextToProcess;
       }

       return newHead;	
   }
   @Test
   public void noNodeTestCase() {
	   int[] numArr ={};
	   int[] numArrExpected ={};
	   ListNode unorderedListHead =  generateLinkedList(numArr);
	   print(unorderedListHead);
	   ListNode orderedListHead = insertionSortList(unorderedListHead);
	   print(orderedListHead);
	   int[] orderedArray =linkListToArray(orderedListHead);
	   Assert.assertArrayEquals(numArrExpected, orderedArray);
	   System.out.println("-----------"); 
   } 
   @Test
   public void oneNodeTestCase() {
	   int[] numArr ={10};
	   int[] numArrExpected ={10};
	   ListNode unorderedListHead =  generateLinkedList(numArr);
	   print(unorderedListHead);
	   ListNode orderedListHead = insertionSortList(unorderedListHead);
	   print(orderedListHead);
	   int[] orderedArray =linkListToArray(orderedListHead);
	   Assert.assertArrayEquals(numArrExpected, orderedArray);
	   System.out.println("-----------"); 
   }   
   @Test
   public void happyTestCase() {
	   int[] numArr ={10,5,2,7};
	   int[] numArrExpected ={2,5,7,10};
	   ListNode unorderedListHead =  generateLinkedList(numArr);
	   print(unorderedListHead);
	   ListNode orderedListHead = insertionSortList(unorderedListHead);
	   print(orderedListHead);
	   int[] orderedArray =linkListToArray(orderedListHead);
	   Assert.assertArrayEquals(numArrExpected, orderedArray);
	   System.out.println("-----------"); 
   }
   
   @Test
   public void happyTestCase_large() {
	   int[] numArr ={10,5,2,7,50,32,45,21,15,33,30,28,40,41,5,1,0};
	   int[] numArrExpected ={0,1,2,5,5,7,10,15,21,28,30,32,33,40,41,45,50};
	   ListNode unorderedListHead =  generateLinkedList(numArr);
	   print(unorderedListHead);
	   ListNode orderedListHead = insertionSortList(unorderedListHead);
	   print(orderedListHead);
	   int[] orderedArray =linkListToArray(orderedListHead);
	   Assert.assertArrayEquals(numArrExpected, orderedArray);
	   System.out.println("-----------");
	   
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
   
  
   
   private void print(ListNode node) {
	   
	   while (node !=null) {
		   System.out.print("->"+node.val);  
		   node =  node.next;
	   }
	   System.out.println("");
	   
   }
   private int[] linkListToArray(ListNode orderedListHead) {
	   
	   if (orderedListHead ==  null) {
		    int[] arr = {};
		   return arr;
	   }
	   ArrayList<Integer> list = new ArrayList<>();
	   while (orderedListHead != null) {
		   list.add(new Integer(orderedListHead.val));
		   orderedListHead =  orderedListHead.next;
	   }
	   return list.stream()
			   .mapToInt(Integer::intValue)
			   .toArray();
   }
    
}
