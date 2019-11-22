package com.sapient.coderpad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPrimeFactorsOfNumber {

	public static List<Integer> findPrimeFactors(int n) {
		List<Integer> primeFactors = new ArrayList<>();
		if (n == 2) {
			primeFactors.add(n);
			return primeFactors;
		}

		for (int i = 2; i <= n; i++) {
			while (n % i == 0) {
				n = n / i;
				primeFactors.add(i);
			}
		}

		return primeFactors;
	}

	public static void main(String args[]) {
		boolean pass = true;

		pass = pass && findPrimeFactors(6).equals(Arrays.asList(2, 3));
		pass = pass && findPrimeFactors(2).equals(Arrays.asList(2));
		pass = pass && findPrimeFactors(314).equals(Arrays.asList(2, 3, 6));

		if (pass)
			System.out.println("All test cases are passed");
		else
			System.out.println("At least one test case failed");
	}

}
