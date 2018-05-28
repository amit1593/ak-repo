package com.hcl;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		int max = 0;
		Scanner in = new Scanner(System.in);
		Deque<Integer> deque = new ArrayDeque<>();
		HashSet<Integer> hs=new HashSet<>();
		
		int n = in.nextInt();
		int m = in.nextInt();

		for (int i = 0; i < n; i++) {
			int num = in.nextInt();
			deque.add(num);
			hs.add(num);
			
			if(deque.size()==m) {
				int tempValue=deque.remove();
				int tempMax=hs.size();
				if(tempMax>max) {
					max=tempMax;
				}
				if(!deque.contains(tempValue)) {
					hs.remove(tempValue);
				}
			}
		}
		System.out.println(max);
	}
}
