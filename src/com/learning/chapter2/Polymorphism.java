package com.learning.chapter2;

public class Polymorphism {

	public void calculateArea(Integer length) {
		Integer area = length * length;
		System.out.println(" Area of Square : "+area);
	}
	
	public void calculateArea(Integer length, Integer breadth) {
		Integer area = length * breadth;
		System.out.println(" Area of Rectangle : "+area);
	}
	
	public static void main(String args[]) {
		Polymorphism polymorphism = new Polymorphism();
		
		polymorphism.calculateArea(5);
		polymorphism.calculateArea(5,10);
	}
	
	
}
