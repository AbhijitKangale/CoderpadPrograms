package com.sapient.coderpad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindBestAverageGrade {

	public static int findBestAverageGrade(String[][] scoreRows) {

		if (scoreRows == null || scoreRows.length == 0)
			return 0;

		HashMap<String, List<Integer>> studentWithScoreList = new HashMap<>();
		for (String[] scoreRow : scoreRows) {
			if (scoreRow.length != 2)
				return 0;

			String student = scoreRow[0];
			Integer score = Integer.parseInt(scoreRow[1]);

			List<Integer> studentScores = studentWithScoreList.get(student);
			if (studentScores == null) {
				studentScores = new ArrayList<>();
				studentScores.add(score);
				studentWithScoreList.put(student, studentScores);
			} else
				studentScores.add(score);
		}

		Double max = -Double.MAX_VALUE;

		for (List<Integer> eachStudentScores : studentWithScoreList.values()) {
			int sum = 0;
			for (Integer score : eachStudentScores)
				sum += score;

			double average = sum / eachStudentScores.size();
			max = Math.max(max, average);
		}

		return (int) Math.floor(max);
	}

	public static void doTestPass() {
		Map<String[][], Integer> inputTests = new HashMap<>();

		inputTests.put(
				new String[][] { { "Bobby", "87" }, { "Charles", "100" }, { "Eric", "64" }, { "Charles", "22" } }, 87);

		inputTests.put(new String[][] {}, 0);

		inputTests.put(new String[][] { { "Bobby", "87" }, { "Charles" }, { "Eric", "64" }, { "Charles", "22" } }, 0);

		for (Map.Entry<String[][], Integer> test : inputTests.entrySet()) {
			Integer actual = findBestAverageGrade(test.getKey());
			if (actual == test.getValue())
				System.out.println("Test passed for input ==> " + Arrays.deepToString(test.getKey()));
			else
				System.out.println("Test failed for input ==> " + Arrays.deepToString(test.getKey()));
		}
	}

	public static void main(String[] args) {
		doTestPass();
	}
}
