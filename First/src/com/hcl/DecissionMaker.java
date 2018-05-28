package com.hcl;

import java.util.Scanner;

public class DecissionMaker {
	public static boolean check(int num) {
		if (num % 2 == 0) {
			System.out.println("Even number");
			return true;
		} else {
			System.out.println("odd number");
			return false;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(check(sc.nextInt()));

	}
}
