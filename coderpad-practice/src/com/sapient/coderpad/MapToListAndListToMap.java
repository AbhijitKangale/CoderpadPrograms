package com.sapient.coderpad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee {
	int id;
	String name;
	List<String> subjects;
	List<Integer> phoneNumbers;
	String city;

	public Employee(int id, String name, List<String> subjects, List<Integer> phoneNumbers, String city) {
		super();
		this.id = id;
		this.name = name;
		this.subjects = subjects;
		this.phoneNumbers = phoneNumbers;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}

	public List<Integer> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<Integer> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", subjects=" + subjects + ", phoneNumbers=" + phoneNumbers
				+ ", city=" + city + "]";
	}

}

public class MapToListAndListToMap {

	public static void main(String[] args) {

		Employee e1 = new Employee(1, "John", Arrays.asList("Maths", "History", "Biology"), Arrays.asList(123, 456),
				"Mumbai");
		Employee e2 = new Employee(2, "Smith", Arrays.asList("English", "History", "Geology"), Arrays.asList(789, 145),
				"Pune");
		Employee e3 = new Employee(3, "Ben", Arrays.asList("Maths", "Science", "Hindi"), Arrays.asList(147, 258),
				"Mumbai");

		// convert list to map
		List<Employee> emp = new ArrayList<>();
		emp.add(e1);
		emp.add(e2);
		emp.add(e3);

		emp.stream().collect(Collectors.toMap(Employee::getId, Employee::getSubjects)).entrySet()
				.forEach(System.out::println);

		// group list of employees based on city
		emp.stream().collect(Collectors.groupingBy(Employee::getCity)).entrySet().forEach(System.out::println);

		// convert map to list
		Map<Integer, Employee> studentMap = new HashMap<>();
		studentMap.put(e1.getId(), e1);
		studentMap.put(e2.getId(), e2);
		studentMap.put(e3.getId(), e3);

		List<Integer> numbers = new ArrayList<>();

		studentMap.entrySet().stream().filter(i -> i.getValue().getSubjects().contains("Maths"))
				.collect(Collectors.toList()).forEach(i -> {
					for (Integer n : i.getValue().getPhoneNumbers())
						numbers.add(n);
				});

		numbers.stream().forEach(System.out::println);
	}

}
