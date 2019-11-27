package com.sapient.coderpad;

public class FindElementAtGivenIndexFromPascalTriangle {

	public static int getElementFromPascalTriangle(int rowNumber, int index) {
		int triangleArray[][] = new int[rowNumber][rowNumber];
		int result = -1;

		for (int line = 0; line < rowNumber; line++) {
			for (int i = 0; i <= line; i++) {
				triangleArray[line][i] = fetchValueAtIndex(triangleArray, line, i);
				if (line == rowNumber - 1 && i == index - 1) {
					return triangleArray[line][i];
				}
			}
		}

		return result;
	}

	private static int fetchValueAtIndex(int triangleArray[][], int line, int i) {
		if (line == i || i == 0)
			return 1;

		return fetchValueAtIndex(triangleArray, line - 1, i - 1) + fetchValueAtIndex(triangleArray, line - 1, i);
	}

	public static void main(String[] args) {

		boolean pass = true;
		pass = pass && getElementFromPascalTriangle(5, 3) == 6;
		pass = pass && getElementFromPascalTriangle(5, 7) == -1;

		if (pass)
			System.out.println("All test cases passed");
		else
			System.out.println("There are test failures");
	}
}
