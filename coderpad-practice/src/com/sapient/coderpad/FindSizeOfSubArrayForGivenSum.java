package com.sapient.coderpad;

public class FindSizeOfSubArrayForGivenSum {

	public static int findSubArrayLengthForGivenSum(int arr[], int targetSum) {
		int start = 0;
		int subArraySize = Integer.MAX_VALUE;
		int n = arr.length;

		if (n == 0 || targetSum == 0)
			return -1;

		int currentSum = arr[0];

		for (int i = 1; i <= n; i++) {
			while (currentSum > targetSum && start < i - 1) {
				currentSum -= arr[start];
				start++;
			}

			if (currentSum == targetSum)
				subArraySize = i - start;

			if (i < n)
				currentSum += arr[i];
		}

		if (subArraySize == Integer.MAX_VALUE)
			return -1;

		return subArraySize;
	}

	public static void main(String[] args) {

		boolean pass = true;
		int[] inputArray = new int[] { 1, 2, 3, 4 };
		int[] inputArray1 = new int[] {};

		pass = pass && findSubArrayLengthForGivenSum(inputArray, 6) == 3;
		pass = pass && findSubArrayLengthForGivenSum(inputArray, 10) == 4;
		pass = pass && findSubArrayLengthForGivenSum(inputArray1, 1) == -1;
		pass = pass && findSubArrayLengthForGivenSum(inputArray, 0) == -1;

		if (pass)
			System.out.println("All test cases passed");
		else
			System.out.println("There are test case failures");
	}
}
