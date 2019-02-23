package com.algo.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

/****
 * 
 * https://leetcode.com/problems/redundant-connection/
 * In this problem, a tree is an undirected graph that is connected and has no cycles.

The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N), with one additional edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.

The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] with u < v, that represents an undirected edge connecting nodes u and v.

return an edge that can be removed so that the resulting graph is a tree of N nodes. if there are multiple answers, return the answer that occurs last in the given 2D-array. The answer edge [u, v] should be in the same format, with u < v.

Example 1:
Input: [[1,2], [1,3], [2,3]]
Output: [2,3]
Explanation: The given undirected graph will be like this:
  1
 / \
2 - 3
Example 2:
Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
Output: [1,4]
Explanation: The given undirected graph will be like this:
5 - 1 - 2
    |   |
    4 - 3
Note:
The size of the input 2D-array will be between 3 and 1000.
Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.

Update (2017-09-26):
We have overhauled the problem description + test cases and specified clearly the graph is an undirected graph. For the directed graph follow up please see Redundant Connection II). We apologize for any inconvenience caused.*/
public class RedundantConnection {
	/***
	 * 1. Find all the edges in the cycle
	 * 2. Start from end of the input array  of edges and find the first which is part of the cycle. */
    public int[] findRedundantConnection(int[][] edges) {
    		int[] returnEdge = new int[2];
        List<String> mapEdgesInCycle = findEdgeInCycle(edges);
        for (int i = edges.length-1 ;i >=0; --i) { 
        		if (mapEdgesInCycle.contains(edges[i][0] + "" + edges[i][1] ) ||
        				mapEdgesInCycle.contains(edges[i][1] + "" + edges[i][0]  )) {
        			//  This edge is part of cycle
        			returnEdge[0]  = edges[i][0];
        			returnEdge[1]  = edges[i][1];
        			break;
        		}
        } //for
        return returnEdge;
    }//findRedundantConnection
    
    /**Find the edges in the cycle.
     * 1. Get all the edges
     * 2. calls a recursive function that will fill find all the edges in the cycle.**/
    private    List<String> findEdgeInCycle( int[][] edges){
		 Map<Integer, List<Integer>> mapNodeToEdges = getEdges(edges);
		 List<Integer> nodesVisited =  new ArrayList<Integer>();
		 List<String> edgesInCycle = new ArrayList<String>();
		 findEdgeInCycle(mapNodeToEdges, edges[0][0], -1,nodesVisited, edgesInCycle);
		 return edgesInCycle;
    }//findEdgeInCycle

   /** Find all the edges in the cycle
    * 1. start from any node and goal is to find start of the cycle.
    * 2. we start traversing back on the stack and add each edge in edgesInCycleMap till we find start of the cycle.
    * 3. We are using DFS, where we traverse each neighbour of a node except its parent node.**/
	private int findEdgeInCycle(Map<Integer, List<Integer>> mapNodeToEdges, int root ,int  parent , List<Integer> nodesVisited, List<String> edgesInCycleMap) {
		if (nodesVisited.contains(root) ) {
			// found in visited,  this is start of the cycle
			return root;
		}
		nodesVisited.add( root );
		List<Integer> allNeighboursList =   mapNodeToEdges.get(root);
		// if we do not find any neighbour or only neighbour is its parent
		if ((allNeighboursList ==  null || allNeighboursList.size() ==0 )
			|| ( allNeighboursList.size() ==1 && allNeighboursList.get(0).intValue() == parent)
			)
		{
			return -1;
		}
		for (int i = 0 ; i<  allNeighboursList.size();  ++i) {
			int neighbour = allNeighboursList.get(i).intValue();
			if (neighbour ==  parent)
				continue;//3. no need to consider the parent because that was our last visited node
			int cycleStartNode= findEdgeInCycle(mapNodeToEdges, neighbour, root,nodesVisited, edgesInCycleMap);
			if (cycleStartNode != -1 ) {
					edgesInCycleMap.add ( root+ ""+neighbour);
				if (cycleStartNode ==  root)//2 this is where the cycle was started
					return -1;
				else
					return cycleStartNode;
			}//if
			
		} //for
		 return -1;
	}//findEdgeInCycle
	
	private Map<Integer, List<Integer>> getEdges(int[][] edges) {
		Map<Integer, List<Integer>> edgeMap = new HashMap<Integer, List<Integer>> ();
		for (int i =0 ;i< edges.length; ++i) { 
			 addEdge(edgeMap, edges[i][0],edges[i][1]);
			 addEdge(edgeMap, edges[i][1],edges[i][0]);
		}//for
		return edgeMap;
   }//getEdges
	
   private void addEdge(Map<Integer, List<Integer>> edgeMap, int srcNode ,int destNode){
	   List<Integer> targetList = edgeMap.get(srcNode);
		if (targetList  == null) {
			targetList = new ArrayList<Integer>();
			edgeMap.put(srcNode, targetList);
		}
		if (!targetList.contains(destNode)) 
				targetList.add(destNode);
		
   }
   
   @Test
   public void  test_1() {
	   RedundantConnection algo =  new RedundantConnection();
	   int[][] edges = {{1,2}, {1,3}, {2,3}};
	   int[] adge =  algo.findRedundantConnection(edges);
	   Assert.assertEquals(2, adge.length);
	   Assert.assertEquals(2, adge[0]);
	   Assert.assertEquals(3, adge[1]);
   }
   
   @Test
   public void  test_2() {
	   RedundantConnection algo =  new RedundantConnection();
	   int[][] edges = {{1,2}, {2,3}, {3,4}, {1,4}, {1,5}};
	   int[] adge =  algo.findRedundantConnection(edges);
	   Assert.assertEquals(2, adge.length);
	   Assert.assertEquals(1, adge[0]);
	   Assert.assertEquals(4, adge[1]);
   }
   
   @Test
   public void  test_3() {
	   RedundantConnection algo =  new RedundantConnection();
	   int[][] edges = {{2,4}, {2,3}, {3,4}, {1,2}};
	   int[] adge =  algo.findRedundantConnection(edges);
	   Assert.assertEquals(2, adge.length);
	   Assert.assertEquals(3, adge[0]);
	   Assert.assertEquals(4, adge[1]);
   }

   @Test
   public void  test_4() {
	   RedundantConnection algo =  new RedundantConnection();
	   int[][] edges = {{1,4} , {3,4}, {1,3}, {2,3}};
	   int[] adge =  algo.findRedundantConnection(edges);
	   Assert.assertEquals(2, adge.length);
	   Assert.assertEquals(1, adge[0]);
	   Assert.assertEquals(3, adge[1]);
   }

}//class

