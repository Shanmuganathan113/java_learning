package com.learning.java8;

public class FIImpl {
	
	FICalculator sum = a -> a + a;
	FICalculator square = a -> a * a;
	FICalculator cube = a -> a * a * a;
	
	public void calculator( int a) {
		System.out.println("Calculating values for integer "+ a);
		System.out.println(" Sum Value : "+sum.calculate(a));
		System.out.println(" Square Value : "+square.calculate(a));
		System.out.println(" Cube Value : "+cube.calculate(a));
		System.out.println("---------------- ");
	}
	
	public static void main(String[] args) {
		FIImpl fi = new FIImpl();
		fi.calculator(5);
		fi.calculator(10);
		
	}

}
