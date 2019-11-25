package com.sapient.coderpad;

public class FindAtoi {

	public static int atoi(String input) {
		// Input should not be null
		if (input == null)
			return 0;

		// Remove head and tail white spaces if any
		input = input.trim();
		if (input.length() < 1)
			return 0;

		// If input contains space between chars
		if (input.contains(" "))
			return 0;

		char flag = '+';
		int i = 0;

		// Get sign from the input
		if (input.charAt(0) == '+') {
			flag = '+';
			i++;
		} else if (input.charAt(0) == '-') {
			flag = '-';
			i++;
		}

		int result = 0;

		while (input.length() > i && input.charAt(i) >= '0' && input.charAt(i) <= '9') {
			result = result * 10 + (input.charAt(i) - '0');
			i++;
		}

		// Set sign
		if (flag == '-')
			result = -result;

		// Handle min and max case
		if (result > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;

		if (result < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;

		return result;
	}

	public static void main(String[] args) {

		String inputs[] = new String[] { "45", "12 3", "", "a45", "-857", " " };
		int expectedOutput[] = new int[] { 45, 0, 0, 0, -857, 0 };
		boolean pass = true;

		for (int i = 0; i < inputs.length; i++) {
			pass = pass && atoi(inputs[i]) == expectedOutput[i];

			if (pass)
				System.out.println(
						"Test passed for input ==> " + inputs[i] + " and expected output is ==> " + expectedOutput[i]);
			else {
				System.out.println("Test failed for input ==> " + inputs[i]);
				pass = true;
			}
		}
	}
}
