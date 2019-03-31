package com.algo.dp;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class TopologicalSortGraphFindOrder {
	public class Vertex{
		char value;
		Vertex[] adjcencyVertex;
		public Vertex(char v,Vertex[] a ) {
			this.value =v;
			this.adjcencyVertex =a;
		}
	}
	/** This is a problem where we have graph of dependency.  
	 * We need to find the order in which dependency can be processes.
	 * We will pick any one of the vertex and run DFS with it.
	 * O ( V + E ) 
	 * **/
	public char[] findDepedencyOrderDFS(Vertex[] graph) {
		Set<Vertex>  visited =  new HashSet<Vertex>();
		Stack<Vertex> vstack =  new Stack<Vertex>() ;
		for (int i= 0 ; i<graph.length ; ++i) {
			if (visited.contains(graph[i]))
				continue;
			explore(graph[i], visited,vstack);
			
		} //for	
		char[] depSeq =  new char[vstack.size()];
		int index = 0;
		while (!vstack.isEmpty ()) {
			depSeq[index++] = vstack.pop().value;
		}	
				return depSeq;
	}//findDepedencyOrder
	
	private void explore(Vertex v,  Set<Vertex> visited , Stack<Vertex> vstack) {
		if (visited.contains(v)) 
			return;
		visited.add(v);
		for (int i = 0 ; v.adjcencyVertex!= null && i < v.adjcencyVertex.length  ; ++i) {
			Vertex currV =  v.adjcencyVertex[i];
			if (visited.contains(currV)) 
				continue;
			explore(currV,visited, vstack);
		}// for	
		vstack.add(v);	
	}//explore

	@Test
	public void test_1() {
		TopologicalSortGraphFindOrder algo =  new TopologicalSortGraphFindOrder();	
		Vertex[] graph = new Vertex[8];
		Vertex vh =  new Vertex('h', null);
		Vertex vg =  new Vertex('g', null);
		Vertex[] vg_f = {vg};
		Vertex vf =  new Vertex('f',vg_f    ) ;
		Vertex[] vg_e = {vh, vf};
		Vertex ve =  new Vertex('e', vg_e);	
		Vertex[] vg_c = {ve};
		Vertex vc =  new Vertex('c',vg_c    ) ;
		Vertex[] vg_d = {vf};
		Vertex vd =  new Vertex('d',vg_d    ) ;
		Vertex[] vg_b = {vc, vd};
		Vertex vb =  new Vertex('b', vg_b);
		Vertex[] vg_a = {vc};
		Vertex va =  new Vertex('a',vg_a    ) ;
		graph[0]=va;
		graph[1]=vb;
		graph[2]=vc;
		graph[3]=vd;
		graph[4]=ve;
		graph[5]=vf;
		graph[6]=vg;
		graph[7]=vh;
		char[] depPath = algo.findDepedencyOrderDFS(graph);
		Assert.assertEquals(8, depPath.length);
		Assert.assertEquals('h', depPath[7]);
		Assert.assertEquals('g', depPath[6]);
		Assert.assertEquals('g', depPath[6]);
	}
}
