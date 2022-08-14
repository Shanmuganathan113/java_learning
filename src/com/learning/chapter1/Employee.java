package com.learning.chapter1; // package details

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
}
