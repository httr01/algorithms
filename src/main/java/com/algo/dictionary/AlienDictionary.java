package com.algo.dictionary;

import org.junit.Assert;
import org.junit.Test;

public class AlienDictionary {

	/**
	 * In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographicaly in this alien language.

 

Example 1:

Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
Example 2:

Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
Example 3:

Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
 
 **/
	int[] orderWeight = new int[26];
	
    public boolean isAlienSorted(String[] words, String order) {
        boolean  inOrder = true;
        int orderValue=1;
        for (int i = 0 ;i < order.length(); ++i) {
        		orderWeight[order.charAt(i)-'a'] =  orderValue++;
        }
        
        if (words.length <=1) return true;
        // two or more length
        int currentIndex = 0;
        while (inOrder &&currentIndex <=words.length-2) {
        		inOrder = isAlienSorted(words[currentIndex],words[currentIndex+1]);
        		++currentIndex;
        }
        return inOrder;
    }
    
    private boolean isAlienSorted(String word1,String word2) {
    		int index = 0;
    		int minLenth = Math.min(word1.length(), word2.length());
    		while (index<=minLenth-1 && word1.charAt(index)== word2.charAt(index)) {
    				++index;
    		}
    		if (index<=minLenth-1) {
    			// means both words have somechar left
    			if (orderWeight[word1.charAt(index)-'a']<= orderWeight[word2.charAt(index)-'a']) 
    				return true; 
    			else 
    				return false;
    		}else if  (word1.length()== word2.length() && index > minLenth-1) {
    			//ap=ap
    			return true;
    		}else if (index>word1.length()-1 && index<=word2.length()-1){
    			return true;
    		}else if (index<=word1.length()-1 && index>word2.length()-1){
    			return false;
    		}else return false;
    }
    
    
    @Test
    public void test_1() {
    		String[] words = {"hello","leetcode"};
    		String order = "hlabcdefgijkmnopqrstuvwxyz";
    		AlienDictionary ad =  new AlienDictionary();
    		Assert.assertEquals( true, ad.isAlienSorted(words, order) );
    }
    
    @Test
    public void test_2() {
    		String[] words = {"word","world","row"};
    		String order = "worldabcefghijkmnpqstuvxyz";
    		AlienDictionary ad =  new AlienDictionary();
    		Assert.assertEquals( false, ad.isAlienSorted(words, order) );
    }
    @Test
    public void test_3() {
    		String[] words = {"apple","app"};
    		String order = "abcdefghijklmnopqrstuvwxyz";
    		AlienDictionary ad =  new AlienDictionary();
    		Assert.assertEquals( false, ad.isAlienSorted(words, order) );
    } 
    
    @Test
    public void test_4() {
    		String[] words = {"app","app"};
    		String order = "abcdefghijklmnopqrstuvwxyz";
    		AlienDictionary ad =  new AlienDictionary();
    		Assert.assertEquals( true, ad.isAlienSorted(words, order) );
    } 
    @Test
    public void test_5() {
    		String[] words = {"app","apple", "apple"};
    		String order = "abcdefghijklmnopqrstuvwxyz";
    		AlienDictionary ad =  new AlienDictionary();
    		Assert.assertEquals( true, ad.isAlienSorted(words, order) );
    } 
    
    @Test
    public void test_6() {
    		String[] words = {"app","apple", "appl"};
    		String order = "abcdefghijklmnopqrstuvwxyz";
    		AlienDictionary ad =  new AlienDictionary();
    		Assert.assertEquals( false, ad.isAlienSorted(words, order) );
    } 
}
