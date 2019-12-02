package com.sapient.coderpad;

import java.util.HashSet;
import java.util.Set;

public class FindMinCharsRequiredToGetEncodedMagicPotion {

	public static int getMinimumChars(String input) {

		StringBuffer sb = new StringBuffer();
		Set<Character> manipulationSet = new HashSet<>();
		int count = 0;

		for (int i = 0; i < input.length(); i++) {
			// to check if char is repeated, if not repeated then add to encoded string
			if (manipulationSet.add(input.charAt(i))) {

				if (count != 0) {

					// this is to check if set of first few chars are repeated
					if (input.substring(0, count).equals(input.substring(count, count * 2))) {
						sb.append("*");
					} else
						// if first few chars are not repeated then add it to encoded string
						sb.append(input.substring(0, count));
					count = 0;
				}

				// adding char to encoded string
				sb.append(input.charAt(i));

			} else
				count++;
		}

		// in case if all last few chars are not repeated
		if (count != 0) {

			// this is to check if set of first few chars are repeated
			if (input.substring(0, count).equals(input.substring(count, count * 2))) {
				sb.append("*");
			} else
				// if first few chars are not repeated then add it to encoded string
				sb.append(input.substring(input.length() - count, input.length()));
		}

		return sb.length();
	}

	public static void main(String args[]) {
		boolean pass = true;

		pass = pass && getMinimumChars("ABABCABABA") == 9;
		pass = pass && getMinimumChars("ABCDABCE") == 8;
		pass = pass && getMinimumChars("ABCABCE") == 5;

		if (pass)
			System.out.println("All test cases passed");
		else
			System.out.println("There are test case failures");
	}
}
