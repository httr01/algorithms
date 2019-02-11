package com.algo.graph.dijkstra;

import java.util.ArrayList;
 
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

/**
 * https://leetcode.com/problems/find-eventual-safe-states/
 * In a directed graph, we start at some node and every turn, walk along a directed edge of the graph.  if we reach a node that is terminal (that is, it has no outgoing directed edges), we stop.

Now, say our starting node is eventually safe if and only if we must eventually walk to a terminal node.  More specifically, there exists a natural number K so that for any choice of where to walk, we must have stopped at a terminal node in less than K steps.

Which nodes are eventually safe?  return them as an array in sorted order.

The directed graph has N nodes with labels 0, 1, ..., N-1, where N is the length of graph.  The graph is given in the following form: graph[i] is a list of labels j such that (i, j) is a directed edge of the graph.

Example:
Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
Output: [2,4,5,6]
Here is a diagram of the above graph.

Illustration of graph

Note:

graph will have length at most 10000.
The number of edges in the graph will not exceed 32000.
Each graph[i] will be a sorted list of different integers, chosen within the range [0, graph.length - 1].***/
public class FindEventualSafeStates {
 
	 private List<Integer>  makeCopy(List<Integer>  list){
		 List<Integer>  listCopy =  new ArrayList<Integer> ();
		 for (Integer i : list) listCopy.add(i);
		 return listCopy;
	}
 
		
	/**
	 * #1: If currNodeInt does not have child nodes to go to. It is terminal node,  thus safe node
	 * #2: Maintain list prevSeenNodes and visit each child
	 * #3: if childNodeInt is in prevSeenNodes : this is cycle . 
	 * #4 : if  this child is previously determined safe child, go to next child
	 * #5 : if  this child is previously determined unsafe child, exit
	 * #6 : if  this child is previously undetermined, make recursive call to determine 
	 * #7 : If  child node have cycle: mark this node**/
	public boolean hasCycle(int currNodeInt ,int[] safeNodes, int[][] graph, List<Integer> prevSeenNodes){
		 if (graph[currNodeInt].length == 0) { //#1 Terminal node
		 		safeNodes[currNodeInt] = 1;
		 		return false;
		 }
		 boolean anyChildHasCycle = false; 
		 List<Integer>  prevSeenNodesCopy = prevSeenNodes;//makeCopy(prevSeenNodes);
		 for (int i = 0 ; i< graph[currNodeInt].length && !anyChildHasCycle ; ++i) { //#2
			 prevSeenNodes= makeCopy(prevSeenNodesCopy);
			 int childNodeInt = graph[currNodeInt][i];
			 if (safeNodes[childNodeInt]  == 0) {//#5
				 anyChildHasCycle =  true; //
				 break;
			 }else if (safeNodes[childNodeInt]  < 0) {
				 if (prevSeenNodes.contains(childNodeInt)) { //#3
					anyChildHasCycle=  true;
					break;
				 }
				 
			 	//#6
			 	prevSeenNodes.add(childNodeInt);
			 	anyChildHasCycle =  hasCycle(childNodeInt ,safeNodes,graph , prevSeenNodes);
			 	//#7
			 	safeNodes[childNodeInt] = anyChildHasCycle ?0:1;
			 }
		 }//for 
		 return anyChildHasCycle;
	}//hasCycle
	 /**
	  * #1:Maintain an array of node index  safeNodes. Here are its value
	  * -1 : not determined if this node is safe of unsafe. This is initial value.
	  *  0 : this node is unsafe
	  *  1 : This node is safe.
	  *  #2: Iterate through each undetermined node to find if it has cycle. **/
	public List<Integer> eventualSafeNodes(int[][] graph) {
		    int[] safeNodes = new int[graph.length];
		    List<Integer> safeList = new ArrayList<Integer>();
		 	for (int i=0 ;i<safeNodes.length ; ++i)   safeNodes[i]=-1;
		  	for(int i = 0 ; i< graph.length; ++i){ //#2
		 		if (safeNodes[i] <0 ){
		 			List<Integer>  prevSeenNodes= new ArrayList<Integer>();
		 			prevSeenNodes.add(i);	
		 			boolean hasCycle = hasCycle(i ,safeNodes,graph , prevSeenNodes);
		 			if (!hasCycle) {
		 				safeNodes[i]=1;
		 				safeList.add(i);
		 			}
		 		}else if (safeNodes[i] == 1 ) {
		 			safeList.add(i);
		 		} //if
		  
		  	}//for
		  	return safeList;
	}//eventualSafeNodes

	

		     
	
