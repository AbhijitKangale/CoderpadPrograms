package com.sapient.coderpad;

public class CalculatePowerOfNumber {

	public static double power(double base, int exp) {
		if (base == 0)
			return 0;
		if (exp == 0)
			return 1;
		if (exp == 1)
			return base;

		int positiveExp = exp < 0 ? exp * -1 : exp;

		int power = 1;
		for (int i = 1; i <= positiveExp; i++)
			power *= base;

		return exp < 0 ? (double) 1 / power : power;

	}

	public static void main(String[] args) {

		double base[] = new double[]{2, 3, 6};
		int exponent[] = new int[]{2, -3, 7};

		for (int i = 0; i < base.length; i++) {
			double result = power(base[i], exponent[i]);
			double expectedResult = Math.pow(base[i], exponent[i]);
			if (result == expectedResult)
				System.out.println("Test case passed for ==> " + "Base="
						+ base[i] + " Exponent=" + exponent[i]);
			else
				System.out.println("Test case failed for ==> " + "Base="
						+ base[i] + " Exponent=" + exponent[i]);
		}
	}
}
