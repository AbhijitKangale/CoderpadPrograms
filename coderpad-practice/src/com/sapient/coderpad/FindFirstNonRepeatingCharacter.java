package com.sapient.coderpad;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindFirstNonRepeatingCharacter {

	private static int NO_OF_CHARS = 256;
	private static int count[] = new int[NO_OF_CHARS];

	private static void getCharacterCount(String str) {
		for (int i = 0; i < str.length(); i++)
			count[str.charAt(i)]++;
	}

	public static int getFistNonRepeatingCharacter(String input) {
		int index = -1;

		getCharacterCount(input);

		for (int i = 0; i < input.length(); i++) {
			if (count[input.charAt(i)] == 1) {
				index = i;
				break;
			}
		}

		return index;
	}

	public static int getFirstNonRepeatingUsingJava8(String input) {
		Map<Integer, Long> characters = input.chars().boxed()
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

		return input.indexOf(characters.entrySet().stream().filter(i -> i.getValue() == 1L).findFirst()
				.map(Map.Entry::getKey).orElse(-1));
	}

	public static void main(String[] args) {

		String inputs[] = new String[] { "apple", "aa" };
		int expectedOutput[] = new int[] { 0, -1 };
		boolean pass = true;
		boolean passForJava8 = true;

		for (int i = 0; i < inputs.length; i++) {
			pass = pass && getFistNonRepeatingCharacter(inputs[i]) == expectedOutput[i];

			if (pass)
				System.out.println("Test case for passed for input ==> " + inputs[i]);
			else
				System.out.println("Test case for failed for input ==>" + inputs[i]);

			passForJava8 = passForJava8 && getFirstNonRepeatingUsingJava8(inputs[i]) == expectedOutput[i];

			if (pass)
				System.out.println("Test case for passed for Java 8 for input ==> " + inputs[i]);
			else
				System.out.println("Test case for failed for Java 8 for input ==>" + inputs[i]);
		}
	}
}
