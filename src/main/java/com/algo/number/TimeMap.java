package com.algo.number;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

public class TimeMap {
    /** Initialize your data structure here. */
	
	
	
	HashMap<String, Queue<TimeValueObject>> keyToPQ = null;
	
   	//Comparator anonymous class implementation
	public static Comparator<TimeValueObject> timeValueComparator = new Comparator<TimeValueObject>(){
		
		@Override
		public int compare(TimeValueObject c1, TimeValueObject c2) {
            return (int) (  c2.timestamp-c1.timestamp);
        }
	};
	
	public class TimeValueObject {
		int timestamp;
		String value;
		public TimeValueObject(int timestamp,String value) {
			this.value = value;
			this.timestamp= timestamp;
		}
		  
		
		
	}
	
    public TimeMap() {
    		keyToPQ = new HashMap<String, Queue<TimeValueObject>>();
 
    }
    
    public void set(String key, String value, int timestamp) {
    		Queue<TimeValueObject>  foundObject = 	keyToPQ.get(key);
    		if (foundObject == null) {
    			Queue<TimeValueObject> timeValuePriorityQueue = new PriorityQueue<>(5,timeValueComparator);
    			TimeValueObject timeValueObject =  new TimeValueObject(timestamp,value);
    			timeValuePriorityQueue.add(timeValueObject);
    			keyToPQ.put(key, timeValuePriorityQueue);
    		}else {
    			TimeValueObject timeValueObject =  new TimeValueObject(timestamp,value);
    			foundObject.add(timeValueObject);
    			 
    		}
    		
    }
    
    public String get(String key, int timestamp) {
	    	Queue<TimeValueObject>  foundPQ = 	keyToPQ.get(key);
	    	List<TimeValueObject> timeValueObjectsList =  new ArrayList<>();
	    	String foundValue=  null;
	    	
	    	if (foundPQ!=null && !foundPQ.isEmpty()) {
	    		while (!foundPQ.isEmpty()) {
		    		TimeValueObject tvObj = foundPQ.poll();
		    		timeValueObjectsList.add(tvObj);
		    		if (timestamp >= tvObj.timestamp) {
		    			foundValue = tvObj.value;
		    			foundPQ.addAll(timeValueObjectsList);
		    			break;
		    		}
	    		}
	    		return foundValue;
	    }
	    
	    return foundValue;
    }
    
    
    @Test
    public void test_1(){
    		TimeMap algo = new TimeMap();
    		algo.set("foo","bar",1);
    		Assert.assertEquals("bar", algo.get("foo", 1));
    }
    
    @Test
    public void test_2(){
    		TimeMap algo = new TimeMap();
    		algo.set("foo","bar",1);
    		Assert.assertEquals("bar", algo.get("foo", 1));
    		Assert.assertEquals("bar", algo.get("foo", 3));
    }
    
    @Test
    public void test_3(){
    		TimeMap algo = new TimeMap();
    		algo.set("foo","bar",1);
    		Assert.assertEquals("bar", algo.get("foo", 1));
    		Assert.assertEquals("bar", algo.get("foo", 3));
    		
    		algo.set("foo","bar4",4);
    		Assert.assertEquals("bar4", algo.get("foo", 4));
    		Assert.assertEquals("bar4", algo.get("foo", 5));
    		Assert.assertEquals("bar4", algo.get("foo", 3));
    		Assert.assertEquals("bar4", algo.get("foo", 1));
    }
}
