package com.algo.graph.dijkstra;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

/**https://leetcode.com/problems/all-paths-from-source-to-target/
 * 
 * Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order.

The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for which the edge (i, j) exists.

Example:
Input: [[1,2], [3], [3], []] 
Output: [[0,1,3],[0,2,3]] 
Explanation: The graph looks like this:
0--->1
|    |
v    v
2--->3
There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
Note:

The number of nodes in the graph will be in the range [2, 15].
You can print different paths in any order, but you should keep the order of nodes inside one path.
**/
public class AllPathsFromSourceToTarget {
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		List<Integer> pathTillNow = new ArrayList<Integer>();
		pathTillNow.add(0);
		List<List<Integer>> finalPath  = findAllPathFrom(pathTillNow, 0, graph.length-1,graph);
		return  finalPath;
	}//allPathsSourceTarget
	private List<Integer> makeCopy(List<Integer> pathList  ) {
		List<Integer> newPathList = new ArrayList<Integer>();
		
		for (Integer i:pathList) newPathList.add(i.intValue());
		return newPathList;
	}
	
	private List<List<Integer>>   findAllPathFrom( List<Integer> pathToThisNode ,int currNode, int targetNode,int[][] graph){
		if (currNode == targetNode){
			 List<List<Integer>> finalPath = new ArrayList<List<Integer>>();
			 finalPath.add(pathToThisNode);
			 return finalPath;	
		}
		List<List<Integer>> finalPath = new ArrayList<List<Integer>>();
		int[] nextNodes = graph[currNode];
		for ( int i = 0 ; i < nextNodes.length; ++i) {
			List<Integer> pathToThisNodeCopy = makeCopy(pathToThisNode); 
			int nextNode = nextNodes[i];
			pathToThisNodeCopy.add(nextNode);
			List<List<Integer>> pathThrouthThisNode =  findAllPathFrom(  pathToThisNodeCopy ,nextNode,   targetNode,graph);
			for (int j = 0 ; j < pathThrouthThisNode.size(); ++j){
				finalPath.add(pathThrouthThisNode.get(j));
			}
		}//for	

		return finalPath;

	}
	
	@Test
	public void test_1(){
		AllPathsFromSourceToTarget algo =  new AllPathsFromSourceToTarget();
		int[][] graph = {{1,2}, {3}, {3}, {}};
		List<List<Integer>> allpathFromZero = algo.allPathsSourceTarget(graph);
		Assert.assertEquals(2, allpathFromZero.size());
		Assert.assertEquals(0, allpathFromZero.get(0).get(0).intValue());
		Assert.assertEquals(1, allpathFromZero.get(0).get(1).intValue());
		Assert.assertEquals(3, allpathFromZero.get(0).get(2).intValue());
		
		Assert.assertEquals(0, allpathFromZero.get(1).get(0).intValue());
		Assert.assertEquals(2, allpathFromZero.get(1).get(1).intValue());
		Assert.assertEquals(3, allpathFromZero.get(1).get(2).intValue());
	}
	
	@Test
	public void test_2(){
		AllPathsFromSourceToTarget algo =  new AllPathsFromSourceToTarget();
		int[][] graph = {{1,2}, {2,3}, {3}, {}};
		List<List<Integer>> allpathFromZero = algo.allPathsSourceTarget(graph);
		Assert.assertEquals(3, allpathFromZero.size());
		
		Assert.assertEquals(0, allpathFromZero.get(0).get(0).intValue());
		Assert.assertEquals(1, allpathFromZero.get(0).get(1).intValue());
		Assert.assertEquals(2, allpathFromZero.get(0).get(2).intValue());
		Assert.assertEquals(3, allpathFromZero.get(0).get(3).intValue());
		
		Assert.assertEquals(0, allpathFromZero.get(1).get(0).intValue());
		Assert.assertEquals(1, allpathFromZero.get(1).get(1).intValue());
		Assert.assertEquals(3, allpathFromZero.get(1).get(2).intValue());
		
		Assert.assertEquals(0, allpathFromZero.get(2).get(0).intValue());
		Assert.assertEquals(2, allpathFromZero.get(2).get(1).intValue());
		Assert.assertEquals(3, allpathFromZero.get(2).get(2).intValue());
		
	}
	
	@Test
	public void test_3(){
		AllPathsFromSourceToTarget algo =  new AllPathsFromSourceToTarget();
		int[][] graph = {{1,2,3}, {}, {}, {}};
		List<List<Integer>> allpathFromZero = algo.allPathsSourceTarget(graph);
		Assert.assertEquals(1, allpathFromZero.size());
		
		Assert.assertEquals(0, allpathFromZero.get(0).get(0).intValue());
		Assert.assertEquals(3, allpathFromZero.get(0).get(1).intValue());
	}
	
	@Test
	public void test_4(){
		AllPathsFromSourceToTarget algo =  new AllPathsFromSourceToTarget();
		int[][] graph = {{1,2}, {}, {}, {}};
		List<List<Integer>> allpathFromZero = algo.allPathsSourceTarget(graph);
		Assert.assertEquals(0, allpathFromZero.size());
		
	}
	@Test
	public void test_5(){
		AllPathsFromSourceToTarget algo =  new AllPathsFromSourceToTarget();
		int[][] graph = {{1}, {2}, {3}, {0}};
		List<List<Integer>> allpathFromZero = algo.allPathsSourceTarget(graph);
		Assert.assertEquals(1, allpathFromZero.size());
		
		Assert.assertEquals(0, allpathFromZero.get(0).get(0).intValue());
		Assert.assertEquals(1, allpathFromZero.get(0).get(1).intValue());
		Assert.assertEquals(2, allpathFromZero.get(0).get(2).intValue());
		Assert.assertEquals(3, allpathFromZero.get(0).get(3).intValue());
		
	}

}
