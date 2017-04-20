package com.algo.graph.dijkstra;

import com.algo.graph.dijkstra.Dijkstra;
import java.util.HashSet;

public class Test {
	/**17 vertex test**/
	private Graph  getAllConnectedGraph_test2_17vertex (){
		HashSet<Vertex> graph = new HashSet<Vertex>();
		Vertex A= new Vertex("A" );
		Vertex B= new Vertex("B" );
		Vertex L= new Vertex("L" );
		Vertex R= new Vertex("R" );
		Vertex Q= new Vertex("Q" );
		Vertex O= new Vertex("O" );
		Vertex P= new Vertex("P" );
		Vertex D= new Vertex("D" );
		Vertex C= new Vertex("C" );
		Vertex E= new Vertex("E" );
		Vertex M= new Vertex("M" );
		Vertex F= new Vertex("F" );
		Vertex Y= new Vertex("Y" );
		Vertex J= new Vertex("J" );
		Vertex Z= new Vertex("Z" );
		Vertex X= new Vertex("X" );
		Vertex W= new Vertex("W" );
		
		graph.add(A);
		graph.add(B);
		graph.add(L);
		graph.add(R);
		graph.add(Q);
		graph.add(O);
		graph.add(P);
		graph.add(D);
		graph.add(C);
		graph.add(E);
		graph.add(M);
		graph.add(F);
		graph.add(Y);
		graph.add(J);
		graph.add(Z);
		graph.add(X);
		graph.add(W);
		
		Edge[] edgeA=  new Edge[4];
		edgeA[0] = new Edge(7,C);
		edgeA[1] = new Edge(1,B);
		edgeA[2] = new Edge(2,L);
		edgeA[3] = new Edge(3,R);
		A.adjEdge = edgeA;
		
		Edge[] edgeB=  new Edge[3];
		edgeB[0] = new Edge(1,A);
		edgeB[1] = new Edge(2,O);
		edgeB[2] = new Edge(3,Q);
		B.adjEdge = edgeB;		

		
		Edge[] edgeL=  new Edge[2];
		edgeL[0] = new Edge(1,Q);
		edgeL[1] = new Edge(2,A);
		L.adjEdge = edgeL;	
		
	
		Edge[] edgeQ=  new Edge[4];
		edgeQ[0] = new Edge(3,B);
		edgeQ[1] = new Edge(1,L);
		edgeQ[2] = new Edge(2,R);
		edgeQ[3] = new Edge(2,D);
		Q.adjEdge = edgeQ;
		

		Edge[] edgeR=  new Edge[4];
		edgeR[0] = new Edge(3,A);
		edgeR[1] = new Edge(2,Q);
		edgeR[2] = new Edge(2,D);
		edgeR[3] = new Edge(2,P);
		R.adjEdge = edgeR;
	
		
		Edge[] edgeO=  new Edge[3];
		edgeO[0] = new Edge(1,C);
		edgeO[1] = new Edge(2,B);
		edgeO[2] = new Edge(4,D);
		O.adjEdge = edgeO;	

		
		Edge[] edgeP=  new Edge[4];
		edgeP[0] = new Edge(2,R);
		edgeP[1] = new Edge(4,E);
		edgeP[2] = new Edge(3,D);
		edgeP[3] = new Edge(1,M);
		P.adjEdge = edgeP;	
		
		
		Edge[] edgeD=  new Edge[6];
		edgeD[0] = new Edge(2,C);
		edgeD[1] = new Edge(4,O);
		edgeD[2] = new Edge(1,E);
		edgeD[3] = new Edge(2,Q);
		edgeD[4] = new Edge(2,R);
		edgeD[5] = new Edge(3,P);
		D.adjEdge = edgeP;	
	
		
		Edge[] edgeE=  new Edge[6];
		edgeE[0] = new Edge(3,C);
		edgeE[1] = new Edge(1,D);
		edgeE[2] = new Edge(4,P);
		edgeE[3] = new Edge(1,M);
		edgeE[4] = new Edge(2,Y);
		edgeE[5] = new Edge(2,F);
		E.adjEdge = edgeE;	
		
		Edge[] edgeM=  new Edge[5];
		edgeM[0] = new Edge(1,E);
		edgeM[1] = new Edge(1,P);
		edgeM[2] = new Edge(4,W);
		edgeM[3] = new Edge(2,J);
		edgeM[4] = new Edge(2,Y);
		M.adjEdge = edgeP;			
	
		
		Edge[] edgeC=  new Edge[5];
		edgeC[0] = new Edge(7,A);
		edgeC[1] = new Edge(1,O);
		edgeC[2] = new Edge(2,D);
		edgeC[3] = new Edge(3,E);
		edgeC[4] = new Edge(6,F);
		C.adjEdge = edgeC;	
	
		
		Edge[] edgeF=  new Edge[5];
		edgeF[0] = new Edge(6,C);
		edgeF[1] = new Edge(2,E);
		edgeF[2] = new Edge(2,Y);
		edgeF[3] = new Edge(3,Z);
		edgeF[4] = new Edge(4,X);
		F.adjEdge = edgeP;	
		
		
		Edge[] edgeY=  new Edge[7];
		edgeY[0] = new Edge(2,F);
		edgeY[1] = new Edge(2,E);
		edgeY[2] = new Edge(2,M);
		edgeY[3] = new Edge(1,J);
		edgeY[4] = new Edge(2,W);
		edgeY[5] = new Edge(2,X);
		edgeY[6] = new Edge(1,Z);
		Y.adjEdge = edgeY;	
		
		
		
		Edge[] edgeJ=  new Edge[3];
		edgeJ[0] = new Edge(1,Y);
		edgeJ[1] = new Edge(2,M);
		edgeJ[2] = new Edge(3,W);
		J.adjEdge = edgeJ;	

		
		Edge[] edgeZ=  new Edge[3];
		edgeZ[0] = new Edge(3,F);
		edgeZ[1] = new Edge(1,Y);
		edgeZ[2] = new Edge(2,X);
		Z.adjEdge = edgeZ;	

		
		Edge[] edgeX=  new Edge[4];
		edgeX[0] = new Edge(2,Z);
		edgeX[1] = new Edge(2,Y);
		edgeX[2] = new Edge(2,W);
		edgeX[3] = new Edge(4,F);
		X.adjEdge = edgeX;
		
		
		Edge[] edgeW=  new Edge[4];
		edgeW[0] = new Edge(2,X);
		edgeW[1] = new Edge(2,Y);
		edgeW[2] = new Edge(3,J);
		edgeW[3] = new Edge(4,M);
		W.adjEdge = edgeW;
		
		// build graph
		Graph g =  new Graph();
		g.allVertex=graph;
		g.startingVertex=A;
		g.vertexToFind= Z;
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
		
		graph = getAllConnectedGraph_test2_17vertex();
		System.out.println("\n --------------------Test Total Vertex ("+graph.allVertex.size()+")------------------------------");
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
