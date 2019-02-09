package com.algo.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

/***
 * https://leetcode.com/problems/minimum-height-trees/
 * 
 * for an undirected graph with tree characteristics, we can choose any node as the root. 
 * The result graph is then a rooted tree. Among all possible rooted trees, 
 * those with minimum height are called minimum height trees (MHTs). 
 * Given such a graph, write a function to find all the MHTs and return a list of their root labels.

Format
The graph contains n nodes which are labeled from 0 to n - 1. 
You will be given the number n and a list of undirected edges (each edge is a pair of labels).

You can assume that no duplicate edges will appear in edges. 
Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Example 1 :

Input: n = 4, edges = [[1, 0], [1, 2], [1, 3]]

        0
        |
        1
       / \
      2   3 

Output: [1]
Example 2 :

Input: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

     0  1  2
      \ | /
        3
        |
        4
        |
        5 

Output: [3, 4]
Note:

According to the definition of tree on Wikipedia: “
a tree is an undirected graph in which any two vertices are connected by exactly one path.
 In other words, any connected graph without simple cycles is a tree.”
The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
**/
public class MinimumHeightTrees {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer,List<Integer>> mapNodeToNext = new HashMap<Integer,List<Integer>>();
		for (int i= 0 ;i < edges.length; ++i) {
			int key =  edges[i][0];
			int nextNode = edges[i][1];
			List<Integer> nextNodes =  mapNodeToNext.get(key);
				
			if (nextNodes != null && !nextNodes.contains(nextNode)) 
				nextNodes.add(nextNode);
			else {
				nextNodes = new ArrayList<Integer>();
				nextNodes.add(nextNode);
			}
			mapNodeToNext.put(key, nextNodes);
			//  add opposite node
			int  temp =key;
			key = nextNode;
			nextNode = temp;
			nextNodes =  mapNodeToNext.get(key);		
			if (nextNodes != null && !nextNodes.contains(nextNode)) {
				nextNodes.add(nextNode);
			}else {
				nextNodes = new ArrayList<Integer>();
				nextNodes.add(nextNode);
			}//if
			mapNodeToNext.put(key, nextNodes);
		} //for     
		List<Integer> minNodeValueList =  new ArrayList<Integer>();
		int minPathLengthtoLeaf = Integer.MAX_VALUE;
		for (int i = 0 ; i<n; ++i) {
			List<Integer> visitedNodeListi =  new ArrayList<Integer>();
			visitedNodeListi.add(i);
			int maxLength = findMaxLength(visitedNodeListi , i,mapNodeToNext);
			if (maxLength< minPathLengthtoLeaf){
				minNodeValueList.clear();
				minNodeValueList.add(i);
				minPathLengthtoLeaf = 	maxLength;
			}else if  (maxLength== minPathLengthtoLeaf && !minNodeValueList.contains(i)){
				minNodeValueList.add (i);
				minPathLengthtoLeaf = 	maxLength;
			}//if
			
		} //for   
		return minNodeValueList;
   }

	private int findMaxLength(List<Integer> visitedNodeListToIgnore, int srcNodeInt , Map<Integer,List<Integer>> mapNodeToNext){
		int currentMinPathLengthtoLeaf = 0;
		List<Integer> currNextNodesList = getExcept(visitedNodeListToIgnore , srcNodeInt, mapNodeToNext);
			if (currNextNodesList.size() >0)
				++currentMinPathLengthtoLeaf;
			int minFromChildNode=Integer.MAX_VALUE;
			for (int i = 0 ; i < currNextNodesList.size(); ++i) {
				visitedNodeListToIgnore.add(currNextNodesList.get(i))	;
				int currMin = findMaxLength ( visitedNodeListToIgnore,currNextNodesList.get(i),mapNodeToNext);
				if (currMin< minFromChildNode)
					minFromChildNode = currMin;
			}//for
		if (currNextNodesList.size() >0) {
			return minFromChildNode+ currentMinPathLengthtoLeaf;
			
		}else {
			return currentMinPathLengthtoLeaf;
		}
		 
	}//findMaxLength

	private List<Integer> getExcept(List<Integer> visitedNodeListToIgnore, int srcNodeInt , Map<Integer,List<Integer>> mapNodeToNext){
		//get from mapNodeToNext and remove visitedNodeListi if present
		List<Integer> finalNextNodeList = new ArrayList<Integer>();	
		List<Integer> nextNodeList = mapNodeToNext.get(srcNodeInt);
		if (nextNodeList ==  null)  return finalNextNodeList;
		for (Integer i:nextNodeList){
			if (!visitedNodeListToIgnore.contains(i)) {
				finalNextNodeList.add(i);
			}
		} // for
		return finalNextNodeList;
	}//getExcept

    
	
	@Test
	public void test_1() {
		int n =4;
		int[][] edges= {{1, 0}, {1, 2}, {1, 3}};
		MinimumHeightTrees algo = new MinimumHeightTrees();
		List<Integer> nodes = algo.findMinHeightTrees(n, edges);
		Assert.assertEquals(1 , nodes.size() );
		Assert.assertEquals(1 , nodes.get(0).intValue()); 
	}
	
	@Test
	public void test_2() {
		int n =6;
		int[][] edges= {{0, 3}, {1, 3}, {2, 3},  {4,3}, {5,4}};
		MinimumHeightTrees algo = new MinimumHeightTrees();
		List<Integer> nodes = algo.findMinHeightTrees(n, edges);
		Assert.assertEquals(2 , nodes.size() );
		Assert.assertEquals(3 , nodes.get(0).intValue()); 
		Assert.assertEquals(4 , nodes.get(1).intValue());
	}
	
	

	@Test
	public void test_3() {
		int n =2;
		int[][] edges= {{0, 1}};
		MinimumHeightTrees algo = new MinimumHeightTrees();
		List<Integer> nodes = algo.findMinHeightTrees(n, edges);
		Assert.assertEquals(2 , nodes.size() );
		Assert.assertEquals(0 , nodes.get(0).intValue()); 
		Assert.assertEquals(1 , nodes.get(1).intValue());
	}
	
	@Test
	public void test_4() {
		int n =3;
		int[][] edges= {{0, 1},{ 1,2}};
		MinimumHeightTrees algo = new MinimumHeightTrees();
		List<Integer> nodes = algo.findMinHeightTrees(n, edges);
		Assert.assertEquals(1 , nodes.size() );
		Assert.assertEquals(1 , nodes.get(0).intValue());	
	}
	
	@Test
	public void test_5() {
		int n =6;
		int[][] edges= {{0, 1},{ 1,2},{2, 3} , {1,4}, {4,5}};
		MinimumHeightTrees algo = new MinimumHeightTrees();
		List<Integer> nodes = algo.findMinHeightTrees(n, edges);
		Assert.assertEquals(3 , nodes.size() );
		Assert.assertEquals(1 , nodes.get(0).intValue()); 
		Assert.assertEquals(2 , nodes.get(1).intValue());	
		Assert.assertEquals(4 , nodes.get(2).intValue());	
	}
	@Test
	public void test_6() {
		int n =8;
		int[][] edges= {{0, 1},{ 1,2},{2, 3} , {1,4}, {4,5},{1,6}, {6,7}};
		MinimumHeightTrees algo = new MinimumHeightTrees();
		List<Integer> nodes = algo.findMinHeightTrees(n, edges);
		Assert.assertEquals(4 , nodes.size() );
		Assert.assertEquals(1 , nodes.get(0).intValue()); 
		Assert.assertEquals(2 , nodes.get(1).intValue());	
		Assert.assertEquals(4 , nodes.get(2).intValue());
		Assert.assertEquals(6 , nodes.get(3).intValue());
	}
	
	@Test
	public void test_7() {
		int n =6;
		int[][] edges= {{0, 1},{ 0,2},{0, 3} , {3,4}, {4,5}};
		MinimumHeightTrees algo = new MinimumHeightTrees();
		List<Integer> nodes = algo.findMinHeightTrees(n, edges);
		Assert.assertEquals(1 , nodes.size() );
		Assert.assertEquals(3 , nodes.get(0).intValue()); 
		
	}
	
}//class
