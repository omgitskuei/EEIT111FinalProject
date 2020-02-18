package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetRuntimeInput {
	// Local Fields
	BufferedReader bReader;
	String input;

	// Constructors
	public GetRuntimeInput() {
		System.out.println("BEGIN: util.GetRuntimeInput()");
	}

	public GetRuntimeInput(String prompt) {
		System.out.println("BEGIN: util.GetRuntimeInput()");
		this.input = getConsoleInputBR(prompt);
	}

	// Methods
	public String getConsoleInputBR(String prompt) {
		try {
			// Local variables
			bReader = new BufferedReader(new InputStreamReader(System.in));
			// Print prompt
			System.out.println(prompt);
			// Input
			input = bReader.readLine();
			System.out.println("You entered: " + input);
			// Close
			bReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println("FINISH: util.GetRuntimeInput()");
		return input;
	}

	// Methods
	// Executable
	public static void main(String args[]) {
		// 2 ways to execute class
		// note, cannot un-comment both 1) AND 2)
		// 1) 
		GetRuntimeInput util1 = new GetRuntimeInput();
		String input1 = util1.getConsoleInputBR("Input String:");
		System.out.println(input1);

		// 2) Persist values
		GetRuntimeInput util = new GetRuntimeInput("Input String:");
		String input = util.input;
		System.out.println(input);
	}
}
