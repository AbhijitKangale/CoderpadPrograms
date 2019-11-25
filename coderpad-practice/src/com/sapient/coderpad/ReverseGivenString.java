package com.sapient.coderpad;

public class ReverseGivenString {

	public static String reverseString(String str) {

		if (str == null)
			throw new IllegalArgumentException("Invalid Input.....");

		StringBuffer sb = new StringBuffer();

		for (int i = str.length() - 1; i >= 0; i--)
			sb.append(str.charAt(i));

		return sb.toString();
	}

	public static void main(String[] args) {

		String inputs[] = new String[]{"apple", "big", "mom", null};
		String expectedResult[] = new String[]{"elppa", "gib", "mom"};

		for (int i = 0; i < inputs.length; i++) {
			try {
				String result = reverseString(inputs[i]);

				if (result.equals(expectedResult[i]))
					System.out.println(
							"Test case passed for input ==> " + inputs[i]);
				else
					System.out.println(
							"Test case failed for input ==> " + inputs[i]);

			} catch (Exception e) {
				System.out.println("Test case passed for null as input.");
			}
		}
	}
}
