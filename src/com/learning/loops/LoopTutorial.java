package com.learning.loops;

public class LoopTutorial {

	public void printWhileLoop(int j) {
		int i = 0 ;
		while (i < j) {
		  System.out.println("While loop Printing -- "+i);
		  i++;
		}
	}
	
	public void printForLoop(int j) {
		for(int i =0; i<j; i++) {
		  System.out.println("For Loop Printing -- "+i);
		}
	}
	
	public void printDoWhile(int j) {
		int i = 0;
		do {
		  System.out.println("Do while Printing -- "+i);
		  i++;
		}
		while (i < j);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoopTutorial loops = new LoopTutorial();
		loops.printForLoop(5);
		loops.printDoWhile(5);
		loops.printWhileLoop(5);
	}

}
