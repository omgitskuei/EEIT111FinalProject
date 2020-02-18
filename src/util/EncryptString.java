package util;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.CleartextKeysetHandle;
import com.google.crypto.tink.JsonKeysetReader;
import com.google.crypto.tink.JsonKeysetWriter;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.aead.AeadConfig;
import com.google.crypto.tink.aead.AeadKeyTemplates;
import com.google.crypto.tink.proto.KeyTemplate;

public class EncryptString {
	// Local fields
	String plainText;
	String ad;

	// Constructors
	public EncryptString() {
		System.out.println("BEGIN: util.EncryptString()");
	}

	// Methods
	public Aead newCleartextAEADKeyset() {
		try {
			// Initializing Tink/AEAD
			AeadConfig.register();
			// Generating new key material/keysets
			KeyTemplate keyTemplate = AeadKeyTemplates.AES256_GCM;
			KeysetHandle keysetHandle = KeysetHandle.generateNew(keyTemplate);
			// Write key material to file/store them
			String keysetFilename = "keyset.json";
			CleartextKeysetHandle.write(keysetHandle, JsonKeysetWriter.withFile(new File(keysetFilename)));
			// Obtaining and using primitive AEAD
			Aead aead = keysetHandle.getPrimitive(Aead.class);
			return aead;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("EXCEPTION at util.EncryptString.newCleartextAEADKeyset: Returning NULL");
			return null;
		}
	}

	public byte[] encryptGoogleTinkAEAD(String plainText, String ad) {
		try {
			// Initialize Tink/AEAD
			AeadConfig.register();
			// Loading existing keys from file
			String keysetFilename = "keyset.json";
			KeysetHandle keysetHandle = CleartextKeysetHandle.read(JsonKeysetReader.withFile(new File(keysetFilename)));
			// Obtaining and using primitive AEAD
			Aead aead = keysetHandle.getPrimitive(Aead.class);

			// Encrypt
			byte[] ciphertext = aead.encrypt(plainText.getBytes(), ad.getBytes());
			System.out.println("Encode Plaintext (String) into AEAD Cipher (byte[]): " + ciphertext);
			return ciphertext;
		} catch (GeneralSecurityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("util.EncryptString.encryptGoogleTinkAEAD EXCEPTION: Returning NULL");
			return null;
		}
	}

	public String decryptGoogleTinkAEAD(byte[] cipher, String ad) {
		try {
			// Initialize Tink/AEAD
			AeadConfig.register();
			// Loading existing keys from file
			String keysetFilename = "keyset.json";
			KeysetHandle keysetHandle = CleartextKeysetHandle.read(JsonKeysetReader.withFile(new File(keysetFilename)));
			// Obtaining and using primitive AEAD
			Aead aead = keysetHandle.getPrimitive(Aead.class);

			// Decrypt
			String decrypted = new String(aead.decrypt(cipher, ad.getBytes()));
			System.out.println("Decode AEAD Cipher (byte[]) into Plaintext (String): " + decrypted);
			return decrypted;
		} catch (GeneralSecurityException | IOException e) {
			e.printStackTrace();
			System.out.println("EXCEPTION at util.EncryptString.decryptGoogleTinkAEAD: Returning null(string)");
			return "null";
		}
	}

	// Executable
	public static void main(String args[]) {
		// Get Input
		GetRuntimeInput util = new GetRuntimeInput("Input String:");
		String plainText = util.input;

		EncryptString util1 = new EncryptString();
		// Refreshes the encryption keys in keyset.json.
		// WARNING: information encrypted with OLD key cannot be decrypted with new key
		//util1.newCleartextAEADKeyset();
		
		EncodeHexString s = new EncodeHexString();
		
		
		
		// encrypt
		byte[] cipher = util1.encryptGoogleTinkAEAD(plainText, "OMGiloveyou");
		String hexstring = s.byteArrayToHexString(cipher);
		
		// util1.newCleartextAEADKeyset();	// Uncomment to refresh key and fail decrypt
		
		// decrypt
		byte[] bytearray = s.HexStringToByteArray(hexstring);
		String decrypted = util1.decryptGoogleTinkAEAD(bytearray, "OMGiloveyou");
	}
}
