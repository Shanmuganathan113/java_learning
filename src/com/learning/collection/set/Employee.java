package com.learning.collection.set; // package details

public class Employee implements Comparable<Employee>{ // Class declaration
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
	@Override
	public int hashCode() {
		return employeeId;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			return false;
		return true;
	}
	@Override
	public int compareTo(Employee o) {
		return this.employeeId.compareTo(o.getEmployeeId());
	}
}
