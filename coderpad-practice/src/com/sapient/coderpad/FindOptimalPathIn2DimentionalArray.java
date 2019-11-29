package com.sapient.coderpad;

public class FindOptimalPathIn2DimentionalArray {

	public static int findOptimalPath(int inputGrid[][]) {
		int rowCount = inputGrid.length;
		int colCount = inputGrid[0].length;

		if (rowCount == 0 || colCount == 0)
			return 0;

		for (int row = rowCount - 1; row >= 0; row--) {
			for (int col = 0; col < colCount; col++) {
				// this code is for remaining rows excluding last row and all columns excluding
				// first column
				if (row < rowCount - 1 && col > 0)
					inputGrid[row][col] += Math.max(inputGrid[row + 1][col], inputGrid[row][col - 1]);
				// this code is for remaining rows excluding last row but only first column
				else if (row < rowCount - 1)
					inputGrid[row][col] += inputGrid[row + 1][col];
				// this code is for last row in input grid and run for all columns of this row
				else if (col > 0)
					inputGrid[row][col] += inputGrid[row][col - 1];
			}
		}

		return inputGrid[0][colCount - 1];
	}

	public static boolean doTestsPass() {
		boolean result = true;

		// best case
		result &= findOptimalPath(new int[][] { { 0, 0, 0, 0, 5 }, { 0, 1, 1, 1, 0 }, { 2, 0, 0, 0, 0 } }) == 10;

		// some ramdom numbers
		result &= findOptimalPath(new int[][] { { 1, 3, 2, 0, 2, 1, 8 }, { 3, 4, 1, 2, 0, 1, 1 },
				{ 1, 1, 1, 2, 3, 2, 1 }, { 1, 0, 1, 1, 4, 2, 1 } }) == 25;

		// For all 0's
		result &= findOptimalPath(
				new int[][] { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 } }) == 0;

		// empty grid
		result &= findOptimalPath(new int[][] { {} }) == 0;

		return result;
	}

	public static void main(String[] args) {

		if (doTestsPass()) {
			System.out.println("All tests pass");
		} else {
			System.out.println("Tests fail.");
		}
	}
}
