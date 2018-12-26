package com.algo.tree;

import org.junit.Assert;
import org.junit.Test;
 
public class KthSmallestElement {
	 public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	public int kthSmallest(TreeNode root, int kth) {
        inorderKthSmallest(  root,   kth );
        return kthSmallest;
	}
	int kthSmallest;
	int currentSmallestIndex;
	public void inorderKthSmallest(TreeNode root, int kth  ){
		if (root == null)  return;
		inorderKthSmallest(  root.left,   kth  );
		 

		//visit current
		++currentSmallestIndex;
		if (kth == currentSmallestIndex) {
			kthSmallest = root.val;
			return;
		}
		inorderKthSmallest(  root.right,   kth  );
		 
	}
	
    @Test
    public void test_1() {
    	KthSmallestElement algo =  new KthSmallestElement();
    		int[] dataArr = {3,1,4,-1,2};
    		TreeNode root = createTree(dataArr);
    		int kthSmallest = algo.kthSmallest(root, 1);
    		 Assert.assertEquals(1,kthSmallest );	
    }
   	
    @Test
    public void test_2() {
    	KthSmallestElement algo =  new KthSmallestElement();
    		int[] dataArr = {5,3,6,2,4,-1,-1,1};
    		TreeNode root = createTree(dataArr);
    		int kthSmallest = algo.kthSmallest(root, 3);
    		 Assert.assertEquals(3,kthSmallest );	
    }    
    
    @Test
    public void test_3() {
    	KthSmallestElement algo =  new KthSmallestElement();
    		int[] dataArr = {9,3,4,-1,-1,1,-1};
    		TreeNode root = createTree(dataArr);
    		int kthSmallest = algo.kthSmallest(root, 3);
    		 Assert.assertEquals(1,kthSmallest );	
    }    
    @Test
    public void test_4() {
    	KthSmallestElement algo =  new KthSmallestElement();
    		int[] dataArr = {9,-1,-1};
    		TreeNode root = createTree(dataArr);
    		int kthSmallest = algo.kthSmallest(root, 1);
    		 Assert.assertEquals(9,kthSmallest );	
    }    
    
    @Test
    public void test_5() {
    	KthSmallestElement algo =  new KthSmallestElement();
    		int[] dataArr = {9,-1,10};
    		TreeNode root = createTree(dataArr);
    		int kthSmallest = algo.kthSmallest(root, 2);
    		 Assert.assertEquals(10,kthSmallest );	
    }   
	private TreeNode  createTree(int[] dataArr ) {
		TreeNode[] nodeObjArr =  new TreeNode[ dataArr.length];
		nodeObjArr[0] = new TreeNode(dataArr[0]);
		for (int i=0 ; i < dataArr.length/2; ++i) {
			int leftChild = 2*i+1;
			int rightChild= leftChild+1;
			if (leftChild<dataArr.length  && dataArr[leftChild]>=0) {
				nodeObjArr[i].left = new TreeNode(dataArr[leftChild]);
				nodeObjArr[leftChild] = nodeObjArr[i].left;
			}
			if (rightChild<dataArr.length  && dataArr[rightChild]>=0) {
				nodeObjArr[i].right = new TreeNode(dataArr[rightChild]);
				nodeObjArr[rightChild] = nodeObjArr[i].right;
			}
		}
		return nodeObjArr[0] ; 
	}

}
