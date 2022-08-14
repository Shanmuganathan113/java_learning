package com.learning.abstractAndInterface;

public class AbstractMain {

	public static void main(String[] args) {
		AbstractJavaImpl absJava = new AbstractJavaImpl();
		absJava.printLanguageType();
		absJava.printSyntax();
		
		AbstractCProgramImpl absCPgm = new AbstractCProgramImpl();
		absCPgm.printLanguageType();
		absCPgm.printSyntax();
	}

}
