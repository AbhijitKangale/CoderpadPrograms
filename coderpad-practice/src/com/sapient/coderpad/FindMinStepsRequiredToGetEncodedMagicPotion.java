package com.sapient.coderpad;

import java.util.HashSet;
import java.util.Set;

public class FindMinStepsRequiredToGetEncodedMagicPotion {

	public static int getMinimumSteps(String input) {

		StringBuffer sb = new StringBuffer();
		Set<Character> manipulationSet = new HashSet<>();

		for (int i = 0; i < input.length(); i++) {
			if (manipulationSet.add(input.charAt(i)))
				sb.append(input.charAt(i));
			else {
				if (!sb.substring(sb.length() - 1, sb.length()).toString()
						.equals("*"))
					sb.append("*");
			}
		}

		return sb.length();
	}

	public static void main(String args[]) {
		boolean pass = true;

		pass = pass && getMinimumSteps("ABABCABABCE") == 6;
		pass = pass && getMinimumSteps("ABCDABCE") == 8;
		pass = pass && getMinimumSteps("ABCABCE") == 5;

		if (pass)
			System.out.println("All test cases passed");
		else
			System.out.println("There are test case failures");
	}
}
