package com.algo.tree;

import java.util.ArrayList;
 
import java.util.List;
import java.util.Objects;

 
import org.junit.Assert;
import org.junit.Test;

public class TreeTraversal {
	enum  Order  
	{
		 PRE_ORDER  ,POST_ORDER, IN_ORDER;
	}
	public  int[] order( Node root, Order order ) {
		if (root ==  null) return  null;
		List<Integer> list =  new ArrayList<>();
		
		switch(order) 
		{
			case PRE_ORDER: 
				preorder(root,list);
				break;
			case POST_ORDER: 
				postorder(root,list);
				break;
			case IN_ORDER: 
				inorder(root,list);
				break;
			default:
					
		}
		
		int[] primitive = list.stream()
				.filter(Objects::nonNull)
				.mapToInt(Integer::intValue)
				.toArray();
		
		return primitive;
		
	}
	
	private void  preorder( Node root , List<Integer>   list) {
		if (root ==  null) return ;
		list.add(root.value);
		preorder(root.left,list);
		preorder(root.right,list);
	} 
	
	private void  postorder( Node root , List<Integer>   list) {
		if (root ==  null) return ;
		postorder(root.left,list);
		postorder(root.right,list);
		list.add(root.value);
		
	} 
	private void  inorder( Node root , List<Integer>   list) {
		if (root ==  null) return ;
		inorder(root.left,list);
		list.add(root.value);
		inorder(root.right,list);
	}
	
	@Test
	public  void test_preorder_1() {
		int[] dataArr = {16,4,8,2,10,14,9,12,30};
		TreeTraversal tt= new TreeTraversal();
		int[] expected_orderDataArr = {16,4,2,12,30,10,8,14,9};
		Assert.assertArrayEquals(expected_orderDataArr, tt.order(createTree(dataArr), Order.PRE_ORDER));
	}
	
	@Test
	public  void test_preorder_2() {
		int[] dataArr = {1,7};
		TreeTraversal tt= new TreeTraversal();
		int[] expected_orderDataArr = {1,7};
		Assert.assertArrayEquals(expected_orderDataArr, tt.order(createTree(dataArr), Order.PRE_ORDER));
	}
	
	@Test
	public  void test_preorder_3() {
		int[] dataArr = {1};
		TreeTraversal tt= new TreeTraversal();
		int[] expected_preOrderDataArr = {1};
		Assert.assertArrayEquals(expected_preOrderDataArr, tt.order(createTree(dataArr), Order.PRE_ORDER));
	}
	@Test
	public  void test_preorder_4() {
		int[] dataArr = {16,4,8,2,10,14,9,12};
		TreeTraversal tt= new TreeTraversal();
		int[] expected_orderDataArr = {16,4,2,12,10,8,14,9};
		Assert.assertArrayEquals(expected_orderDataArr, tt.order(createTree(dataArr), Order.PRE_ORDER));
	}
	
	@Test
	public  void test_postorder_1() {
		int[] dataArr = {16,4,8,2,10,14,9,12,30};
		TreeTraversal tt= new TreeTraversal();
		int[] expected_preOrderDataArr = {12,30,2,10,4,14,9,8,16};
		Assert.assertArrayEquals(expected_preOrderDataArr, tt.order(createTree(dataArr), Order.POST_ORDER));
	}
	
	@Test
	public  void test_postorder_2() {
		int[] dataArr = {1,7};
		TreeTraversal tt= new TreeTraversal();
		int[] expected_orderDataArr = {7,1};
		Assert.assertArrayEquals(expected_orderDataArr, tt.order(createTree(dataArr), Order.POST_ORDER));
	}
	
	@Test
	public  void test_postorder_3() {
		int[] dataArr = {1};
		TreeTraversal tt= new TreeTraversal();
		int[] expected_preOrderDataArr = {1};
		Assert.assertArrayEquals(expected_preOrderDataArr, tt.order(createTree(dataArr), Order.POST_ORDER));
	}
	@Test
	public  void test_postorder_4() {
		int[] dataArr = {16,4,8,2,10,14,9,12};
		TreeTraversal tt= new TreeTraversal();
		int[] expected_orderDataArr = {12,2,10,4,14,9,8,16};
		Assert.assertArrayEquals(expected_orderDataArr, tt.order(createTree(dataArr), Order.POST_ORDER));
	}
	
	@Test
	public  void test_postorder_5() {
		int[] dataArr = {1,7,2};
		TreeTraversal tt= new TreeTraversal();
		int[] expected_orderDataArr = {7,2,1};
		Assert.assertArrayEquals(expected_orderDataArr, tt.order(createTree(dataArr), Order.POST_ORDER));
	}
	
	@Test
	public  void test_postorder_6() {
		int[] dataArr = {1,7,2,5};
		TreeTraversal tt= new TreeTraversal();
		int[] expected_preOrderDataArr = {5,7,2,1};
		Assert.assertArrayEquals(expected_preOrderDataArr, tt.order(createTree(dataArr), Order.POST_ORDER));
	}
	
	@Test
	public  void test_inorder_1() {
		int[] dataArr = {16,4,8,2,10,14,9,12,30};
		TreeTraversal tt= new TreeTraversal();
		int[] expected_orderDataArr = {12,2,30,4,10,16,14,8,9};
		Assert.assertArrayEquals(expected_orderDataArr, tt.order(createTree(dataArr), Order.IN_ORDER));
	}
	
	@Test
	public  void test_intorder_2() {
		int[] dataArr = {1,7};
		TreeTraversal tt= new TreeTraversal();
		int[] expected_orderDataArr = {7,1};
		Assert.assertArrayEquals(expected_orderDataArr, tt.order(createTree(dataArr), Order.IN_ORDER));
	}
	
	@Test
	public  void test_inorder_3() {
		int[] dataArr = {1};
		TreeTraversal tt= new TreeTraversal();
		int[] expected_orderDataArr = {1};
		Assert.assertArrayEquals(expected_orderDataArr, tt.order(createTree(dataArr), Order.IN_ORDER));
	}
	@Test
	public  void test_inorder_4() {
		int[] dataArr = {16,4,8,2,10,14,9,12};
		TreeTraversal tt= new TreeTraversal();
		int[] expected_orderDataArr = {12,2,4,10,16,14,8,9};
		Assert.assertArrayEquals(expected_orderDataArr, tt.order(createTree(dataArr), Order.IN_ORDER));
	}
	private Node  createTree(int[] dataArr ) {
		Node[] nodeObjArr =  new Node[ dataArr.length];
		nodeObjArr[0] = new Node(dataArr[0]);
		for (int i=0 ; i < dataArr.length/2; ++i) {
			int leftChild = 2*i+1;
			int rightChild= leftChild+1;
			if (leftChild<dataArr.length ) {
				nodeObjArr[i].left = new Node(dataArr[leftChild]);
				nodeObjArr[leftChild] = nodeObjArr[i].left;
			}
			if (rightChild<dataArr.length ) {
				nodeObjArr[i].right = new Node(dataArr[rightChild]);
				nodeObjArr[rightChild] = nodeObjArr[i].right;
			}
		}
		return nodeObjArr[0] ;
		 
	}
}
