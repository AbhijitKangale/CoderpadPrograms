package com.sapient.coderpad;

import java.util.Arrays;

public class FindNumberOfSnowPacks {

	public static int findTotalSnowPacks(int[] input) {
		int numOfSnowPacks = 0;

		int n = input.length;

		// compute height of left bar of each element
		int hightOfLeftBar[] = new int[n];
		hightOfLeftBar[0] = input[0];
		for (int i = 1; i < n; i++)
			hightOfLeftBar[i] = Math.max(hightOfLeftBar[i - 1], input[i]);

		// compute height of right bar of every element
		int hightOfRightBar[] = new int[n];
		hightOfRightBar[n - 1] = input[n - 1];
		for (int i = n - 2; i >= 0; i--)
			hightOfRightBar[i] = Math.max(hightOfRightBar[i + 1], input[i]);

		// totalSnowPacks=min(leftBar,rightBar)-inputBar
		for (int i = 0; i < n; i++)
			numOfSnowPacks += Math.min(hightOfLeftBar[i], hightOfRightBar[i])
					- input[i];

		return numOfSnowPacks;
	}

	public static void main(String[] args) {

		int inputs[][] = new int[][]{{3, 0, 0, 2, 0, 4},
				{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1},
				{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}};
		int expectedOutput[] = new int[]{10, 6, 10};

		for (int i = 0; i < inputs.length; i++) {
			int result = findTotalSnowPacks(inputs[i]);

			if (result == expectedOutput[i])
				System.out.println("Test case passed for input ==> "
						+ Arrays.toString(inputs[i]));
			else
				System.out.println("Test case failed for input ==> "
						+ Arrays.toString(inputs[i]));
		}
	}
}
