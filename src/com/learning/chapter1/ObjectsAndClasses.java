package com.learning.chapter1;

public class ObjectsAndClasses {
	public static void main(String args[]) {
		
		Employee e = new Employee();
		e.setEmployeeName("EmployeeABC");
		e.setEmployeeId(123456);
		e.setYearsOfExp(5);
		
		Student s = new Student();
		s.setStudentName("StudentABC");
		s.setSchoolName("ABC matric school");
				
		System.out.println("Printing employee details");
		System.out.println("Employee ID : "		+ e.getEmployeeId());
		System.out.println("Employee Name : "	+ e.getEmployeeName());
		System.out.println("Years of Exp : "	+ e.getYearsOfExp());
		
		System.out.println(" Printing Student details");
		System.out.println(" Student Name : "	+s.getStudentName());
		System.out.println(" School Name :"		+s.getSchoolName());
	}

}
