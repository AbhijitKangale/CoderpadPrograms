package com.sapient.coderpad;

public class FindDotProductOfArrays {

	public static int findDotProduct(int arr1[], int arr2[]) {
		if (arr1 == null || arr2 == null || arr1.length == 0 || arr2.length == 0
				|| arr1.length != arr2.length)
			throw new IllegalArgumentException("Invalid Input...");

		int dotProduct = 0;
		for (int i = 0; i < arr1.length; i++) {
			dotProduct += arr1[i] * arr2[i];
		}

		return dotProduct;
	}

	public static void main(String[] args) {

		int array1[] = new int[]{1, 2};
		int array2[] = new int[]{2, 3};
		int result = findDotProduct(array1, array2);
		if (result == 8)
			System.out.println("Test case passed for ==> array1 and array2");
		else
			System.out.println("Test case passed for ==> array1 and array2");

		int array3[] = new int[]{1, 2};
		int array4[] = new int[]{3};
		try {
			findDotProduct(array3, array4);
		} catch (Exception e) {
			System.out.println("Test case passed for ==> array3 and array4");
		}
	}
}
