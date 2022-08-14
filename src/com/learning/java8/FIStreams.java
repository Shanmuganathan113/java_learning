package com.learning.java8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.learning.collection.map.Employee;

public class FIStreams {
	List<Employee> listEmp = new ArrayList<Employee>();
	
	public void loadData() {
		Employee e1 = new Employee(11111, "Employee 1", 12);
		Employee e2 = new Employee(22222, "Employee 2", 3);
		Employee e3 = new Employee(33333, "Employee 3", 5);
		Employee e4 = new Employee(44444, "Employee 4", 13);
		
		listEmp.add(e1);
		listEmp.add(e2);
		listEmp.add(e3);
		listEmp.add(e4);
	}
	
	public void streamFunctions() {
		
		System.out.println(".......... Processing for each..........");
		listEmp.forEach( System.out::println); // This is equal to e -> System.out.println(e)
		System.out.println("........................................");
		
		System.out.println(".......... Processing filters ..........");
		List<Employee> listExpMoreThan10yrs = listEmp.stream().filter( e -> e.getYearsOfExp() > 10).collect(Collectors.toList());
		listExpMoreThan10yrs.forEach( System.out::println);
		System.out.println("........................................");
		
		System.out.println(".......... Processing Map-Get emp names ..........");
		List<String> listEmployeeNames = listEmp.stream().map( e -> e.getEmployeeName()).collect(Collectors.toList());
		listEmployeeNames.forEach( System.out::println);
		System.out.println("........................................");
	
		System.out.println(".......... Processing Optional classes ..........");
		Optional<Employee> expWith5yrs = listEmp.stream().filter( e -> e.getYearsOfExp() == 5 ).findAny();
		System.out.println("Any employee with 5 years exp present: "+expWith5yrs.isPresent());
		System.out.println("........................................");
	
		System.out.println("...... Soreted in ascending .....");
		Comparator<Employee> sortedEmployeesWithExp = Comparator.comparing(Employee::getYearsOfExp).thenComparing(Employee::getEmployeeId);
		Collections.sort(listEmp,sortedEmployeesWithExp);
		listEmp.forEach(System.out::println);
		
		System.out.println("...... Soreted in descending .....");
		Comparator<Employee> sortedEmployeesWithExpDesc = (Employee e1,Employee e2) -> e2.getYearsOfExp().compareTo(e1.getYearsOfExp());
		Collections.sort(listEmp,sortedEmployeesWithExpDesc);
		listEmp.forEach(System.out::println);
		
	}

	public static void main(String[] args) {
		FIStreams fiStream = new FIStreams();
		fiStream.loadData();
		
		fiStream.streamFunctions();
	}
	
}
