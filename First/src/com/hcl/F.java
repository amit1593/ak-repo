package com.hcl;

import java.util.Arrays;
import java.util.HashMap;

public class F {
	public static void main(String[] str) {
  String s1="This is good";
  String s2="tac";
  char[] c1=s1.toCharArray();
  char[] c2=s2.toCharArray();
  System.out.println(Arrays.equals(c1, c2));
  
  HashMap<Integer,String> hs= new HashMap<Integer,String>();
  
  hs.put(101, "A");
  hs.putIfAbsent(106, "B");
  hs.put(101, "A");
  hs.put(103, "B");
  hs.put(102, "c");
  System.out.println(hs.size());
  
  
	}
}
