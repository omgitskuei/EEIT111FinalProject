package util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GetHashing {
	// Local fields
	String originalString = "null";
	String resultHash = "null";
	
	// Constructors
	public GetHashing() {
		System.out.println("BEGIN: util.GetHashing()");
		;
	}
	public GetHashing(String aString) {
		System.out.println("BEGIN: util.GetHashing(String)");
		this.originalString = aString;
		String resultHashString = hashString(this.originalString);
		System.out.println("Result HashString: "+resultHashString);
		this.resultHash = resultHashString;
	}
	
	// Methods
	public String hashString(String originalString) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] encodedHash = digest.digest(originalString.getBytes(StandardCharsets.UTF_8));
			System.out.println("  Converting plaintext(String) to hash(byte[]): "+encodedHash);
			String hexString = bytesToHex(encodedHash);
			System.out.println("  Converting hash(byte[]) to hash(hexString): "+hexString);
			return hexString;
		} catch (NoSuchAlgorithmException e) {
			System.out.println("ERROR: util.GetHashing().hashString(String) threw EXCEPTION");
			e.printStackTrace();
			return "null";
		}
	}
	// Private method for hashString(String)
	private static String bytesToHex(byte[] hash) {
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < hash.length; i++) {
			String hex = Integer.toHexString(0xff & hash[i]);
			if (hex.length() == 1)
				hexString.append('0');
			hexString.append(hex);
		}
		return hexString.toString();
	}
	
	// Executable
	public static void main(String[] args) {
		GetRuntimeInput util0 = new GetRuntimeInput();
		String input = util0.getConsoleInputBR("Input String:");
		
		// Two ways of using this util;
		// 1) Persist object and values
		GetHashing util1 = new GetHashing(input);
		System.out.println("What are its local fields? "+util1.originalString+", "+util1.resultHash);
		String result1 = util1.resultHash;
		
		// 2) Explicitly call method for return, no value persistence
		GetHashing util2 = new GetHashing();
		System.out.println("What are its local fields? "+util2.originalString+", "+util2.resultHash);
		String result2 = util2.hashString(input);
	}

	
}
