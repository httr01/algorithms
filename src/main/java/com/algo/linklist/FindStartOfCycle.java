package com.algo.linklist;

import org.junit.Assert;
import org.junit.Test;

public class FindStartOfCycle {
	public class Node{
		int val;
		Node next;
		public Node(int v, Node n) {
			val = v;
			next =n;
		}
	}//node
	
	public int isCycle(Node root) {
		if (root == null) 
				return -1;
		Node pSlow = root;
		Node pFast = root;
		boolean doloop = true;
		while (doloop) {
			pSlow =  pSlow.next;
			pFast = pFast.next.next;	
			doloop=pSlow != pFast;
		}//while
		// pointing to same node;
		pSlow =  root;
		while (pSlow != pFast) {
			pSlow =  pSlow.next;
			pFast = pFast.next;		
		}	
		return pSlow.val;
		
	}//isCycle
	
	@Test
	public void test_1() {
		Node n7 = new Node(7,null);
		Node n6 = new Node(6,n7);
		Node n5 = new Node(5,n6);
		Node n4 = new Node(4,n5);
		Node n3 = new Node(3,n4);
		
		 
		Node n2 = new Node(2,n3);
		Node n1 = new Node(1,n2);
		Node root_0 = new Node(0,n1);
		n7.next = n3;
	
		FindStartOfCycle algo =  new FindStartOfCycle();
		Assert.assertEquals(3, algo.isCycle(root_0));
	}
	@Test
	public void test_2() {
		Node n7 = new Node(7,null);
		Node n6 = new Node(6,n7);
		Node n5 = new Node(5,n6);
		Node n4 = new Node(4,n5);
		Node n3 = new Node(3,n4);
		
		 
		Node n2 = new Node(2,n3);
		Node n1 = new Node(1,n2);
		Node root_0 = new Node(0,n1);
		n7.next = n4;
	
		FindStartOfCycle algo =  new FindStartOfCycle();
		Assert.assertEquals(4, algo.isCycle(root_0));
	}

}
