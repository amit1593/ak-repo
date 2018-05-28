package com.hcl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionClass {
	public static void main(String[] args) {
		List l=new ArrayList<>();
		l.add(1);
		System.out.println(Collections.binarySearch(l,-1));
		

	}
}
