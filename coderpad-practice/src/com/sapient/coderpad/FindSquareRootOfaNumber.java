package com.sapient.coderpad;

public class FindSquareRootOfaNumber {

	// Formula is sqrt = (sqrt + (num/sqrt))/2. Start initially by num/2
	public static double squareroot(double number) {
		double t;
		double squareroot = number / 2;
		do {
			t = squareroot;
			squareroot = (t + (number / t)) / 2;
		} while ((t - squareroot) != 0);

		return squareroot;
	}

	public static void main(String[] args) {

		boolean pass = true;

		pass = pass && (squareroot(121.0) == 11.0);

		if (pass)
			System.out.println("All test cases are passed");
		else
			System.out.println("At least one test case failed");
	}
}
