	package com.algo.map;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Assert;
import org.junit.Test;

/***
 * Add entries in hash map which has an expiry time
 * How would you clean up the map for the keys which are expired  but never used, they will stay in map and keep piling up
 * .**/
public class TimeLimitingHashmap {
	public class Value {
		int value;
		long expiryTime;
		public Value(int v, long exptime ){
			this.value= v;
			this.expiryTime=exptime;
		}
	}
	public class Key {
		int key;
		long expiryTime;
		public Key(int key, long exptime ){
			this.key= key;
			this.expiryTime=exptime;
		}
	}

	// This thread is to clean up the map . Remove the keys which are expired.
	public class MapCleanerThread extends Thread{
		int wakeUpInMillis =    60 *1000 /3; //  half 20 second
		Map <Integer, Value> keyValueMap;
		ArrayList<Key> keyArray;
		 public MapCleanerThread(Map <Integer, Value> keyValueMap,ArrayList<Key> keyArray){
			this.keyValueMap= keyValueMap;
			this.keyArray=keyArray;
	}
	public void run(){
			int count =0;
			while (true) {
				++count;
				System.out.println(count+" Wake up to clean map");
				for (int i=0 ;i< keyArray.size(); ++i) {
					Key key =  keyArray.get(i);
					long currTime =  new Date().getTime();
					if (key.expiryTime<currTime) {
						keyValueMap.remove(key.key);
						keyArray.remove(i);
						System.out.println(count+" Cleaner: Removed key "+key.key);
					}else {
						// we reach the index in array where keys are not expired any more.
						break;
					}
				}//for
				try {
					Thread.sleep(wakeUpInMillis);
				}catch(InterruptedException ex) {
					System.out.println("InterruptedException: "+ex.getMessage());
				}
			}//while
	}//run

	}//MapCleanerThread
	
	
	Map<Integer, Value> map =  new ConcurrentHashMap<>();
	ArrayList<Key> keyArray = new ArrayList<>();
	MapCleanerThread cleaner;
	public TimeLimitingHashmap(){
		init();
	}


	public void init (){
		cleaner = new MapCleanerThread(map,keyArray);
		cleaner.start();
	}
	public void  put(int key, int value, int time_limit_milli ){
		long expiryTime= new Date().getTime()+time_limit_milli;
		map.put(key,new Value(value,expiryTime) );
		keyArray.add(new Key(key,expiryTime));
		System.out.println( " Added key "+key);
	}
	public int  get(int key  ){
		Value foundObj = map.get(key);
		if (foundObj ==  null ) return -1;	
		if (foundObj.expiryTime < new Date().getTime())  {
			map.remove(key);// maintain another collection for removed keys;
			return -1;
		}
		else  return foundObj.value  ;
	}
	
	@Test
	public void test_1() {
		TimeLimitingHashmap algo = new TimeLimitingHashmap();
		algo.put(1, 1, 1000 *10); // live for 10 second
		Assert.assertEquals(1, algo.get(1));
		
		try {
			Thread.sleep(30 * 1000); //  30 second
		}catch(InterruptedException ex) {
			System.out.println("InterruptedException: "+ex.getMessage());
		}
		System.out.println("This should be -1: algo.get(1) "+algo.get(1));
		Assert.assertEquals(-1, algo.get(1));
		
		algo.put(1, 1, 1000 *40); // live for 40 second
		
		Assert.assertEquals(1, algo.get(1));
		
		try {
			Thread.sleep(20 * 1000); //  30 second
		}catch(InterruptedException ex) {
			System.out.println("InterruptedException: "+ex.getMessage());
		}
		System.out.println("Now This should be 1: algo.get(1) "+algo.get(1));
		Assert.assertEquals(1, algo.get(1));
		
	}


}//class
