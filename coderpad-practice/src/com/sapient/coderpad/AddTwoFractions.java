package com.sapient.coderpad;

public class AddTwoFractions {

	public static int[] addFractions(int fraction1[], int fraction2[])
			throws IllegalAccessException {
		if (fraction1.length != 2 && fraction2.length != 2)
			throw new IllegalArgumentException(
					"Argument passed should be two element array");

		int num1 = fraction1[0];
		int num2 = fraction2[0];
		int den1 = fraction1[1];
		int den2 = fraction2[1];

		int resultNum = 0;
		int resultDen = 1;

		if (den1 == 0 || den2 == 0)
			throw new IllegalAccessException(
					"Zero value in denominator is not allowed");
		else {
			resultNum = (num1 * den2) + (num2 * den1);
			resultDen = (den1 * den2);
		}

		if (resultNum == 1)
			return new int[]{0, 1};

		int gcd = findGCD(resultNum, resultDen);

		return new int[]{resultNum / gcd, resultDen / gcd};
	}

	private static int findGCD(int num1, int num2) {
		if (num1 == 0 || num2 == 0)
			return 0;

		if (num1 == num2)
			return num1;

		if (num1 > num2)
			return findGCD(num1 - num2, num2);

		return findGCD(num1, num2 - num1);
	}

	public static void main(String[] args) throws IllegalAccessException {

		boolean pass = true;

		int result1[] = addFractions(new int[]{2, 6}, new int[]{1, 3});
		pass = pass && (result1[0] == 2 && result1[1] == 3);

		if (pass)
			System.out.println("All test cases are passed");
		else
			System.out.println("At least one test case failed");
	}
}
