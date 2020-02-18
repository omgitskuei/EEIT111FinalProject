package util;

public class EncodeHexString {
	// Local fields
	String hexString;
	byte[] byteArray;

	// Constructors
	public EncodeHexString() {
		System.out.println("BEGIN: util.EncodeHexString()");
	}

	public EncodeHexString(String aHexString) {
		System.out.println("BEGIN: util.EncodeHexString(String aHexString)");
		this.hexString = aHexString;
		//HexStringToByteArray(this.hexString);
	}

	public EncodeHexString(byte[] aByteArray) {
		System.out.println("BEGIN: util.EncodeHexString(byte[] aByteArray)");
		this.byteArray = aByteArray;
		//byteArrayToHexString(this.byteArray);
	}

	public static void main(String[] args) {

		// Create a new instance of this class to use its hexString --> byte[] method
		// Passes a String to the constructor, setting its local field hexstring
		EncodeHexString thisClass = new EncodeHexString("1254324567");
		// Check in console what the String hexString is
		System.out.println("aHexString: " + thisClass.hexString);
		byte[] resultByteArray = thisClass.HexStringToByteArray(thisClass.hexString);
		
		System.out.println("");
		
		// Create a new instance of this class to use its byte[] --> hexString method
		// Passes a byte[] to the constructor, setting its local field byteArray
		EncodeHexString thisClass1 = new EncodeHexString(resultByteArray);
		// Check in console what the byte[] byteArray is
		System.out.println("aByteArray: " + thisClass1.byteArray);
		String resultHexString = thisClass1.byteArrayToHexString(thisClass1.byteArray);
	}

	// Methods
	public String byteArrayToHexString(byte[] byteArray) {
		StringBuffer HexStringBuffer = new StringBuffer();
		for (int i = 0; i < byteArray.length; i++) {
			char[] hexDigits = new char[2];
			hexDigits[0] = Character.forDigit((byteArray[i] >> 4) & 0xF, 16);
			hexDigits[1] = Character.forDigit((byteArray[i] & 0xF), 16);
			HexStringBuffer.append(new String(hexDigits));
		}
		String result = HexStringBuffer.toString();
		System.out.println("Result HexString: "+result);
		return result;
	}

	public byte[] HexStringToByteArray(String HexString) {
		if (HexString.length() % 2 == 1) {
			throw new IllegalArgumentException("Invalid hexadecimal String supplied.");
		}
		byte[] bytes = new byte[HexString.length() / 2];
		for (int i = 0; i < HexString.length(); i += 2) {
			int firstDigit = Character.digit(HexString.substring(i, i + 2).charAt(0), 16);
			if (firstDigit == -1) {
				throw new IllegalArgumentException(
						"Invalid Hexadecimal Character: " + HexString.substring(i, i + 2).charAt(0));
			}
			int secondDigit = Character.digit(HexString.substring(i, i + 2).charAt(1), 16);
			if (secondDigit == -1) {
				throw new IllegalArgumentException(
						"Invalid Hexadecimal Character: " + HexString.substring(i, i + 2).charAt(1));
			}
			bytes[i / 2] = (byte) ((firstDigit << 4) + secondDigit);
		}
		System.out.println("Result byte[]: "+bytes);
		return bytes;
	}

	public String getHexString() {
		return hexString;
	}

	public void setHexString(String HexString) {
		this.hexString = HexString;
	}

	public byte[] getByteArray() {
		return byteArray;
	}

	public void setByteArray(byte[] byteArray) {
		this.byteArray = byteArray;
	}

}
