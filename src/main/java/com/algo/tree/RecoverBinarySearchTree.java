package com.algo.tree;

 

import org.junit.Assert;
import org.junit.Test;
 

/***
 * 
 * https://leetcode.com/problems/recover-binary-search-tree/
 * Two elements of a binary search tree (BST) are swapped by mistake.
 *Recover the tree without changing its structure.**/

public class RecoverBinarySearchTree {
 
	 public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	 
	 TreeNode fisrtNode = null;
	 TreeNode secondNode = null;
	 TreeNode previousNode = new TreeNode(Integer.MIN_VALUE);;
	 
    public void recoverTree(TreeNode root) {
    		
    		preOrderTraverse(root);
    		int temp = fisrtNode.val;
    		fisrtNode.val = secondNode.val;
    		secondNode.val= temp;
    		
    }
    
    private void preOrderTraverse(TreeNode root) {
    		if (root == null) return;
    	
    		preOrderTraverse (root.left);
    		
        if (fisrtNode == null && previousNode.val >= root.val) {
            	fisrtNode = previousNode;
        }
        
        if (fisrtNode != null && previousNode.val >= root.val) {
            secondNode = root;
        }        
        previousNode = root;
    		preOrderTraverse (root.right);
    		
    }
    
    @Test
    public void test_1() {
    		RecoverBinarySearchTree algo =  new RecoverBinarySearchTree();
    		int[] dataArr = {1,3,-1,-1,2};
    		int[] expected_orderDataArr = {3,1,-1,-1,2};
    		TreeNode root = createTree(dataArr);
    		algo.recoverTree(root);
    		int[] resultArray = new int[dataArr.length];
    		resultArray = treeToArray(root,resultArray,0);
    		 Assert.assertArrayEquals(expected_orderDataArr,resultArray );	
    }
    
    @Test
    public void test_2() {
    		RecoverBinarySearchTree algo =  new RecoverBinarySearchTree();
    		int[] dataArr = {3,1,4,-1,-1,2};
    		int[] expected_orderDataArr = {2,1,4,-1,-1,3};
    		TreeNode root = createTree(dataArr);
    		algo.recoverTree(root);
    		int[] resultArray = new int[dataArr.length];
    		resultArray = treeToArray(root,resultArray,0);
    		 Assert.assertArrayEquals(expected_orderDataArr,resultArray );	
    }
    private int[] treeToArray(TreeNode root, int[] resultArray,int index) {
    		
    		if (root == null) {
    			if (index< resultArray.length)  resultArray[index] = -1;
    			return resultArray;
    		}
    		resultArray[index] = root.val;
    		treeToArray(  root.left,  resultArray,index*2+1);
    		treeToArray(  root.right,  resultArray,index*2+1+1);
    		return resultArray;
    		
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
