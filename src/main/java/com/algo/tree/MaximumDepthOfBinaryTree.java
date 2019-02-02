package com.algo.tree;
/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * 
 * Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],
**/

import org.junit.Test;

import junit.framework.Assert;

public class MaximumDepthOfBinaryTree {

	  public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	  public int maxDepth(TreeNode root) {
	        return maxDepth(root, 0, 0);
	    }//maxDepth

	  private int maxDepth(TreeNode currNode, int currDepth, int maxDepthTillNow) {
	        
			if (currNode ==  null) {
				return  maxDepthTillNow >currDepth ?maxDepthTillNow :currDepth;
			} 
			int leftMaxDepth =  maxDepth(currNode.left, currDepth+1, maxDepthTillNow);
			int rightMaxDepth =  maxDepth(currNode.right, currDepth+1, maxDepthTillNow);
			return leftMaxDepth >rightMaxDepth ?leftMaxDepth:rightMaxDepth;

		}//maxDepth
		
	  
	  @Test
	  public void test_1_leftMax(){
		  TreeNode root = new TreeNode  (3);
		  TreeNode N7 = new TreeNode  (7);
		  TreeNode N5 = new TreeNode  (7);
		  TreeNode N8 = new TreeNode  (8);
		  TreeNode N2 = new TreeNode  (2);
		  N2.left=N7;
		  N2.right=N5;
		  root.left=N2;
		  root.right=N8;
		  MaximumDepthOfBinaryTree algo=   new MaximumDepthOfBinaryTree();
		  Assert.assertEquals(3,  algo.maxDepth(root));
	  }
	  @Test
	  public void test_2_rightNull(){
		  TreeNode root = new TreeNode  (3);
		  TreeNode N7 = new TreeNode  (7);
		  TreeNode N5 = new TreeNode  (7);
		  TreeNode N2 = new TreeNode  (2);
		  N2.left=N7;
		  N2.right=N5;
		  root.left=N2;
		  MaximumDepthOfBinaryTree algo=   new MaximumDepthOfBinaryTree();
		  Assert.assertEquals(3,  algo.maxDepth(root));
	  }
	  
	  @Test
	  public void test_3_leftNull(){
		  TreeNode root = new TreeNode  (3);
	 	  TreeNode N8 = new TreeNode  (8);
		  root.right=N8;
		  MaximumDepthOfBinaryTree algo=   new MaximumDepthOfBinaryTree();
		  Assert.assertEquals(2,  algo.maxDepth(root));
	  }
	  
	  @Test
	  public void test_5_RightMax(){
		  TreeNode root = new TreeNode  (3);
		  TreeNode N7 = new TreeNode  (7);
		  TreeNode N5 = new TreeNode  (7);
		  TreeNode N8 = new TreeNode  (8);
		  TreeNode N2 = new TreeNode  (2);
		  N2.left=N7;
		  N2.right=N5;
		  root.left=N8;
		  root.right=N2;
		  MaximumDepthOfBinaryTree algo=   new MaximumDepthOfBinaryTree();
		  Assert.assertEquals(3,  algo.maxDepth(root));
	  }
	  
	  @Test
	  public void test_3_nullRoot(){
		   
		  MaximumDepthOfBinaryTree algo=   new MaximumDepthOfBinaryTree();
		  Assert.assertEquals(0,  algo.maxDepth(null));
	  }
	  
	 
}
