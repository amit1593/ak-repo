package com.hcl;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagExtracter {
	public static void parser(String str) {
		char[] charArray = str.toCharArray();
		int startIndex = 0;

		int endIndex = 0;
		int startIndexOfResult = 0;
		int endIndexOfResult = 0;
		boolean endTagFlag = false;
		ArrayList<String> al = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		Stack<String> symbolStack = new Stack<String>();
		boolean concatFlag = false;
		for (int i = 0; i < charArray.length; i++) {

			if (charArray[i] == '<') {
				concatFlag = false;
				if (i == charArray.length - 1) {
					break;
				}
				if (charArray[i + 1] == '/') {
					startIndex = i + 2;
					endTagFlag = true;
				} else {
					startIndex = i + 1;
				}
			}
			if (concatFlag) {
				sb.append(charArray[i]);
			}

			if (charArray[i] == '>') {
				endIndex = i;
				concatFlag = true;
				if (endTagFlag) {
					endTagFlag = false;
					if (!symbolStack.isEmpty()) {
						endIndexOfResult = i - 1;
						String tag = symbolStack.pop();
						String currentTag = str.substring(startIndex, endIndex);
						if (tag.isEmpty()) {
							sb = new StringBuilder();
						}
						if (tag.equals(currentTag) && !tag.isEmpty()) {
							// System.out.println(sb);
							al.add(sb.toString());
							sb = new StringBuilder();
							// System.out.println(str.substring(startIndexOfResult, endIndexOfResult-4));
						} else {
							sb = new StringBuilder();
						}
					}
				} else {
					if (!symbolStack.isEmpty()) {
						sb = new StringBuilder();
					}
					symbolStack.add(str.substring(startIndex, endIndex));
					startIndexOfResult = i + 1;
				}

			}

		}
		
		al.removeIf(String::isEmpty);
		if (al.size() == 0) {
			System.out.println("None");
		}
		for (String s : al) {
			if (!s.isEmpty()) {
				System.out.println(s);
			}
		}
		al.clear();
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while (testCases > 0) {
			String line = in.nextLine();

			//parser(line);
			// Write your code here
			boolean found = false;
	          Pattern p = Pattern.compile("<(.+)>([^<]+)</\\1>");
	          Matcher m = p.matcher(line);
	          
	          while(m.find()){
	            System.out.println(m.group(2));
	            found = true;
	          }
	          
	          if(!found)
	              System.out.println("None");
			testCases--;
		}
	}

}
