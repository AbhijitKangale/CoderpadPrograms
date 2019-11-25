package com.sapient.coderpad;

public class FindSmallestNumberInSortedButRotatedArray {

	public static int findMin(int a[]) {
		if (a == null)
			throw new IllegalArgumentException("Invalid Input");

		return findMinInArray(a, 0, a.length - 1);
	}

	public static int findMinInArray(int arr[], int right, int left) {
		// This means the array has only one element
		if (right == left)
			return arr[left];

		// This means the array is not rotated
		if (arr[right] < arr[left])
			return arr[0];

		int mid = (right + left) / 2;

		if (mid < left && arr[mid + 1] < arr[mid])
			return arr[mid + 1];

		if (mid > right && arr[mid] < arr[mid - 1])
			return arr[mid];

		if (arr[left] > arr[mid])
			return findMinInArray(arr, right, mid - 1);

		return findMinInArray(arr, mid + 1, left);
	}

	public static void main(String[] args) {

		boolean pass = true;

		pass = pass && findMin(new int[] { 3, 4, 5, 6, 1, 2 }) == 1;
		pass = pass && findMin(new int[] { 2, 1 }) == 1;
		pass = pass && findMin(new int[] { 1 }) == 1;

		try {
			findMin(null);
		} catch (Exception e) {
			pass = pass && true;
		}

		if (pass)
			System.out.println("All test cases are passed");
		else
			System.out.println("At least one test case failed");
	}
}
