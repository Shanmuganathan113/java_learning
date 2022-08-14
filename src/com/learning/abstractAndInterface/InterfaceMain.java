package com.learning.abstractAndInterface;

public class InterfaceMain {
	
	public static void main(String[] args) {
		InterfaceJavaImpl intJava = new InterfaceJavaImpl();
		intJava.printLanguageType();
		intJava.printSyntax();
		
		InterfaceCProgramImpl intCPgm = new InterfaceCProgramImpl();
		intCPgm.printLanguageType();
		intCPgm.printSyntax();
	}
}
