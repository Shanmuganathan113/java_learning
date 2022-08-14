package com.learning.exception;

public class ExceptionHandling {

	public void throwException() {
		String a = null;
		System.out.println("Length of a is "+a.length());
	}
	
	public void handleException() {
		String a = "Test word";
		System.out.println("Length of a is "+a.length());
		
		String b = null;
		try {
		System.out.println(" Length of b is "+b.length());
		}catch (NullPointerException e) {
			System.out.println("Throws null pointer exception...");
		}catch (Exception e) {
			System.out.println("Throws exception...");
		}
	}
	
	public static void main(String[] args) {
		ExceptionHandling exp =new ExceptionHandling();
		// exp.throwException();
		exp.handleException();
		
	}

}
