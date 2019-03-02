package com.algo.tree;

import org.junit.Test;

import junit.framework.Assert;

/***
 * https://leetcode.com/problems/path-sum/
 * 
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
Note: A leaf is a node with no children.
Example:
Given the below binary tree and sum = 22,
      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
**/
public class TreePathSum {
	  public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	  
	    public boolean hasPathSum(TreeNode root, int sum) {
		    	if (  root ==  null)
		    		return false;	
		    	else if (root.val == sum  && root.left ==  null && root.right== null)
		    			return true;
		    	return hasPathSum(  root.left,   sum - root.val) || hasPathSum(  root.right,   sum - root.val);
		    		         	 
	    }//hasPathSum
	    
	    @Test
	    public void test_1() {
	    		TreePathSum  algo =  new TreePathSum();
	    		TreeNode root =  new TreeNode(15);
	    		TreeNode t8 =  new TreeNode(8);
	    		TreeNode t5 =  new TreeNode(5);
	    		TreeNode t6 =  new TreeNode(6);
	    		TreeNode t25 =  new TreeNode(25);
	    		root.right =  t25;
	    		root.left=t8;
	    		t8.right=t6;
	    		t8.left = t5;
	    	
	    		Assert.assertEquals(true, algo.hasPathSum(root, 29));
	    		Assert.assertEquals(false, algo.hasPathSum(root, 30));
	    		Assert.assertEquals(true, algo.hasPathSum(root, 28));
	    		Assert.assertEquals(false, algo.hasPathSum(root, 15));
	    		Assert.assertEquals(true, algo.hasPathSum(root, 40));
	    }
	    @Test
	    public void test_2_negative() {
	    		TreePathSum  algo =  new TreePathSum();
	    		TreeNode root =  new TreeNode(-2);
	    		TreeNode t3 =  new TreeNode(-3);
	    		root.right =  t3;
	    		Assert.assertEquals(true, algo.hasPathSum(root, -5));
	    }
	    
	    @Test
	    public void test_3_negative() {
	    		TreePathSum  algo =  new TreePathSum();
	    		TreeNode root =  new TreeNode(-8);
	    		TreeNode t3 =  new TreeNode(-3);
	    		TreeNode t9 =  new TreeNode(-9);
	    		root.right =  t3;
	    		root.left =  t9;
	    		Assert.assertEquals(true, algo.hasPathSum(root, -11));
	    		Assert.assertEquals(true, algo.hasPathSum(root, -17));
	    		Assert.assertEquals(false, algo.hasPathSum(root, -8));
	    }
	    		
	    
}//class
