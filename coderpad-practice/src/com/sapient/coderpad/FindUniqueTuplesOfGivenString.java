package com.sapient.coderpad;

import java.util.Arrays;
import java.util.HashSet;

public class FindUniqueTuplesOfGivenString {

	public static HashSet<String> findUniqueTuples(String input, int length) {
		HashSet<String> resultSet = new HashSet<>();
		int inputLength = 0;

		if (input == null)
			throw new IllegalArgumentException("Input cannot be null");
		else
			inputLength = input.length();

		if (inputLength == 0)
			throw new IllegalArgumentException(
					"Input string cannot be of zero lengh");

		if (length <= 0)
			throw new IllegalArgumentException(
					"Length of tuple should be more than zero");

		if (length > inputLength)
			throw new IllegalArgumentException(
					"Length of tuple cannot be more than length of input string");

		for (int i = 0; i < (inputLength - length + 1); i++)
			resultSet.add(input.substring(i, (i + length)));

		return resultSet;
	}

	public static void main(String[] args) {
		String input1 = "aab";
		String input2 = "abbccde";

		HashSet<String> result1 = findUniqueTuples(input1, 2);
		HashSet<String> result2 = findUniqueTuples(input2, 2);

		if (result1.containsAll(Arrays.asList("aa", "ab")))
			System.out.println("Test case passed for input1");
		else
			System.out.println("Test case failed for input1");

		if (result2
				.containsAll(Arrays.asList("ab", "bb", "bc", "cc", "cd", "de")))
			System.out.println("Test case passed for input2");
		else
			System.out.println("Test case failed for input2");
	}
}
