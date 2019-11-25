package com.sapient.coderpad;

import java.util.SortedSet;
import java.util.TreeSet;

public class FindMissingCharsOfPangramString {

	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

	public static String findMissingLettersOfPangram(String input) {
		SortedSet<Character> missingAlphabetLetters = new TreeSet<>();

		for (int i = 0; i < ALPHABET.length(); i++) {
			missingAlphabetLetters.add(Character.valueOf(ALPHABET.charAt(i)));
		}

		String s = input.toLowerCase();

		for (int i = 0; i < s.length(); i++) {
			missingAlphabetLetters.remove(s.charAt(i));
		}

		StringBuilder sb = new StringBuilder();
		for (Character missingChar : missingAlphabetLetters) {
			sb.append(missingChar.toString());
		}

		return sb.toString();
	}

	public static String findMissingLettersOfPangramAlternateSolution(
			String input) {

		int missingLetterIndex[] = new int[26];
		int index = 0;

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z')
				index = input.charAt(i) - 'A';
			else if (input.charAt(i) >= 'a' && input.charAt(i) <= 'z')
				index = input.charAt(i) - 'a';
			missingLetterIndex[index] = 1;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 26; i++) {
			if (missingLetterIndex[i] == 0)
				sb.append(ALPHABET.charAt(i));
		}

		return sb.toString();
	}

	public static void main(String[] args) {

		boolean pass = true;

		pass = pass && "".equals(findMissingLettersOfPangram(
				"The quick brown fox jumps over the lazy dog"));
		pass = pass && "asdfv"
				.equals(findMissingLettersOfPangram("sdfgwejklsdfhgasnvljkn"));

		if (pass)
			System.out.println("All test cases are passed");
		else
			System.out.println("At least one test case failed");
	}
}
