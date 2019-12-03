package com.sapient.coderpad;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountMaxRepeatedIPAddressInLogFile {

	public static String findMostRepeatedIPAddress(String lines[]) {
		Map<String, Integer> ipAddressCount = new HashMap<>();

		Arrays.stream(lines).forEach(line -> {
			String[] strings = line.split(" ");
			for (String ipAddress : strings) {
				if (isValidIPAddress(ipAddress)) {
					Integer count = ipAddressCount.getOrDefault(ipAddress, 0);
					ipAddressCount.put(ipAddress, count + 1);
				}
			}
		});

		if (ipAddressCount.isEmpty())
			return "";

		return ipAddressCount.entrySet().stream().max((p1, p2) -> p1.getValue() > p2.getValue() ? 1 : -1).get()
				.getKey();
	}

	private static boolean isValidIPAddress(String ip) {
		String[] groups = ip.split("\\.");

		if (groups.length != 4)
			return false;

		try {
			return Arrays.stream(groups).map(Integer::parseInt).filter(i -> (i >= 0 && i <= 255)).count() == 4;
		} catch (Exception e) {
			return false;
		}
	}

	public static void main(String[] args) {

		String log[] = new String[] { "10.0.0.1 - log entry 1 11", "10.0.0.1 - log entry 1 12",
				"10.0.0.1 - log entry 1 13", "10.0.0.1 - log entry 1 14", "10.0.0.1 - log entry 1 15",
				"10.0.0.2 - log entry 1 21" };

		String log1[] = new String[] { "10.0.0.1-1 - log entry 1 11", "10.0.0.2 - log entry 1 12",
				"10.0.0.1 - log entry 1 13", "10.0.0.2 - log entry 1 14", "10.0.0.2 - log entry 1 15",
				"10.0.0.2 - log entry 1 21" };

		String log2[] = new String[] { "10 - log entry 1 11", "10 - log entry 1 12", "10 - log entry 1 13",
				"10 - log entry 1 14", "10 - log entry 1 15", "10 - log entry 1 21" };

		String result = findMostRepeatedIPAddress(log);

		String result1 = findMostRepeatedIPAddress(log1);

		String result2 = findMostRepeatedIPAddress(log2);

		if (result.equals("10.0.0.1"))
			System.out.println("Test case passed for input ==> log");
		else
			System.out.println("Test case failed for input ==> log");

		if (result1.equals("10.0.0.2"))
			System.out.println("Test case passed for input ==> log1");
		else
			System.out.println("Test case failed for input ==> log1");

		if (result2.equals(""))
			System.out.println("Test case passed for input ==> log2");
		else
			System.out.println("Test case failed for input ==> log2");
	}
}
