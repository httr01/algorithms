package com.algo.linklist;

import org.junit.Test;

public class ReverseOrder {
	public class Node{
		int value;
		Node next;
		public Node(int i) {
			value=i;
		}
	}
	public void printReverseOrder(Node n) {
		if (n== null) return;
			
		printReverseOrder(n.next);
		System.out.print(n.value + ",");
	}
	
	
	@Test
	public void test_1() {
		
		Node root =  new Node(3);
		root.next =  new Node(5);
		root.next.next =  new Node(15);
		ReverseOrder  algo =  new ReverseOrder();
		algo.printReverseOrder(root);
	}
}
