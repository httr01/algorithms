package com.algo.array;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import org.junit.Assert;
import org.junit.Test;

public class KClosestPoints2Origin {
	   public class Distance {
		   public int dist;
		   public int index;
		   public Distance (int d,int i) {
			   dist= d;
			   index= i;
		   }
		   
	   }
	   public int[][] kClosest(int[][] points, int K) {
	       java.util.List<Distance> closestPointArrayIndex =  new ArrayList<>(); 
	       
		   for (int i =0; i <points.length ;++i) {
			   closestPointArrayIndex.add(new Distance( distance(points[i][0], points[i][1]), i));
		   }
		   
		   Collections.sort(closestPointArrayIndex, new Comparator<Distance>() {
		        public int compare(Distance o1, Distance o2) {
		            return o1.dist- o2.dist;
		        }
		    });
		   
		   int[][] finalPoints =  new int[K][2];
		    
		   for ( int  index = 0 ; index < K; ++index) {
			   
			   finalPoints[index]= points[closestPointArrayIndex.get(index).index];
		   }
		   
		   return finalPoints;
	    }
	   
	   int distance(int x, int y) {
		   return x*x + y*y;	
		   
	   }
	   
	   @Test
	   public void test_1() {
		   KClosestPoints2Origin algo   =  new KClosestPoints2Origin();
		   int[][] points = {{1,3},{-2,2}};
		   int[][] expected = {{-2,2}};
		   int[][] actual = algo.kClosest(points, 1);
		   Assert.assertArrayEquals(expected,actual );
	   }
	  
	   @Test
	   public void test_2() {
		   KClosestPoints2Origin algo   =  new KClosestPoints2Origin();
		   int[][] points = {{3,3},{5,-1},{-2,4}};
		   int[][] expected = {{3,3},{-2,4}};
		   int[][] actual = algo.kClosest(points, 2);
		   Assert.assertArrayEquals(expected,actual );
	   }
	   
}
