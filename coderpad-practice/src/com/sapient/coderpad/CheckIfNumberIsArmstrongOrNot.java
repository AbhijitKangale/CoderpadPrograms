package com.sapient.coderpad;

public class CheckIfNumberIsArmstrongOrNot {

	public static boolean isArmstrong(int number) {
		int n = getOrger(number);
		int sum = 0;
		int temp = number;

		while (temp != 0) {
			int r = temp % 10;
			sum += power(r, n);
			temp = temp / 10;
		}

		return (sum == number);
	}

	private static int power(int n, int e) {
		if (e == 0)
			return 1;

		if (e % 2 == 0)
			return power(n, e / 2) * power(n, e / 2);

		return n * power(n, e / 2) * power(n, e / 2);
	}

	private static int getOrger(int n) {
		int order = 0;

		while (n != 0) {
			order++;
			n = n / 10;
		}

		return order;
	}

	public static void main(String[] args) {

		boolean pass = true;

		pass = pass && isArmstrong(153);
		pass = pass && isArmstrong(1253);

		if (pass)
			System.out.println("All test cases are passed");
		else
			System.out.println("At least one test case failed");
	}
}
