package com.sapient.coderpad;

public class IsNumberPowerOfTen {

	public static boolean isPowerOf10(double number) {

		// This is to check if number is negative power of 10
		if (number > 0 && number < 1) {
			while (number < 1)
				number *= 10;
		}
		// This is to check if number is positive power of 10
		else {
			while (number > 1) {
				if (number % 10 != 0)
					return false;
				number /= 10;
			}
		}

		return number == 1;
	}

	public static void main(String[] args) {

		double inputs[] = new double[] { 10, 45, 100, 1, 873, 1000, 0.001, 0.452 };
		boolean pass = true;

		for (int i = 0; i < inputs.length; i++) {
			pass = pass && isPowerOf10(inputs[i]);

			if (pass)
				System.out.println("Test case passed for input ==> " + inputs[i]);
			else {
				System.out.println("Test case failed for input ==> " + inputs[i]);
				pass = true;
			}
		}
	}
}
