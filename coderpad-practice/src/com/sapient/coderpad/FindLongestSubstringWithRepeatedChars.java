package com.sapient.coderpad;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindLongestSubstringWithRepeatedChars {

	private static final Map<String, int[]> testcases = new HashMap<>();

	public static int[] finLongestSubstring(String input) {
		int long_substring_start_index = -1;
		int long_substring_length = 0;

		int i = 1;
		int length = input.length();
		while (i < length) {
			int start = i - 1;
			int current_length = 1;

			while (i < length && input.charAt(i) == input.charAt(i - 1)) {
				current_length++;
				i++;
			}

			if (current_length > long_substring_length) {
				long_substring_start_index = start;
				long_substring_length = current_length;
			}

			i++;
		}

		return new int[] { long_substring_start_index, long_substring_length };
	}

	public static void main(String[] args) {

		testcases.put("", new int[] { -1, 0 });
		testcases.put("10000111", new int[] { 1, 4 });
		testcases.put("aaabcbdeaf", new int[] { 0, 3 });

		boolean pass = true;

		for (Map.Entry<String, int[]> testcase : testcases.entrySet()) {
			int[] result = finLongestSubstring(testcase.getKey());
			pass = pass && (Arrays.equals(testcase.getValue(), result));
		}

		if (pass)
			System.out.println("All test cases are passed");
		else
			System.out.println("At least one test case failed");
	}
}
