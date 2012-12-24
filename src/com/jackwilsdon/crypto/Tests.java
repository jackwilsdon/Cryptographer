package com.jackwilsdon.crypto;

import java.util.Locale;

public class Tests {
	public static void main(String[] args)
	{
		String[] inputData = {"Hello, world!", "How's it going?", "Lorem Ipsum", "{Symbols are not converted!}"}; // Test Cases
		
		Cryptographer crypto = new Cryptographer(); // Create Cryptographer
		crypto.setCipher("JACKWILSDON"); // Set Cipher
		
		// Loop through test cases, encrypting and decrypting them
		for (int cD = 0; cD < inputData.length; cD++)
		{
			String input = inputData[cD].toUpperCase(Locale.ENGLISH);
			crypto.setMessage(input);
			String encrypted = crypto.encryptMessage();
			String decrypted = crypto.decryptMessage();
			System.out.println("Encrypt: in["+input+"] out["+encrypted+"]\nDecrypt: in["+encrypted+"] out["+decrypted+"]\n");
		}
		
	}
}
