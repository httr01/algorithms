package com.algo.string;

import org.junit.Assert;
import org.junit.Test;

public class LicenseKeyFormatting {
	  public String licenseKeyFormatting(String S, int K) {
		  if (S.length()< K) return S;
		  	StringBuffer finalString = new StringBuffer();
		  	String separator = "";
		  	
		  	boolean gotalphabet = false;
		  	StringBuffer sb = new StringBuffer();
		  	int count_k = 0;
		  	S =  S.toUpperCase();
	        for (int i = 0 ; i< S.length(); ++i) {
	        		char c =  S.charAt(i);
	        		if (separator.equals("-")) {
	        			finalString.append(separator);
	        			separator="";
	        			gotalphabet = false;
	        			count_k=0;
	        			sb= new StringBuffer();
	        		}
	        		if (c != '-') {
	        			if (Character.isAlphabetic(c)) {
	        				gotalphabet = true;
		        		}
	        			if (count_k<K) {
	        				sb.append(String.valueOf(c));
	        				++count_k;
	        				Character nextChar =  null ;
	        				int j=i+1;
	        						
	        				while (j<S.length()) {
	        					nextChar =  S.charAt(j);
	        					if (nextChar != '-') {
	        						break;
	        					}
	        					++j;
	        				}
	        				if (count_k == K-1 && !gotalphabet && i< S.length()-1 && !Character.isAlphabetic(nextChar)) {
	        					finalString.append(sb.toString());
	        					separator = "-";
	        				}
	        			}
	        			if (count_k==K) {
	        				finalString.append(sb.toString());
	        				separator = "-";
	        			}
	        		}//if
	        		
	        }
	        return finalString.toString();
	   }
	  @Test
	  public void test_2() {
		  LicenseKeyFormatting algo = new LicenseKeyFormatting();
		  String actual = algo.licenseKeyFormatting("2-5g-3-J", 2);
		  Assert.assertEquals("2-5G-3J", actual);
	  }  
	  @Test
	  public void test_1() {
		  LicenseKeyFormatting algo = new LicenseKeyFormatting();
		  String actual = algo.licenseKeyFormatting("5F3Z-2e-9-w", 4);
		  Assert.assertEquals("5F3Z-2E9W", actual);
	  }
	   
	  

}
