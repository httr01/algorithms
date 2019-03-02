package com.algo.graph;

import org.junit.Test;

import junit.framework.Assert;

public class ConnectedVertices {
/*** Given a undirected graph where not all the vertices are connected.
 * Find if two vertices are connected to each other
 * Find out is u and v connected in given graph
 * 
 * Example
 * 	3------2
 * 	|			0----4
 * 	|
 * 	1
 * 
 *  isConnected( 1,4) =  false
 *  isConnected( 1,3) =  true
 * ***/
	public boolean isConnected( int[][] graph, int u , int v) {
		int numberOfVertices = graph.length;
		boolean[] visited =  new boolean[numberOfVertices];
		int [] group =  new int[numberOfVertices];
		int groupNumber =-1 ;
		for (int i = 0 ;i < numberOfVertices ; ++i) {
			if (visited[i])
				continue;
			++groupNumber;
			DFS(graph,i, visited,group,groupNumber);
		} // for
		return (group[u] ==group[v]);
	}
	private void DFS(int[][] graph,int currentNode, boolean[] visited , int[] group, int groupNumber){
		if (visited[currentNode]){
			return;
		}//if
		visited[currentNode]= true;
		group[currentNode]=groupNumber;
		for (int i = 0 ;i <   graph[currentNode].length ; ++i) {
			DFS(graph,graph[currentNode][i], visited,group,groupNumber);
		}
	}//DFS
	
	/**
	 * Example
	 * 	3------2
	 * 	|			0----4
	 * 	|
	 * 	1
	 * **/
	
	@Test
	public void  test_1() {
		ConnectedVertices algo =  new ConnectedVertices();
		int[][] graph = {{4}, { 3}, {3}, { 1,2}, {0} };
		Assert.assertTrue(algo.isConnected(graph, 1, 2));
		Assert.assertTrue(algo.isConnected(graph, 1, 3));
		Assert.assertTrue(algo.isConnected(graph, 0, 4));
		Assert.assertFalse(algo.isConnected(graph, 1, 4));
		Assert.assertFalse(algo.isConnected(graph, 0, 3));
	}

	@Test
	public void  test_2() {
		ConnectedVertices algo =  new ConnectedVertices();
		int[][] graph = {{}, { 3}, {3}, { 1,2}, {} };
		Assert.assertTrue(algo.isConnected(graph, 1, 2));
		Assert.assertTrue(algo.isConnected(graph, 1, 3));
		Assert.assertFalse(algo.isConnected(graph, 1, 4));
		Assert.assertFalse(algo.isConnected(graph, 0, 3));
		Assert.assertFalse(algo.isConnected(graph, 0, 4));
	}
	
}
