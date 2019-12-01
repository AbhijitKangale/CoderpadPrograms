package com.sapient.coderpad;

import java.util.Arrays;

public class FindMedianOfTwoSortedArrays {

	public static double findMedian(int[] a, int[] b) {

		int[] mergedArray = mergeArrays(a, b);

		Arrays.sort(mergedArray);

		return findMedianOfSortedArray(mergedArray);

	}

	// complexity of this would be Olog(min(x,y))
	public static double findMedianAlternateSolution(int[] a, int[] b) {
		if (a.length == 0 && b.length == 0)
			return 0;

		if (a.length > b.length)
			return findMedianAlternateSolution(b, a);

		int x = a.length;
		int y = b.length;

		int low = 0;
		int high = x;

		while (low <= high) {
			int partitionX = (low + high) / 2;
			int partitionY = (x + y + 1) / 2 - partitionX;

			int maxLeftX = (partitionX == 0)
					? Integer.MIN_VALUE
					: a[partitionX - 1];
			int minRightX = (partitionX == x)
					? Integer.MAX_VALUE
					: a[partitionX];

			int maxLeftY = (partitionY == 0)
					? Integer.MIN_VALUE
					: b[partitionY - 1];
			int minRightY = (partitionY == y)
					? Integer.MAX_VALUE
					: b[partitionY];

			if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
				if ((x + y) % 2 == 0)
					return ((double) Math.max(maxLeftX, maxLeftY)
							+ Math.min(minRightX, minRightY)) / 2;
				else
					return (double) Math.max(maxLeftX, maxLeftY);
			} else if (maxLeftX > minRightY)
				high = partitionX - 1;
			else
				low = partitionX + 1;
		}

		// it would reach here if the arrays are not sorted
		throw new IllegalArgumentException();
	}

	private static double findMedianOfSortedArray(int[] mergedArray) {

		int length = mergedArray.length;
		double median;
		if (length % 2 == 0) {
			int index1 = length / 2;
			int index2 = index1 + 1;
			median = (mergedArray[index1 - 1] + mergedArray[index2 - 1]) / 2.0;
		} else {
			int index = length / 2;
			median = mergedArray[index];
		}

		return median;
	}

	private static int[] mergeArrays(int a[], int[] b) {
		int[] mergedArray = new int[a.length + b.length];

		int mergeIndex = 0;

		for (int i = 0; i < a.length; i++) {
			mergedArray[mergeIndex] = a[i];
			mergeIndex++;
		}

		for (int i = 0; i < b.length; i++) {
			mergedArray[mergeIndex] = b[i];
			mergeIndex++;
		}

		return mergedArray;
	}

	public static void main(String[] args) {

		boolean pass = true;

		pass = pass && findMedian(new int[]{1, 3}, new int[]{2, 4}) == 2.5;
		pass = pass && findMedian(new int[]{1, 3}, new int[]{2}) == 2.0;
		pass = pass && findMedianAlternateSolution(new int[]{1, 3, 8, 9, 15},
				new int[]{7, 11, 18, 19, 21, 25}) == 11;
		pass = pass && findMedianAlternateSolution(new int[]{23, 26, 31, 35},
				new int[]{3, 5, 7, 9, 11, 16}) == 13.5;

		if (pass)
			System.out.println("All test cases passed");
		else
			System.out.println("There are test failures");
	}
}
