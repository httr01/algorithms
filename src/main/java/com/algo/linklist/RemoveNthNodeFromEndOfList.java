package com.algo.linklist;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/submissions/
 * Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.

Follow up:

Could you do this in one pass?**/
public class RemoveNthNodeFromEndOfList {
	public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
}
	 public ListNode removeNthFromEnd(ListNode head, int n) {
			// count total length of list
		int length = 0;
		ListNode curr = head;
		while (curr != null) {
			++length;
			curr = curr.next;
		}
		//Boundary condition
		if (n> length) return head;
		if (n == length) 
			return head.next;
	
		//find the element index from start
		int indexFromstart = length -n ; // remove next element when we reach here int currCount = 1
		ListNode currNode = head;
		int currCount =1;
		// now travel to that element and remove it
		while (currCount<indexFromstart) {
			currNode = currNode.next;
			currCount++;
		}
	
		ListNode NodeToRemove = currNode.next;
		currNode.next = NodeToRemove.next;	
			
		return head;
	}
	
	 
	 @Test
	 public void test_1() {
		 ListNode head =  new ListNode(3);
		 head.next = new ListNode(5);
		 head.next.next= new ListNode(8);
		 RemoveNthNodeFromEndOfList  algo =  new RemoveNthNodeFromEndOfList();
		 head = algo.removeNthFromEnd(head, 2);
		 Assert.assertEquals(3, head.val);
		 Assert.assertEquals(8, head.next.val); 
	 }
	 
	 @Test
	 public void test_2() {
		 ListNode head =  new ListNode(3);
		 head.next = new ListNode(5);
		 head.next.next= new ListNode(8);
		 RemoveNthNodeFromEndOfList  algo =  new RemoveNthNodeFromEndOfList();
		 head = algo.removeNthFromEnd(head, 1);
		 Assert.assertEquals(3, head.val);
		 Assert.assertEquals(5, head.next.val); 
	 }	 
	 
	 @Test
	 public void test_3() {
		 ListNode head =  new ListNode(3); 
		 RemoveNthNodeFromEndOfList  algo =  new RemoveNthNodeFromEndOfList();
		 head = algo.removeNthFromEnd(head, 1);
		 Assert.assertNull(head);
		 
	 }	
	 
	 @Test
	 public void test_4() {
		 ListNode head =  new ListNode(3);
		 head.next = new ListNode(5);
		 RemoveNthNodeFromEndOfList  algo =  new RemoveNthNodeFromEndOfList();
		 head = algo.removeNthFromEnd(head, 1);
		 Assert.assertEquals(3, head.val);
	 }
	 
	 @Test
	 public void test_5() {
		 ListNode head =  new ListNode(3);
		 head.next = new ListNode(5);
		 head.next.next= new ListNode(8);
		 RemoveNthNodeFromEndOfList  algo =  new RemoveNthNodeFromEndOfList();
		 head = algo.removeNthFromEnd(head, 3);
		 Assert.assertEquals(5, head.val);
		 Assert.assertEquals(8, head.next.val); 
		 Assert.assertNull(head.next.next);
	 }	 
	 
		 
}
