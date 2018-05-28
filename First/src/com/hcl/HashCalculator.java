package com.hcl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class HashCalculator {
	public static void main(String[] args) throws NoSuchAlgorithmException {
	    Scanner in = new Scanner(System.in);
	    String inputText = in.nextLine();
	    printSHA256(inputText);
	}

	public static void printSHA256(String text) throws NoSuchAlgorithmException{
	   MessageDigest md=MessageDigest.getInstance("SHA-256");
	   md.update(text.getBytes());
	   for(byte in:md.digest()) {
		   System.out.print(String.format("%02x", in));
	   }
	}
}
