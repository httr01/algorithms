package com.algo.graph;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class GraphCycle {
	
	/*** true: if there is Cycle
	 * {{1},{2},{3}, {1}}
	 * */
	public boolean hasCycleDirected(int[][] graph) {
		if (graph.length ==0) return true;
		List<Integer> visited =  new ArrayList<Integer>();
		 Boolean hasCycle = false;
		for (int i = 0 ;i< graph.length && !hasCycle; ++i) {
			if (!visited.contains(i))
			hasCycle =  hasCycleV2( i, graph, visited );	
		} 
		return hasCycle;
		
	}
	
	private boolean hasCycleV2( int vertex, int[][] graph, List<Integer> visited ) {
		if (visited.contains(vertex))
			return true;
		visited.add(vertex);	
		//boolean hasCycle =  false;
		for (int i = 0 ; i < graph[vertex].length ; ++i) {
			if (hasCycleV2( graph[vertex][i], graph, visited )) return true;
		} // for
		return false;
	}

	
	
	
	@Test
	public void test_1_hasCycle() {
		int[][] graph= {{1},{2},{0}};
		GraphCycle algo =  new GraphCycle();
		Assert.assertTrue(algo.hasCycleDirected(graph));
	}
	
	@Test
	public void test_2_hasCycle() {
		int[][] graph= {{1},{2},{3}, {1}};
		GraphCycle algo =  new GraphCycle();
		Assert.assertTrue(algo.hasCycleDirected(graph));
	}
	
	@Test
	public void test_3_hasNoCycle() {
		int[][] graph= {{1},{2},{}};
		GraphCycle algo =  new GraphCycle();
		Assert.assertFalse(algo.hasCycleDirected(graph));
	}
	
	@Test
	public void test_4_hasCycle() {
		int[][] graph= {{},{2},{3},{1}};
		GraphCycle algo =  new GraphCycle();
		Assert.assertTrue(algo.hasCycleDirected(graph));
	}
}
