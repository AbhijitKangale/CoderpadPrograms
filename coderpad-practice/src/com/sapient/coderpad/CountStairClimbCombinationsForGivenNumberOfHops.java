package com.sapient.coderpad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountStairClimbCombinationsForGivenNumberOfHops {

	public static int findStairClimbCombinations(int n) {
		if (n <= 0)
			return 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		if (n == 3)
			return 4;

		List<Integer> combinationList = new ArrayList<>(
				Arrays.asList(0, 1, 2, 4));
		for (int i = 4; i <= n; i++)
			combinationList.add((i - 1) + (i - 2) + (i - 3));

		return combinationList.get(n);
	}

	public static void main(String[] args) {

		int inputs[] = new int[]{3, 4, 1, 2, 0, -5, 10};
		int expectedOutput[] = new int[]{4, 7, 1, 2, 0, 0, 274};

		for (int i = 0; i < inputs.length; i++) {
			int result = findStairClimbCombinations(inputs[i]);

			if (result == expectedOutput[i])
				System.out
						.println("Test case passed for input ==> " + inputs[i]);
			else
				System.out
						.println("Test case failed for input ==> " + inputs[i]);
		}
	}
}
