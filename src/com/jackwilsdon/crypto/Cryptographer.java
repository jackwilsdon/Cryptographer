package com.jackwilsdon.crypto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/**
 * Encrypt and decrypt data, using the 'Classic Cipher', or 'Ceasar's Cipher'.
 * @author jackwilsdon
 * @version 1.0
 */
public class Cryptographer {

	private String message;
	private String cipher;
	
	/**
	 * Create a Cryptographer object.
	 * Message will be set to null, and {@link #setMessage(String)} will have to be used.
	 */
	public Cryptographer()
	{
		this(null);
	}
	
	/**
	 * Create a Cryptographer object.
	 * Message is defined in the constructor.
	 * @param message Message to encrypt/decrypt.
	 */
	public Cryptographer(String message)
	{
		if (message != null)
		{
			this.message = message.toUpperCase(Locale.ENGLISH);
		}
		cipher = this.getAlphabet();
	}

	/**
	 * Alphabet generator, used for generating the cipher.
	 * @return The alphabet A-Z in String format.
	 */
	private String getAlphabet()
	{
		String alpha = "";
		for(char character = 'A'; character <= 'Z'; character++){
			alpha += character;
		}
		return alpha;
	}
	
	/**
	 * Counts the number of occurrences of a substring within a string (used for cipher validation).
	 * @return The number of occurrences of a substring within a string.
	 */
	private int countOccurances(String mainString, String subString)
	{
		return ("-"+mainString+"-").split(subString).length-1;
	}

	/**
	 * Allows for changing or setting the text to encrypt or decrypt, without using the constructor.
	 * @param message Message to encrypt/decrypt.
	 */
	public void setMessage(String message)
	{
		this.message = message;
	}
	
	/**
	 * Retrieves the output. If no encryption/decryption has taken place, this will return the starting text.
	 * @return The message set using either {@link #setMessage(String)} or the constructor.
	 */
	public String getMessage()
	{
		return this.message;
	}
	
	/**
	 * Used to define the cyper. Default is the alphabet (invalid). This is converted to the following format; EGABCDFHIJKLMNOPQRSTUVWXYZ.
	 * @param cipher A cipher to use. 
	 */
	public void setCipher(String cipher)
	{
		boolean isAlpha = cipher.matches("^[a-zA-Z]*$");
		if (!isAlpha)
		{
			System.err.println("Invalid cipher! Please ensure you only use A-Z in the cipher.");
			return;
		}
		String rawAlphabet = this.getAlphabet();
		String newAlphabet = rawAlphabet;
		for(int sP = 0; sP < cipher.length(); sP++)
		{
			String cC = Character.toString(cipher.charAt(sP));
			newAlphabet = newAlphabet.replace(cC.toLowerCase(Locale.ENGLISH), "");
			newAlphabet = newAlphabet.replace(cC.toUpperCase(Locale.ENGLISH), "");
		}
		String output = cipher+newAlphabet;
		for (int cA = 1; cA < rawAlphabet.split("").length; cA++)
		{
			int occurrances = this.countOccurances(output, rawAlphabet.split("")[cA]);
			if (occurrances > 1)
			{
				System.err.println("Invalid cipher! Please ensure each character only appears once.");
				return;
			}
		}
		this.cipher = output.toUpperCase(Locale.ENGLISH);
	}
	
	/**
	 * Used to retrieve the cipher used (excluding alphabet continuation).
	 * @return The cipher being used by {@link #encryptMessage(String)} 
	 */
	public String getCipher()
	{
		return this.cipher;
	}

	/**
	 * Encrypts the string set by either the constructor, or through the use of {@link #setMessage(String)}.
	 * @return The encrypted message.
	 */
	public String encryptMessage(){
		this.message = encryptMessage(this.message);
		return this.message;
	}
	
	/**
	 * Encrypts the string passed to it.
	 * @param msg The message to encrypt.
	 * @return The encrypted message.
	 */
	public String encryptMessage(String msg)
	{
		if (msg == null)
		{
			System.err.println("Error: Please define a message!");
			return null;
		}
		
		String message = msg.toUpperCase(Locale.ENGLISH);
		
		ArrayList<String> generatedCipher = new ArrayList<String>(Arrays.asList(this.cipher.split("")));
		ArrayList<String> alphabetList = new ArrayList<String>(Arrays.asList((this.getAlphabet()).split("")));
		generatedCipher.remove(0);
		alphabetList.remove(0);
		
		String output = "";
		
		for (int cChar = 0; cChar < message.length(); cChar++)
		{
			String cC = Character.toString(message.charAt(cChar));
			int indexLoc = alphabetList.indexOf(cC);
			if (indexLoc != -1)
			{
				output += generatedCipher.get(indexLoc);
			} else {
				output += cC;
			}
		}
		
		return output.toUpperCase(Locale.ENGLISH);
	}
	
	/**
	 * Decrypts the string set by either the constructor, or through the use of {@link #setMessage(String)}.
	 * @return The decrypted message.
	 */
	public String decryptMessage()
	{
		this.message = decryptMessage(this.message);
		return this.message;
	}
	
	/**
	 * Decrypts the string passed to it.
	 * @param msg The message to decrypt.
	 * @return The decrypted message.
	 */
	public String decryptMessage(String msg)
	{
		if (msg == null)
		{
			System.err.println("Error: Please define a message!");
			return null;
		}
		
		String message = msg.toUpperCase(Locale.ENGLISH);
		
		ArrayList<String> generatedCipher = new ArrayList<String>(Arrays.asList(this.cipher.split("")));
		ArrayList<String> alphabetList = new ArrayList<String>(Arrays.asList((this.getAlphabet()).split("")));
		generatedCipher.remove(0);
		alphabetList.remove(0);
		
		String output = "";
		
		for (int cChar = 0; cChar < message.length(); cChar++)
		{
			String cC = Character.toString(message.charAt(cChar));
			int indexLoc = generatedCipher.indexOf(cC);
			if (indexLoc != -1)
			{
				output += alphabetList.get(indexLoc);
			} else {
				output += cC;
			}
		}
		
		return output.toUpperCase(Locale.ENGLISH);
	}
}
