package action;

import java.io.IOException;
import java.util.ArrayList;

import com.google.crypto.tink.Aead;

import util.EncodeHexString;
import util.EncryptString;
import util.GetRuntimeInput;
import util.ReadWriteTxt;

public class TestUtil {

	public static void main(String[] args) {
		try {
			GetRuntimeInput util0 = new GetRuntimeInput();
			String input = util0.getConsoleInputBR("Input any text:");

			// initialize encrypt/decrypt
			EncryptString util1 = new EncryptString();
			Aead aead = util1.newCleartextAEADKeyset();
			// encrypt
			byte[] cipherPwd = util1.encryptGoogleTinkAEAD(input, "OMGiloveyou");
			EncodeHexString hexConvert = new EncodeHexString();
			input = hexConvert.byteArrayToHexString(cipherPwd);

			// initialize write/read AdminLog.txt
			ReadWriteTxt logEditor = new ReadWriteTxt(System.getProperty("user.dir") + "\\AdminLog.txt", false);
			// write
			logEditor.writeFile(input);
			// read
			ArrayList<String> s = logEditor.readFile(System.getProperty("user.dir") + "\\AdminLog.txt");
			System.out.println(s);
			
			// decrypt
			cipherPwd = hexConvert.HexStringToByteArray(s.get(0));
			String pwd = util1.decryptGoogleTinkAEAD(cipherPwd, "OMGiloveyou");
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}
}
