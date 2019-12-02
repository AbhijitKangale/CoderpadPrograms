package com.sapient.coderpad;

public class FindNthFibonacciNumber {

	public static int findFibonacciUsingRecursive(int n) {
		if (n <= 1)
			return n;

		return findFibonacciUsingRecursive(n - 1) + findFibonacciUsingRecursive(n - 2);
	}

	public static int findFibonacciUsingIterative(int n) {

		int fib[] = new int[n + 1];
		fib[0] = 0;

		if (n > 0) {
			fib[1] = 1;

			for (int i = 2; i <= n; i++) {
				// Add the previous 2 numbers in the series
				fib[i] = fib[i - 1] + fib[i - 2];
			}
		}

		return fib[n];
	}

	public static void main(String[] args) {

		boolean pass = true;

		pass = pass && findFibonacciUsingRecursive(9) == 34;
		pass = pass && findFibonacciUsingIterative(9) == 34;

		if (pass)
			System.out.println("\nAll test cases are passed");
		else
			System.out.println("\nAt least one test case failed");
	}
}
