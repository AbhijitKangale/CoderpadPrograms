package com.sapient.coderpad;

import java.util.Arrays;

public class ImplementRobotMovements {

	public static Integer[] walk(String path) {
		Integer[] result = new Integer[]{0, 0};
		for (char ch : path.toCharArray()) {
			switch (ch) {
				case 'U' :
					result[1] += 1;
					break;
				case 'D' :
					result[1] -= 1;
					break;
				case 'L' :
					result[0] -= 1;
					break;
				case 'R' :
					result[0] += 1;
					break;
				default :
					break;
			}
		}

		return result;
	}

	public static boolean isEquals(Integer a[], Integer b[]) {
		return Arrays.equals(a, b);
	}

	public static boolean doTestsPass() {
		boolean res = true;
		{
			String test = "";
			Integer[] result = walk(test);
			res &= isEquals(result, new Integer[]{0, 0});
		}

		{
			String test = "L";
			Integer[] result = walk(test);
			res &= isEquals(result, new Integer[]{-1, 0});
		}

		return res;
	}

	public static void main(String[] args) {
		if (doTestsPass()) {
			System.out.println("All tests pass");
		} else {
			System.out.println("There are test failures");
		}
	}
}
