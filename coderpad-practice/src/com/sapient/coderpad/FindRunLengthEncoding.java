package com.sapient.coderpad;

public class FindRunLengthEncoding {

	public static String findRunLengthEncoding(String input) {
		StringBuffer sb = new StringBuffer();

		int count = 1;

		for (int i = 0; i < input.length(); i++) {
			char current = input.charAt(i);
			if (i < input.length() - 1 && current == input.charAt(i + 1)) {
				count++;
			} else {
				sb.append(current).append(count);
				count = 1;
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {

		boolean pass = true;

		pass = pass && findRunLengthEncoding("aaabb").equals("a3b2");
		pass = pass && findRunLengthEncoding("aaaccbb").equals("a3c2b2");

		if (pass)
			System.out.println("All test cases are passed");
		else
			System.out.println("At least one test case failed");
	}
}
