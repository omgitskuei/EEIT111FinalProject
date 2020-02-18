package util;

import java.util.ArrayList;

public class GetCode {
	// local variables
	private int length;
	private boolean includeNums = false;
	private boolean includeLetters = false;
	private boolean includeSpecialCharacters = false;
	ArrayList<String> genBank = new ArrayList<String>();
	String code = "";
	
	// constructors
	public GetCode() {
		System.out.println("BEGIN: util.GetCode()");
	}
	
	public GetCode(int length, boolean includeNums, boolean includeLetters, boolean includeSpecialCharacters) {
		System.out.println("BEGIN: util.GetCode(int, boolean, boolean, boolean)");
		this.length = length;
		this.includeNums = includeNums;
		this.includeLetters = includeLetters;
		this.includeSpecialCharacters = includeSpecialCharacters;
	}
	
	public GetCode(String length, boolean includeNums, boolean includeLetters, boolean includeSpecialCharacters) {
		System.out.println("BEGIN: util.GetCode(int, boolean, boolean, boolean)");
		int lengthInt = Integer.parseInt(length);
		this.length = lengthInt;
		this.includeNums = includeNums;
		this.includeLetters = includeLetters;
		this.includeSpecialCharacters = includeSpecialCharacters;
	}
	
	// methods	
	public String generateCode() {
		if (this.includeNums==true) {
			genBank.add("0");
			genBank.add("1");
			genBank.add("2");
			genBank.add("3");
			genBank.add("4");
			genBank.add("5");
			genBank.add("6");
			genBank.add("7");
			genBank.add("8");
			genBank.add("9");
		}
		if (this.includeLetters==true) {
			genBank.add("a");
			genBank.add("b");
			genBank.add("c");
			genBank.add("d");
			genBank.add("e");
			genBank.add("f");
			genBank.add("g");
			genBank.add("h");
			genBank.add("i");
			genBank.add("j");
			genBank.add("k");
			genBank.add("l");
			genBank.add("m");
			genBank.add("n");
			genBank.add("o");
			genBank.add("p");
			genBank.add("q");
			genBank.add("r");
			genBank.add("s");
			genBank.add("t");
			genBank.add("u");
			genBank.add("v");
			genBank.add("x");
			genBank.add("y");
			genBank.add("z");
		}
		if (this.includeSpecialCharacters==true) {
			genBank.add("!");
			genBank.add("@");
			genBank.add("#");
			genBank.add("$");
			genBank.add("%");
			genBank.add("^");
			genBank.add("&");
			genBank.add("*");
			genBank.add("(");
			genBank.add(")");
			genBank.add("?");
		}
		// Show bank
		System.out.println("Code Generator Bank: "+genBank);
		
		String newest = "";
		for(int index=0; index<this.length; index++) {
			int random = (int) ((Math.random() * ((genBank.size()-1) - 0)) + 0);
			newest = genBank.get(random);
			// Show new appended random character
			//System.out.println(newest);
			
			this.code = this.code+newest;
			// Show code so far
			//System.out.println(this.code);
		}
		System.out.println("Generated code: "+this.code);
		return code;
	}

	// executable
	public static void main(String[] args) {
//		GetRuntimeInput console = new GetRuntimeInput();
//		String input = console.getConsoleInputBR("Input length:");
//		int length = Integer.parseInt(input);
		
		GetCode gen = new GetCode(10, true, false, false);
		String result = gen.generateCode();
	}
}
