package com.sapient.coderpad;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountMaxRepeatedIPAddressInLogFile {

	public static String findMostRepeatedIPAddress(String lines[]) {
		Map<String, Integer> ipAddressCount = new HashMap<>();

		Arrays.stream(lines).forEach(line -> {
			String ipAddress = line.split(" ")[0];
			Integer count = ipAddressCount.getOrDefault(ipAddress, 0);
			ipAddressCount.put(ipAddress, count + 1);
		});

		return ipAddressCount.entrySet().stream()
				.max((p1, p2) -> p1.getValue() > p2.getValue() ? 1 : -1).get()
				.getKey();
	}

	public static void main(String[] args) {

		String log1[] = new String[]{"10.0.0.1 - log entry 1 11",
				"10.0.0.1 - log entry 1 12", "10.0.0.1 - log entry 1 13",
				"10.0.0.1 - log entry 1 14", "10.0.0.1 - log entry 1 15",
				"10.0.0.2 - log entry 1 21"};

		String result = findMostRepeatedIPAddress(log1);

		if (result.equals("10.0.0.1"))
			System.out.println("Test case passed for input ==> log1");
		else
			System.out.println("Test case failed for input ==> log1");
	}
}
