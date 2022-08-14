package com.learning.collection.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

import java.util.Set;
import java.util.TreeSet;


public class CollectionSet {
	
	Set<Employee> listEmployee = new HashSet<Employee>();
	Set<Employee> listEmployeeLinkedHashSet = new LinkedHashSet();
	Set<Employee> listEmployeeTreeSet = new TreeSet<Employee>();
	
	
	public void addItem(Employee employee) {
		listEmployee.add(employee);
	}
	
	public void printEmployees() {
		System.out.println("---- Iterator for list ----");
		Iterator<Employee> itr = listEmployee.iterator();
		while(itr.hasNext()) {
			System.out.println(" Employee id " +itr.next().getEmployeeName());
		}
		System.out.println(".........");
	}
	
	public void advanceForLoopPrintEmployee() {
		System.out.println("**** Advanced for loop ****");
		for(Employee e : this.listEmployee) {
			System.out.println("Employee id "+e.getEmployeeId()+" Employee name "+e.getEmployeeName());
		}
		System.out.println(".........");
	}
	
	public void printLinkedHashSet() {
		System.out.println("Printing linked hash set ...");
		for(Employee e : this.listEmployeeLinkedHashSet) {
			System.out.println("Employee id "+e.getEmployeeId()+" Employee name "+e.getEmployeeName());
		}
		System.out.println(".........");
	}
	
	public void printTreeSet() {
		System.out.println("Printing treeset ... ");
		for(Employee e : this.listEmployeeTreeSet) {
			System.out.println("Employee id "+e.getEmployeeId()+" Employee name "+e.getEmployeeName());
		}
		System.out.println(".........");
	}
	
	public static void main(String args[]) {
		Employee e1 = new Employee(11111, "Employee 1", 8);
		Employee e2 = new Employee(22222, "Employee 2", 10);
		Employee e3 = new Employee(33333, "Employee 3", 10);
		Employee e4 = new Employee(11111, "Employee X", 80); // Trying to add duplicate item
		
		CollectionSet listEmp = new CollectionSet();
		listEmp.addItem(e1);
		listEmp.addItem(e2);
		listEmp.addItem(e3);
		listEmp.addItem(e4);
		
		listEmp.listEmployeeLinkedHashSet.addAll(listEmp.listEmployee);
		listEmp.listEmployeeTreeSet.addAll(listEmp.listEmployee);
		
		listEmp.printEmployees();
		listEmp.advanceForLoopPrintEmployee();
		
		listEmp.printLinkedHashSet();
		listEmp.printTreeSet();
	}

}
