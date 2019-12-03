package com.sapient.coderpad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindBestAverageGrade {

	public static int findBestAverageGrade(String[][] scoreRows) {

		if (scoreRows == null || scoreRows.length == 0)
			return 0;

		Map<String, List<Double>> studentWithScoreList = new HashMap<>();
		for (String[] scoreRow : scoreRows) {
			if (scoreRow.length != 2)
				return 0;

			String student = scoreRow[0];
			Double score = Double.parseDouble(scoreRow[1]);

			List<Double> studentScores = studentWithScoreList.get(student);
			if (studentScores == null) {
				studentScores = new ArrayList<>();
				studentScores.add(score);
				studentWithScoreList.put(student, studentScores);
			} else
				studentScores.add(score);
		}

		Double max = -Double.MAX_VALUE;

		for (List<Double> eachStudentScores : studentWithScoreList.values()) {
			double sum = 0;
			for (Double score : eachStudentScores)
				sum += score;

			double average = sum / eachStudentScores.size();

			// this depends on the requirement
			// average = Math.floor(average);

			max = Math.max(max, average);
		}

		return (int) Math.floor(max);
	}

	public static int findBestAverageGradeUsingJava8(String[][] scoreRows) {

		if (scoreRows == null || scoreRows.length == 0)
			return 0;

		Map<String, List<Double>> studentWithScoreList = new HashMap<>();

		for (String[] scoreRow : scoreRows) {
			if (scoreRow.length != 2)
				return 0;

			String student = scoreRow[0];
			Double score = Double.parseDouble(scoreRow[1]);

			List<Double> studentScores = studentWithScoreList.get(student);
			if (studentScores == null) {
				studentScores = new ArrayList<>();
				studentScores.add(score);
				studentWithScoreList.put(student, studentScores);
			} else
				studentScores.add(score);
		}

		return (int) Math.floor(studentWithScoreList.entrySet().stream()
				.collect(Collectors.toMap(Map.Entry::getKey,
						e -> e.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble()))
				.entrySet().stream().max((p, q) -> p.getValue() > q.getValue() ? 1 : -1).get().getValue());
	}

	public static void doTestPass() {
		Map<String[][], Integer> inputTests = new HashMap<>();

		inputTests.put(
				new String[][] { { "Bobby", "87" }, { "Charles", "100" }, { "Eric", "64" }, { "Charles", "22" } }, 87);

		inputTests.put(new String[][] {}, 0);

		inputTests.put(new String[][] { { "Bobby", "87" }, { "Charles" }, { "Eric", "64" }, { "Charles", "22" } }, 0);

		inputTests.put(new String[][] { { "Bobby", "-87.1" }, { "Charles", "-100" }, { "Eric", "-64" },
				{ "Charles", "-26.7" } }, -64);

		for (Map.Entry<String[][], Integer> test : inputTests.entrySet()) {
			Integer actual = findBestAverageGrade(test.getKey());
			if (actual == test.getValue())
				System.out.println("Test passed for input ==> " + Arrays.deepToString(test.getKey()));
			else
				System.out.println("Test failed for input ==> " + Arrays.deepToString(test.getKey()));
		}

		for (Map.Entry<String[][], Integer> test : inputTests.entrySet()) {
			Integer actual = findBestAverageGradeUsingJava8(test.getKey());
			if (actual == test.getValue())
				System.out
						.println("Test passed using Java 8 stream for input ==> " + Arrays.deepToString(test.getKey()));
			else
				System.out
						.println("Test failed using Java 8 stream for input ==> " + Arrays.deepToString(test.getKey()));
		}
	}

	public static void main(String[] args) {
		doTestPass();
	}
}