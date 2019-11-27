package com.sapient.coderpad;

import java.util.HashMap;
import java.util.Map;

public class FindRepeatedNumberInFractionAfterDecimal {

	public static String findRepeatedNumberInFraction(int num, int den) {
		if (num == 0)
			return "0";

		if (den == 0)
			return "";

		String result = "";

		// If result is negative
		if (num < 0 ^ den < 0)
			result += "-";

		// convert to long
		long numerator = Math.abs(num);
		long denominator = Math.abs(den);

		// quotient
		long res = numerator / denominator;
		result += String.valueOf(res);

		// if remainder is 0, then return result
		long remainder = (numerator % denominator) * 10;
		if (remainder == 0)
			return result;

		// if remainder is not 0, then extract repeated number in remainder
		Map<Long, Integer> map = new HashMap<>();
		result += ".";
		while (remainder != 0) {
			if (map.containsKey(remainder)) {
				int beg = map.get(remainder);
				String part1 = result.substring(0, beg);
				String part2 = result.substring(beg, result.length());
				result = part1 + "(" + part2 + ")";
				return result;
			}

			map.put(remainder, result.length());
			res = remainder / denominator;
			result += String.valueOf(res);
			remainder = (remainder % denominator) * 10;
		}

		return result;
	}

	public static void main(String[] args) {

		boolean pass = true;
		pass = pass && findRepeatedNumberInFraction(1, 2).equals("0.5");
		pass = pass && findRepeatedNumberInFraction(1, 3).equals("0.(3)");
		pass = pass && findRepeatedNumberInFraction(6, 11).equals("0.(54)");
		pass = pass && findRepeatedNumberInFraction(-6, 11).equals("-0.(54)");

		if (pass)
			System.out.println("All test cases passed");
		else
			System.out.println("There are test case failures");
	}
}
