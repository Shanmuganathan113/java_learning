package com.learning.collection.list; // package details

public class Employee { // Class declaration
	private Integer employeeId; 	// Variable
	private String 	employeeName; 	// Variable
	private Integer yearsOfExp;
	
	public String getEmployeeName() { // Method
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public Integer getYearsOfExp() {
		return yearsOfExp;
	}
	public void setYearsOfExp(Integer yearsOfExp) {
		this.yearsOfExp = yearsOfExp;
	}
	public Employee(Integer employeeId, String employeeName, Integer yearsOfExp) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.yearsOfExp = yearsOfExp;
	}
	
}
