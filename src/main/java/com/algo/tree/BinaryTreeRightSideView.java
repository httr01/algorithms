package com.algo.tree;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.algo.tree.ConvertBSTToGreaterTree.TreeNode;

import junit.framework.Assert;

/**
 * Binary Tree Right Side View
 https://leetcode.com/problems/binary-tree-right-side-view/
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---**/


/** We can do BFS  and pick right most node.
 * #1 start with root node
 * #2 Maintain a queue of nodes at each level of the tree. The first element in the queue will be right most element
 * **/
public class BinaryTreeRightSideView {
	  public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	
	 
	  List<Integer> rightSideInt = new ArrayList<>();
	  
	    public List<Integer> rightSideView(TreeNode root) {
	        if (root ==  null)
	        		return rightSideInt;
	        List<TreeNode> queue =  new ArrayList<>();
	        queue.add (root); // #1
	        while (!queue.isEmpty())	 {
		        	TreeNode nodeForrightSideView = queue.get(0);
		        	rightSideInt.add(nodeForrightSideView.val);
		        	List<TreeNode> tempQueue =  new ArrayList<>();
		        // #2 Go through each element at same level of the tree.
		        	for (TreeNode node: queue){
		        		 //#2 : add right most element first 
		        		if (node.right !=  null)
		        			tempQueue.add(node.right);
		        		// if  there is no right most element, add left element
		        		if (node.left !=  null)
		        			tempQueue.add(node.left);
		        		 
		        	}//
		        	// Assign list of nodes for next level.
		        	queue= tempQueue ;
		         
	        }//while
	        return rightSideInt;
	    }

    
    @Test
    	public void test_1(){
    		BinaryTreeRightSideView  algo =  new BinaryTreeRightSideView();
    		TreeNode root=  new TreeNode(1);
			TreeNode n2=  new TreeNode(2);
			TreeNode n5=  new TreeNode(5);
			TreeNode n4=  new TreeNode(4);
			n2.right = n5;
			TreeNode n3=  new TreeNode(3);
			n3.right = n4;
			root.left = n2;
			root.right = n3;
			List<Integer>  rightSideInt =  algo.rightSideView(root);
			Assert.assertEquals(3, rightSideInt.size());
			Assert.assertEquals(1, rightSideInt.get(0).intValue());
			Assert.assertEquals(3, rightSideInt.get(1).intValue());
			Assert.assertEquals(4, rightSideInt.get(2).intValue());
    }
    
    @Test
    	public void test_2(){
    		BinaryTreeRightSideView  algo =  new BinaryTreeRightSideView();
    		TreeNode root=  new TreeNode(1);
			TreeNode n2=  new TreeNode(2);
			TreeNode n5=  new TreeNode(5);
			 n2.right = n5;
			TreeNode n3=  new TreeNode(3);
			 
			root.left = n2;
			root.right = n3;
			List<Integer>  rightSideInt =  algo.rightSideView(root);
			Assert.assertEquals(3, rightSideInt.size());
			Assert.assertEquals(1, rightSideInt.get(0).intValue());
			Assert.assertEquals(3, rightSideInt.get(1).intValue());
			Assert.assertEquals(5, rightSideInt.get(2).intValue());
    }

    @Test
	public void test_3(){
		BinaryTreeRightSideView  algo =  new BinaryTreeRightSideView();
		TreeNode root=  new TreeNode(1);
		TreeNode n2=  new TreeNode(2);
		TreeNode n5=  new TreeNode(5);
		 n2.right = n5;
		  
		root.left = n2;
		 List<Integer>  rightSideInt =  algo.rightSideView(root);
		Assert.assertEquals(3, rightSideInt.size());
		Assert.assertEquals(1, rightSideInt.get(0).intValue());
		Assert.assertEquals(2, rightSideInt.get(1).intValue());
		Assert.assertEquals(5, rightSideInt.get(2).intValue());
}
}
