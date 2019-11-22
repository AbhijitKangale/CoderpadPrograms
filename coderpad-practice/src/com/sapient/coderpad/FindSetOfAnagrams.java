package com.sapient.coderpad;

public class FindSetOfAnagrams {

	private static final int NO_OF_CHARS = 256;

	public static boolean areAnagram(String str1, String str2) {
		int isAnagram[] = new int[NO_OF_CHARS];

		// This increments and decrements the count at corresponding index so that if
		// all letters are same the array will have all elements filled with zero
		for (int i = 0; i < str1.length() && i < str2.length(); i++) {
			isAnagram[str1.charAt(i)]++;
			isAnagram[str2.charAt(i)]--;
		}

		if (str1.length() != str2.length())
			return false;

		for (int i = 0; i < NO_OF_CHARS; i++) {
			if (isAnagram[i] != 0)
				return false;
		}

		return true;
	}

	public static String groupAnagrams(String s) {
		String str[] = s.split(" ");

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < str.length; i++) {
			for (int j = i + 1; j < str.length; j++) {
				if (areAnagram(str[i], str[j])) {

					if (!sb.toString().matches(".*" + str[i] + ".*")) {
						sb.append(str[i]);
						sb.append(" ");
					}
					sb.append(str[j]);
					sb.append(" ");
				}
			}
		}

		// Removing last append before returning the result
		return sb.substring(0, sb.toString().length() - 1).toString();
	}

	public static void main(String[] args) {

		boolean pass = true;

		pass = pass && groupAnagrams("bat tab").equals("bat tab");
		pass = pass && groupAnagrams("cat dog tac sat tas god").equals("cat tac dog god sat tas");

		if (pass)
			System.out.println("All test cases are passed");
		else
			System.out.println("At least one test case failed");
	}
}
