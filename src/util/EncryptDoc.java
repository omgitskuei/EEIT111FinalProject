package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.security.GeneralSecurityException;

import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.StreamingAead;
import com.google.crypto.tink.streamingaead.StreamingAeadKeyTemplates;

public class EncryptDoc {
	// Local fields
	String filePath;
	String associatedData;

	// Constructors
	public EncryptDoc() {
		System.out.println("BEGIN: util.EncryptDoc()");
	}

	public EncryptDoc(String filePath) {
		System.out.println("BEGIN: util.EncryptDoc(String filePath)");
		this.filePath = filePath;
	}

	public EncryptDoc(String filePath, String associatedData) {
		System.out.println("BEGIN: util.EncryptDoc(String filePath, String associatedData");
		this.filePath = filePath;
		this.associatedData = associatedData;
	}

	// Methods
	public void encryptTxtAtLocalRoot(String fileName, String associatedData) {
		try {
			int CHUNK_SIZE = 8;
			String cipherTextFileRoot = System.getProperty("user.dir") + "\\"+fileName+".txt"; // File path filePath
																									// here

			// when the data to be encrypted is too large to be processed in a single step,
			// we can use the streaming AEAD primitive:
			KeysetHandle streamingAEADkeysetHandle = KeysetHandle
					.generateNew(StreamingAeadKeyTemplates.AES128_CTR_HMAC_SHA256_4KB);

			StreamingAead streamingAead = streamingAEADkeysetHandle.getPrimitive(StreamingAead.class);

			@SuppressWarnings("resource")
			FileChannel cipherTextDestination = new FileOutputStream(cipherTextFileRoot).getChannel();
			WritableByteChannel encryptingChannel = streamingAead.newEncryptingChannel(cipherTextDestination,
					associatedData.getBytes());

			ByteBuffer buffer = ByteBuffer.allocate(CHUNK_SIZE);
			InputStream in = new FileInputStream("plainTextFile");

			while (in.available() > 0) {
				in.read(buffer.array());
				encryptingChannel.write(buffer);
			}

			in.close();
			encryptingChannel.close();
			cipherTextDestination.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void encryptTxt(String filePath, String associatedData) {
		try {
			int CHUNK_SIZE = 8;
			String cipherTextFileRoot = filePath; // File path filePath
																									// here
			// when the data to be encrypted is too large to be processed in a single step,
			// we can use the streaming AEAD primitive:
			KeysetHandle streamingAEADkeysetHandle = KeysetHandle
					.generateNew(StreamingAeadKeyTemplates.AES128_CTR_HMAC_SHA256_4KB);

			StreamingAead streamingAead = streamingAEADkeysetHandle.getPrimitive(StreamingAead.class);

			@SuppressWarnings("resource")
			FileChannel cipherTextDestination = new FileOutputStream(cipherTextFileRoot).getChannel();
			WritableByteChannel encryptingChannel = streamingAead.newEncryptingChannel(cipherTextDestination,
					associatedData.getBytes());

			ByteBuffer buffer = ByteBuffer.allocate(CHUNK_SIZE);
			InputStream in = new FileInputStream("plainTextFile");

			while (in.available() > 0) {
				in.read(buffer.array());
				encryptingChannel.write(buffer);
			}

			in.close();
			encryptingChannel.close();
			cipherTextDestination.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Not sure if this works ************************************************************************************************
	public void decryptTxt(String filePath) {
		try {
			int CHUNK_SIZE = 8;
			String cipherTextFileRoot = filePath; // File path filePath here
			// when the data to be encrypted is too large to be processed in a single step,
			// we can use the streaming AEAD primitive:
			KeysetHandle streamingAEADkeysetHandle = KeysetHandle
					.generateNew(StreamingAeadKeyTemplates.AES128_CTR_HMAC_SHA256_4KB);

			StreamingAead streamingAead = streamingAEADkeysetHandle.getPrimitive(StreamingAead.class);

			@SuppressWarnings("resource")
			FileChannel cipherTextDestination = new FileOutputStream(cipherTextFileRoot).getChannel();
			ReadableByteChannel encryptingChannel = streamingAead.newDecryptingChannel(cipherTextDestination,
					associatedData.getBytes());

			ByteBuffer buffer = ByteBuffer.allocate(CHUNK_SIZE);
			InputStream in = new FileInputStream("plainTextFile");

			while (in.available() > 0) {
				in.read(buffer.array());
				encryptingChannel.read(buffer);
			}

			in.close();
			encryptingChannel.close();
			cipherTextDestination.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Executable
	public static void main(String[] args) {

	}

}
