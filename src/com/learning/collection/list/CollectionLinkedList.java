package com.learning.collection.list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CollectionLinkedList {
	List<Employee> listEmployee = new LinkedList<Employee>();
	
	public void addListItem(Employee employee) {
		listEmployee.add(employee);
	}
	
	public void printEmployees() {
		System.out.println("---- Iterator for list ----");
		Iterator<Employee> itr = listEmployee.iterator();
		while(itr.hasNext()) {
			System.out.println(" Employee id "+ itr.next().getEmployeeId());
		}
	}
	
	public void advanceForLoopPrintEmployee() {
		System.out.println("**** Advanced for loop ****");
		for(Employee e : this.listEmployee) {
			System.out.println("Employee id "+e.getEmployeeId());
		}
	}
	public static void main(String args[]) {
		Employee e1 = new Employee(11111, "Employee 1", 8);
		Employee e2 = new Employee(22222, "Employee 2", 10);
		Employee e3 = new Employee(33333, "Employee 3", 10);
		
		CollectionLinkedList listEmp = new CollectionLinkedList();
		listEmp.addListItem(e1);
		listEmp.addListItem(e2);
		listEmp.addListItem(e3);
		
		listEmp.printEmployees();
		listEmp.advanceForLoopPrintEmployee();
	}
}
