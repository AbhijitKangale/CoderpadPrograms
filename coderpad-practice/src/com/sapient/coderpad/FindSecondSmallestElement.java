package com.sapient.coderpad;

public class FindSecondSmallestElement {

	public static int findSecondSmallest(int arr[]) {
		if (arr.length < 2)
			throw new IllegalArgumentException("Invalid Inupt");

		int firstSmallest = Integer.MAX_VALUE;
		int secondSmallest = Integer.MAX_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < firstSmallest) {
				secondSmallest = firstSmallest;
				firstSmallest = arr[i];
			} else if (arr[i] < secondSmallest)
				secondSmallest = arr[i];
		}

		return secondSmallest;
	}

	public static void main(String[] args) {

		boolean pass = true;

		try {
			pass = pass && findSecondSmallest(new int[] { 10, 12, 1, 14, 5, 15 }) == 5;
			pass = pass && findSecondSmallest(new int[] { 1 }) == 1;
		} catch (Exception e) {
			pass = pass && true;
		}

		if (pass)
			System.out.println("All test cases are passed");
		else
			System.out.println("At least one test case failed");
	}
}
