package com.learning.java8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FIImplInBuilt {
	
	/* Below are the four functional interfaces provided by Java 8
	 * */
	
	Consumer<Integer> 			c = a -> System.out.println("Consumer : "+(a + a)); 
	Supplier<Double>  			s = () -> Math.random();
	Function<Integer,Integer> 	f = a -> a * a;
	Predicate<Integer> 			p = p -> (p%2 == 0);  
	
	public void processFunctionalInterfaces() {
		c.accept(5);
		System.out.println("Random number : "+ s.get());
		System.out.println("Square of 5 : "+ f.apply(5));
		System.out.println("2 is a odd number : "+p.test(2));
	}
	
	public static void main(String[] args) {
		FIImplInBuilt fiInBuilt = new FIImplInBuilt();
		fiInBuilt.processFunctionalInterfaces();
	}
}
