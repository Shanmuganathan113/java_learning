package com.learning.abstractAndInterface;

public class InterfaceJavaImpl implements InterfaceLanguage {

	@Override
	public void printSyntax() {
		System.out.println("  Java have system.out.println... ");
	}

	@Override
	public void printLanguageType() {
		System.out.println("  This is java programming language... ");
	}
}
