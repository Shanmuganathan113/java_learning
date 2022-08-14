package com.learning.conditionalStatements;

public class ConditionalStatements {

	public void printSwtichCase(int a) {
		switch(a) {
		case 1:
			System.out.println("a is one");
			break;
		case 2:
			System.out.println("a is two");
			break;
		case 3:
			System.out.println("a is three");
			break;
		default:
			System.out.println("a is greater than 3");
		}
	}
	
	public void printIfCondition(int a) {
		if(a == 1)
			System.out.println(" a is one");
		else
			System.out.println(" a is not one");
	}
	
	public void printNestedIfCondition(int a) {
		if(a == 1)
			System.out.println(" a is one");
		else if(a == 2)
			System.out.println(" a is two");
		else if(a == 3)
			System.out.println(" a is three");
		else
			System.out.println(" a greater than 3");
	}
	
	public static void main(String[] args) {
		ConditionalStatements conditionalStatements = new ConditionalStatements();
		// Update the below input params and validate
		conditionalStatements.printIfCondition(1);
		conditionalStatements.printNestedIfCondition(3);
		conditionalStatements.printSwtichCase(5);
		
	}

}
