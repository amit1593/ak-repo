package com.hcl;

import java.util.Scanner;

public class BitwiseAND {
	public static int maximumAndResult(int endPointOfArray, int endPoint) {
		int max = 0;
		int[] array = new int[endPointOfArray];
		int temp = 1;
		for (int i = 0; i < endPointOfArray; i++) {
			array[i] = temp;
			temp++;
		}
		int j = 0;
		while (j < array.length) {

			for (int k = j + 1; k < array.length; k++) {
				int result = array[j] & array[k];
				if (result < endPoint && max <= result) {
					max = result;
				}
			}
			j++;
		}
		return max;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int totalNoOfTestCases = sc.nextInt();
		for (int i = 0; i < totalNoOfTestCases; i++) {
			int endPointOfArray = sc.nextInt();
			int endPoint = sc.nextInt();
            System.out.println(maximumAndResult(endPointOfArray, endPoint));
			
		}
	}
}
