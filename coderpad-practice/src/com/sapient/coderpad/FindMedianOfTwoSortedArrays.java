package com.sapient.coderpad;

import java.util.Arrays;

public class FindMedianOfTwoSortedArrays {

	public static double findMedian(int[] a, int[] b) {

		int[] mergedArray = mergeArrays(a, b);

		Arrays.sort(mergedArray);

		return findMedianOfSortedArray(mergedArray);

	}

	private static double findMedianOfSortedArray(int[] mergedArray) {

		int length = mergedArray.length;
		double median;
		if (length % 2 == 0) {
			int index1 = length / 2;
			int index2 = index1 + 1;
			median = (mergedArray[index1 - 1] + mergedArray[index2 - 1]) / 2.0;
		} else {
			int index = (length / 2) + 1;
			median = mergedArray[index - 1];
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

		pass = pass && findMedian(new int[] { 1, 3 }, new int[] { 2, 4 }) == 2.5;
		pass = pass && findMedian(new int[] { 1, 3 }, new int[] { 2 }) == 2.0;

		if (pass)
			System.out.println("All test cases passed");
		else
			System.out.println("There are test failures");
	}
}
