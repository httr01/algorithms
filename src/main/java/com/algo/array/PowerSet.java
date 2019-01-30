package com.algo.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * 
 * write a method that calculates the power set for a supplied set.
A power set is defined as a set of all possible subsets of the original set, including the empty set.
e.g. input [1,2,3] output [ [], [1], [2], [3], [1,2], [1,3], [2,3], [1,2,3]].
**/
public class PowerSet {
	
	public ArrayList<List<Integer>> getPowerSet(List<Integer> inputset){
		ArrayList<List<Integer>> list =  new ArrayList<List<Integer>>();
		ArrayList<List<Integer>> newPowerSet = getPowerSet(inputset,0,list);
		List<Integer>  emptySet =  new ArrayList();
		newPowerSet.add(emptySet);
		return newPowerSet;
	}
	
	public ArrayList<List<Integer>> getPowerSet(List<Integer> inputSet, int index, ArrayList<List<Integer>> powerSet){
		 
		if (index == inputSet.size()-1) {
			ArrayList<List<Integer>> newPowerSet = new ArrayList<List<Integer>> ();
			List<Integer> list =  new ArrayList<Integer>();
			list.add( inputSet.get(index));
			newPowerSet.add(list);
			return newPowerSet;
		}//if
		ArrayList<List<Integer>> newPowerSet =  new ArrayList<List<Integer>>();
		ArrayList<List<Integer>> powerSetFromChild=getPowerSet(inputSet, index+1,powerSet);
		newPowerSet.addAll(copy(powerSetFromChild));
		for (List<Integer> intListSet : powerSetFromChild){
			intListSet.add(inputSet.get(index));
			newPowerSet.add(intListSet);
		}
		Integer elementAtCurrentIndex = inputSet.get(index);
		List<Integer> list =  new ArrayList<Integer>();
		list.add(elementAtCurrentIndex);
		newPowerSet.add(list );
		return newPowerSet;
	}
	
	public ArrayList<List<Integer>> copy(ArrayList<List<Integer>> sourcePowerList) {
		ArrayList<List<Integer>> newPowerList = new ArrayList<List<Integer>>();
		for (List<Integer> intialListSet : sourcePowerList){
			List<Integer>  newIntSet =  copy(intialListSet);
			newPowerList.add(newIntSet);
		}
		return newPowerList;
	}
	public List<Integer> copy(List<Integer> intialListSet) {
		List<Integer>  newIntSet =  new ArrayList();
		for (Integer integer:  intialListSet) {
			newIntSet.add(integer);
		}
		
		return newIntSet;
	}
	
	@Test
	public void test_0() {
		List<Integer> inputset =  new ArrayList();
		inputset.add(1);
		inputset.add(2);
		PowerSet algo =  new PowerSet();
		ArrayList<List<Integer>> powerSet = algo.getPowerSet(inputset);
		 System.out.println(powerSet);
	}
	
	@Test
	public void test_1() {
		List<Integer> inputset =  new ArrayList();
		inputset.add(1);
		inputset.add(2);
		inputset.add(3);
		PowerSet algo =  new PowerSet();
		ArrayList<List<Integer>> powerSet = algo.getPowerSet(inputset);
		 System.out.println(powerSet);
	}

}