	 @Test
	 public void test_1() {
		 FindEventualSafeStates algo = new FindEventualSafeStates();
		 int[][] graph = {{1,2}, {2,3}, {5}, {0}, {5} , {}, {} };
		 List<Integer> safeNodesList = algo.eventualSafeNodes(graph);
		 Assert.assertEquals(4, safeNodesList.size());
		 Assert.assertEquals(2, safeNodesList.get(0).intValue());
		 Assert.assertEquals(4, safeNodesList.get(1).intValue());
		 Assert.assertEquals(5, safeNodesList.get(2).intValue());
		 Assert.assertEquals(6, safeNodesList.get(3).intValue());
	 }
	 
	 @Test
	 public void test_2_onenode() {
		 FindEventualSafeStates algo = new FindEventualSafeStates();
		 int[][] graph = {{ } };
		 List<Integer> safeNodesList = algo.eventualSafeNodes(graph);
		 Assert.assertEquals(1, safeNodesList.size());
		 Assert.assertEquals(0, safeNodesList.get(0).intValue());  
	 }
	 @Test
	 public void test_3_twonode() {
		 FindEventualSafeStates algo = new FindEventualSafeStates();
		 int[][] graph = {{0},{} };
		 List<Integer> safeNodesList = algo.eventualSafeNodes(graph);
		 Assert.assertEquals(1, safeNodesList.size());
		 Assert.assertEquals(1, safeNodesList.get(0).intValue());  
	 }
	 
	 @Test
	 public void test_4_twonode() {
		 FindEventualSafeStates algo = new FindEventualSafeStates();
		 int[][] graph = {{1},{} };
		 List<Integer> safeNodesList = algo.eventualSafeNodes(graph);
		 Assert.assertEquals(2, safeNodesList.size());
		 Assert.assertEquals(0, safeNodesList.get(0).intValue());
		 Assert.assertEquals(1, safeNodesList.get(1).intValue()); 
	 }
	 
	 @Test
	 public void test_4_fourSafeNodes() {
		 FindEventualSafeStates algo = new FindEventualSafeStates();
		 int[][] graph = {{ 1,2} , {}, {1},{} };
		 List<Integer> safeNodesList = algo.eventualSafeNodes(graph);
		 Assert.assertEquals(4, safeNodesList.size());
		 Assert.assertEquals(0, safeNodesList.get(0).intValue());
		 Assert.assertEquals(1, safeNodesList.get(1).intValue());
		 Assert.assertEquals(2, safeNodesList.get(2).intValue());
		 Assert.assertEquals(3, safeNodesList.get(3).intValue());  
	 }
	 
	 @Test
	 public void test_5() {
		 FindEventualSafeStates algo = new FindEventualSafeStates();
		 int[][] graph = {{ 1} , {0}, {1},{} };
		 List<Integer> safeNodesList = algo.eventualSafeNodes(graph);
		 Assert.assertEquals(1, safeNodesList.size());
		 Assert.assertEquals(3, safeNodesList.get(0).intValue());
	 }
	 
	 @Test
	 public void test_6() {
		 FindEventualSafeStates algo = new FindEventualSafeStates();
		 int[][] graph = {{ 1} , {}, {1},{2} };
		 List<Integer> safeNodesList = algo.eventualSafeNodes(graph);
		 Assert.assertEquals(4, safeNodesList.size());
		 Assert.assertEquals(0, safeNodesList.get(0).intValue());
		 Assert.assertEquals(1, safeNodesList.get(1).intValue());
		 Assert.assertEquals(2, safeNodesList.get(2).intValue());
		 Assert.assertEquals(3, safeNodesList.get(3).intValue()); 
	 }
	 @Test
	 public void test_7() {
		 FindEventualSafeStates algo = new FindEventualSafeStates();
		 int[][] graph = {{ 1,2,3} , {}, {1},{2}, {3}, {} };
		 List<Integer> safeNodesList = algo.eventualSafeNodes(graph);
		 Assert.assertEquals(6, safeNodesList.size());
		 Assert.assertEquals(0, safeNodesList.get(0).intValue());
		 Assert.assertEquals(1, safeNodesList.get(1).intValue());
		 Assert.assertEquals(2, safeNodesList.get(2).intValue());
		 Assert.assertEquals(3, safeNodesList.get(3).intValue());
		 Assert.assertEquals(4, safeNodesList.get(4).intValue());
		 Assert.assertEquals(5, safeNodesList.get(5).intValue());
	 }
	 
	 @Test
	 public void test_8() {
		 FindEventualSafeStates algo = new FindEventualSafeStates();
		 int[][] graph = {{ 1,2,3} , {}, {1,3},{2}, {3}, {} };
		 List<Integer> safeNodesList = algo.eventualSafeNodes(graph);
		 Assert.assertEquals(2, safeNodesList.size());
		 Assert.assertEquals(1, safeNodesList.get(0).intValue());
		 Assert.assertEquals(5, safeNodesList.get(1).intValue());
	 }
	 
	}//class

