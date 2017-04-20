package com.algo.graph.dijkstra;

import com.algo.graph.dijkstra.Dijkstra;
import java.util.HashSet;

public class Test {
	private Graph  getAllConnectedGraph_test2_17vertex (){
		HashSet<Vertex> graph = new HashSet<Vertex>();
		Vertex R= new Vertex("R" );
		Vertex A= new Vertex("A" );
		Vertex Q= new Vertex("Q" );
		Vertex P= new Vertex("P" );
		Vertex L= new Vertex("L" );
		Vertex B= new Vertex("B" );
		Vertex V= new Vertex("V" );
		Vertex T= new Vertex("T" );
		graph.add(A);
		graph.add(R);
		graph.add(Q);
		graph.add(P);
		graph.add(L);
		graph.add(B);
		graph.add(V);
		graph.add(T);
		
		Edge[] edgeA=  new Edge[3];
		edgeA[0] = new Edge(2,R);
		edgeA[1] = new Edge(3,Q);
		edgeA[2] = new Edge(2,P);
		A.adjEdge = edgeA;
		
		Edge[] edgeR=  new Edge[2];
		edgeR[0] = new Edge(1,L);
		edgeR[1] = new Edge(2,A);
		R.adjEdge = edgeR;

		Edge[] edgeQ=  new Edge[3];
		edgeQ[0] = new Edge(2,L);
		edgeQ[1] = new Edge(1,B);
		edgeQ[2] = new Edge(3,A);
		Q.adjEdge = edgeQ;

		Edge[] edgeP=  new Edge[2];
		edgeP[0] = new Edge(2,B);
		edgeP[1] = new Edge(2,A);
		P.adjEdge = edgeP;
		
		Edge[] edgeB=  new Edge[3];
		edgeB[0] = new Edge(1,T);
		edgeB[1] = new Edge(2,P);
		edgeB[2] = new Edge(1,Q);
		B.adjEdge = edgeB;

		Edge[] edgeT=  new Edge[3];
		edgeT[0] = new Edge(3,V);
		edgeT[1] = new Edge(4,L);
		edgeT[2] = new Edge(1,B);
		T.adjEdge = edgeT;
		

		
		Edge[] edgeL=  new Edge[4];
		edgeL[0] = new Edge(2,V);
		edgeL[1] = new Edge(4,T);
		edgeL[2] = new Edge(1,R);
		edgeL[3] = new Edge(2,Q);
		L.adjEdge = edgeL;

		Edge[] edgeV=  new Edge[2];
		edgeV[0] = new Edge(3,T);
		edgeV[1] = new Edge(2,L);
		 
		V.adjEdge = edgeV;
		
		// build graph
		Graph g =  new Graph();
		g.allVertex=graph;
		g.startingVertex=A;
		g.vertexToFind= V;
		return g;
	}
	
	
	private Graph  getAllConnectedGraph_test1 (){
		HashSet<Vertex> graph = new HashSet<Vertex>();
		Vertex R= new Vertex("R" );
		Vertex A= new Vertex("A" );
		Vertex Q= new Vertex("Q" );
		Vertex P= new Vertex("P" );
		Vertex L= new Vertex("L" );
		Vertex B= new Vertex("B" );
		Vertex V= new Vertex("V" );
		Vertex T= new Vertex("T" );
		graph.add(A);
		graph.add(R);
		graph.add(Q);
		graph.add(P);
		graph.add(L);
		graph.add(B);
		graph.add(V);
		graph.add(T);
		
		Edge[] edgeA=  new Edge[3];
		edgeA[0] = new Edge(2,R);
		edgeA[1] = new Edge(3,Q);
		edgeA[2] = new Edge(2,P);
		A.adjEdge = edgeA;
		
		Edge[] edgeR=  new Edge[2];
		edgeR[0] = new Edge(1,L);
		edgeR[1] = new Edge(2,A);
		R.adjEdge = edgeR;

		Edge[] edgeQ=  new Edge[3];
		edgeQ[0] = new Edge(2,L);
		edgeQ[1] = new Edge(1,B);
		edgeQ[2] = new Edge(3,A);
		Q.adjEdge = edgeQ;

		Edge[] edgeP=  new Edge[2];
		edgeP[0] = new Edge(2,B);
		edgeP[1] = new Edge(2,A);
		P.adjEdge = edgeP;
		
		Edge[] edgeB=  new Edge[3];
		edgeB[0] = new Edge(1,T);
		edgeB[1] = new Edge(2,P);
		edgeB[2] = new Edge(1,Q);
		B.adjEdge = edgeB;

		Edge[] edgeT=  new Edge[3];
		edgeT[0] = new Edge(3,V);
		edgeT[1] = new Edge(4,L);
		edgeT[2] = new Edge(1,B);
		T.adjEdge = edgeT;
		

		
		Edge[] edgeL=  new Edge[4];
		edgeL[0] = new Edge(2,V);
		edgeL[1] = new Edge(4,T);
		edgeL[2] = new Edge(1,R);
		edgeL[3] = new Edge(2,Q);
		L.adjEdge = edgeL;

		Edge[] edgeV=  new Edge[2];
		edgeV[0] = new Edge(3,T);
		edgeV[1] = new Edge(2,L);
		 
		V.adjEdge = edgeV;
		
		// build graph
		Graph g =  new Graph();
		g.allVertex=graph;
		g.startingVertex=A;
		g.vertexToFind= V;
		return g;
	}
	
	public void testAllConntctedGraph_test1(){
		Graph graph = getAllConnectedGraph_test1();
		
		Dijkstra dij =  new Dijkstra();
		dij.findShortestPath_v1(graph.allVertex, graph.startingVertex,graph.vertexToFind);
		
		System.out.println("\n --------------------Test------------------------------");
		long startTime= System.currentTimeMillis();
		System.out.println("\nV1 ****** \n"+(dij.findShortestPath_v1(graph.allVertex, graph.startingVertex,graph.vertexToFind)));
		System.out.println("\nV1 ****** Time Taken (mS): "+(System.currentTimeMillis()-startTime));
		
		System.out.println("\n --------------------Test------------------------------");
	    startTime= System.currentTimeMillis();
		System.out.println("\nV2 ****** \n"+(dij.findShortestPath_v2(graph.allVertex, graph.startingVertex,graph.vertexToFind)));
		System.out.println("\nV2 ****** Time Taken (mS): "+(System.currentTimeMillis()-startTime));
		System.out.println("\n --------------------------------------------------");
		
	}

	public static void main(String[] ags){
		Test t =  new Test();
		t.testAllConntctedGraph_test1();
	}
}
