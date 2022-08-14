package com.learning.abstractAndInterface;

public class InterfaceCProgramImpl implements InterfaceLanguage{
	@Override
	public void printSyntax() {
		System.out.println("  C does not have system.out.println... ");
	}

	@Override
	public void printLanguageType() {
		System.out.println("  This is C programming language... ");
	}
}
