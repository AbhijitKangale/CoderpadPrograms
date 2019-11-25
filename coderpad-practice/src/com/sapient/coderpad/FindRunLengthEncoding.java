package com.sapient.coderpad;

public class FindRunLengthEncoding {

	public static String findRunLengthEncoding(String input) {
		StringBuffer sb = new StringBuffer();

		char lastSeen = 0;
		int count = 1;

		for (int i = 0; i < input.length(); i++) {
			char current = input.charAt(i);
			if (current == lastSeen) {
				count++;
				continue;
			} else {
				if (lastSeen != 0)
					sb.append(lastSeen).append(count);
			}
			count = 1;
			lastSeen = current;
		}

		return sb.append(lastSeen).append(count).toString();
	}

	public static void main(String[] args) {

		boolean pass = true;

		pass = pass && findRunLengthEncoding("aaabb").equals("a3b2");
		pass = pass && findRunLengthEncoding("aaaccbb").equals("a3c1b2");

		if (pass)
			System.out.println("All test cases are passed");
		else
			System.out.println("At least one test case failed");
	}
}
