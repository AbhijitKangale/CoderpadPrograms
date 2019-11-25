package com.sapient.coderpad;

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

	public static void main(String[] args) {

		String inputs[] = new String[]{"apple", "aa"};
		int expectedOutput[] = new int[]{0, -1};
		boolean pass = true;

		for (int i = 0; i < inputs.length; i++) {
			pass = pass && getFistNonRepeatingCharacter(
					inputs[i]) == expectedOutput[i];

			if (pass)
				System.out.println("Test case for passed for ==> " + inputs[i]);
			else
				System.out.println("Test case for failed for ==>" + inputs[i]);
		}
	}
}
