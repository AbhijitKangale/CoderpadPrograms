package com.sapient.coderpad;

import java.util.HashMap;
import java.util.Map;

public class CountLengthOfCycleInArray {

	public static int countCycles(int array[], int startIndex) {

		Map<Integer, Integer> visitedIndex = new HashMap<>();
		int count = 1;
		int index = startIndex;

		while (!visitedIndex.containsKey(index)) {
			if (array[index] >= array.length)
				return -1;

			visitedIndex.put(index, count);
			count++;
			index = array[index];
		}

		return count - visitedIndex.get(index);
	}

	public static void main(String[] args) {

		boolean pass = true;
		pass = pass && countCycles(new int[]{1, 3, 0, 4, 1}, 0) == 3;
		pass = pass && countCycles(new int[]{1, 2, 3, 4, 5, 6}, 0) == -1;
		pass = pass && countCycles(new int[]{1, 2, 1, 3, 4, 8}, 0) == 2;
		pass = pass && countCycles(new int[]{1, 0}, 0) == 2;

		if (pass)
			System.out.println("All test cases are passed");
		else
			System.out.println("At least one test case failed");
	}
}
