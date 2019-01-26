package com.algo.linklist;

import org.junit.Assert;
import org.junit.Test;
/**https://leetcode.com/problems/reorder-list/
 * 
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
*/
public class ReorderList {
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
	}
	 	/** Step 1 : Use two pointer to find middle of the link list.
	 	 * Step 2 : Reorder the second half , so that  last element is first in second half.
	 	 * Step 3 : Now we have pointer to last and start of the link list and  we can  mix them as asked.**/
		public void reorderList(ListNode head) {
			if (head ==  null || head.next ==  null ) return;
			//step1
	        ListNode p1= head; //  travel slow
	        ListNode p2 = head; // travel twice fast 
	        // travel till end
	        ListNode pre = null;
	         while (p1 != null && p2 != null ) {
	        	 		pre = p1;
	       	  		p1 =  p1.next;
	                p2 = p2.next;
	              if (p2 != null ) p2 = p2.next;
	              
	         }	// while
	         
	         if (pre !=null) pre.next=null;
	        // step 2 
			ListNode temp = p1;
			ListNode nextNode = temp.next;
			temp.next =  null;
			while (nextNode!=null){
			    ListNode tempNextNode = nextNode.next;
			    nextNode.next= temp;
			    temp = nextNode;
			     nextNode = tempNextNode;
			}// while;
			//step 3
	        ListNode lastIndex = temp;
	        ListNode  start = head;
	        while (start!=null && lastIndex != null) {
	        		temp =  start.next;
	        		ListNode tempLastIndexNext = lastIndex.next;
	        		start.next = lastIndex;
	            lastIndex.next = temp;
	            // get ready for next loop
	            start =  temp;
	            lastIndex =tempLastIndexNext;
	          }//while
	     }

	 
	 
	 @Test
	 public void test_1() {
		 ListNode root =  new ListNode(3);
		 root.next = new ListNode(5);
		 root.next.next= new ListNode(8);
		 
		 ReorderList  algo =  new ReorderList();
		 algo.reorderList(root);
		 Assert.assertEquals(3, root.val);
		 Assert.assertEquals(8, root.next.val);
		 Assert.assertEquals(5, root.next.next.val);
		 
	 }
	 
	 @Test
	 public void test_2() {
		 ListNode root =  new ListNode(3);
		 root.next = new ListNode(5);
		 root.next.next= new ListNode(8);
		 root.next.next.next= new ListNode(6);
		 
		 ReorderList  algo =  new ReorderList();
		 algo.reorderList(root);
		 Assert.assertEquals(3, root.val);
		 Assert.assertEquals(6, root.next.val);
		 Assert.assertEquals(5, root.next.next.val);
		 Assert.assertEquals(8, root.next.next.next.val);
		 
	 }
	 
	 @Test
	 public void test_3() {
		 ListNode root =  new ListNode(3);
		 root.next = new ListNode(5);
		 root.next.next= new ListNode(8);
		 root.next.next.next= new ListNode(6);
		 root.next.next.next.next= new ListNode(13);
		 
		 ReorderList  algo =  new ReorderList();
		 algo.reorderList(root);
		 Assert.assertEquals(3, root.val);
		 Assert.assertEquals(13, root.next.val);
		 Assert.assertEquals(5, root.next.next.val);
		 Assert.assertEquals(6, root.next.next.next.val);
		 Assert.assertEquals(8, root.next.next.next.next.val);
		 
	 }
	 
	 @Test
	 public void test_4() {
		 ListNode root =  new ListNode(3);
		 root.next = new ListNode(5);
		 ReorderList  algo =  new ReorderList();
		 algo.reorderList(root);
		 Assert.assertEquals(3, root.val);
		 Assert.assertEquals(5, root.next.val);
	}
	 
	 @Test
	 public void test_5() {
		 ListNode root =  new ListNode(3);
		  
		 ReorderList  algo =  new ReorderList();
		 algo.reorderList(root);
		 Assert.assertEquals(3, root.val);
		 
	}
	 
	 @Test
	 public void test_6() {
		 ListNode root =  new ListNode(3);
		 root.next = new ListNode(5);
		 root.next.next= new ListNode(8);
		 root.next.next.next= new ListNode(6);
		 root.next.next.next.next= new ListNode(13);
		 root.next.next.next.next.next= new ListNode(7);
		 
		 ReorderList  algo =  new ReorderList();
		 algo.reorderList(root);
		 Assert.assertEquals(3, root.val);
		 Assert.assertEquals(7, root.next.val);
		 Assert.assertEquals(5, root.next.next.val);
		 Assert.assertEquals(13, root.next.next.next.val);
		 Assert.assertEquals(8, root.next.next.next.next.val);
		 Assert.assertEquals(6, root.next.next.next.next.next.val);
		 
	 }
	 
	 @Test
	 public void test_7() {
		 ListNode root =  new ListNode(3);
		 root.next = new ListNode(5);
		 root.next.next= new ListNode(8);
		 root.next.next.next= new ListNode(6);
		 root.next.next.next.next= new ListNode(13);
		 root.next.next.next.next.next= new ListNode(7);
		 root.next.next.next.next.next.next= new ListNode(9);
		 
		 ReorderList  algo =  new ReorderList();
		 algo.reorderList(root);
		 Assert.assertEquals(3, root.val);
		 Assert.assertEquals(9, root.next.val);
		 Assert.assertEquals(5, root.next.next.val);
		 Assert.assertEquals(7, root.next.next.next.val);
		 Assert.assertEquals(8, root.next.next.next.next.val);
		 Assert.assertEquals(13, root.next.next.next.next.next.val);
		 Assert.assertEquals(6, root.next.next.next.next.next.next.val);
		 
	 }
}
