package action;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.CleartextKeysetHandle;
import com.google.crypto.tink.JsonKeysetReader;
import com.google.crypto.tink.JsonKeysetWriter;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.aead.AeadConfig;
import com.google.crypto.tink.aead.AeadFactory;
import com.google.crypto.tink.aead.AeadKeyTemplates;
import com.google.crypto.tink.config.TinkConfig;

import util.GetRuntimeInput;

public class TestGoogleTink {
	public static void main(String[] args) {
		try {
			// Get Input
			GetRuntimeInput util = new GetRuntimeInput();
			String input = util.getConsoleInputBR("Input String:");
			
			// Before using any of Tink APIs we need to initialize them.
			// If we need to use all implementations of ALL PRIMITIVES in Tink, use this:
			TinkConfig.register();
			
			// While, for example, if we only need AEAD primitive, we can use AeadConfig.register() method:
			AeadConfig.register();
			
			// A primitive can have multiple implementations
			
			// each primitive needs a key structure that contains all the key material and parameters
			// Tink provides an object – KeysetHandle – which wraps a keyset with some additional parameters and metadata
			KeysetHandle keysetHandle = KeysetHandle.generateNew(AeadKeyTemplates.AES256_GCM);
			// We can obtain a primitive by calling KeysetHandle's getPrimitive() and passing it a class
			Aead aead = keysetHandle.getPrimitive(Aead.class);
			
			String plaintext = input;
			String associatedData = "Tink";
			// get the primitive and encrypt the desired data
			byte[] ciphertext = aead.encrypt(plaintext.getBytes(), associatedData.getBytes());
			System.out.println(ciphertext);
			
			// we can decrypt the ciphertext using the decrypt() method:
			String decrypted = new String(aead.decrypt(ciphertext, associatedData.getBytes()));
			System.out.println(decrypted);
			
			
			
			// And after generating a key, we might want to persist it:
			String keysetFilename = "keyset.json";
			CleartextKeysetHandle.write(keysetHandle, JsonKeysetWriter.withFile(new File(keysetFilename)));
			
			// we can subsequently load it:
			// String keysetFilename = "keyset.json";
			// KeysetHandle keysetHandle = CleartextKeysetHandle.read(JsonKeysetReader.withFile(new File(keysetFilename)));
			
		} catch (GeneralSecurityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
