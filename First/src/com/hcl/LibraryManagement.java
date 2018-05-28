package com.hcl;

import java.util.Scanner;

public class LibraryManagement {

	public static int fineCalculator(int returnDate, int returnMonths, int returnYear, int expectedReturnDate,
			int expectedReturnMonths, int expectedReturnYear) {
		int lateFine = 0;
		int noOfDaysLate = 0;
		int noOfMonthsLate = 0;
		if (returnYear <expectedReturnYear) {
			return 0;	
		}	
		if (returnYear == expectedReturnYear) {
			if (returnMonths == expectedReturnMonths) {
				if (returnDate == expectedReturnDate) {
					lateFine = 0;
				} else {
					noOfDaysLate = returnDate - expectedReturnDate;
					lateFine = noOfDaysLate * 15;
				}
			} else {
				noOfMonthsLate = returnMonths - expectedReturnMonths;
				lateFine = 500 * noOfMonthsLate;
				if(lateFine<0) {
					return 0;
				}
				return lateFine;
			}
		} else {
			return 10000;
		}
		return lateFine;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int returnDate = sc.nextInt();
		int returnMonths = sc.nextInt();
		int returnYear = sc.nextInt();
		int expectedReturnDate = sc.nextInt();
		int expectedReturnMonths = sc.nextInt();
		int expectedReturnYear = sc.nextInt();

		int totalLateFine = fineCalculator(returnDate, returnMonths, returnYear, expectedReturnDate,
				expectedReturnMonths, expectedReturnYear);
		System.out.println(totalLateFine);

	}
}
