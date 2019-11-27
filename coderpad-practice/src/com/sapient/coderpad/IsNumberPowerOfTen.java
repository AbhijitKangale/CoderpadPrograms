package com.sapient.coderpad;

public class IsNumberPowerOfTen {

	public static boolean isPowerOf10(int number) {
		while (number > 1) {
			if (number % 10 != 0)
				return false;
			number /= 10;
		}

		return number == 1;
	}

	public static void main(String[] args) {

		int inputs[] = new int[]{10, 45, 100, 1, 873, 1000};
		boolean pass = true;

		for (int i = 0; i < inputs.length; i++) {
			pass = pass && isPowerOf10(inputs[i]);

			if (pass)
				System.out
						.println("Test case passed for input ==> " + inputs[i]);
			else {
				System.out
						.println("Test case failed for input ==> " + inputs[i]);
				pass = true;
			}

		}
	}
}
