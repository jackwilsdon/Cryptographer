Cryptographer
=============
Encrypt and decrypt using "Caesar's Cipher".

Description
-----------
**Cryptographer** allows you to encrypt and decrypt using ["Caesar's Cipher"](http://en.wikipedia.org/wiki/Caesar_cipher "Wikipedia").

Usage
-----
 * Download the source, or use the pre-compiled Cryptographer.jar inside `bin`.
 * Include it within your build path, or import Cryptographer.java into your project (google is your friend).
 * Have fun!

[JavaDoc](http://jackwilsdon.github.com/Cryptographer/javadoc/ "Cryptographer JavaDoc")
-------
Use the javadoc for a list of methods, and information about each.

Example
-------

	/*
	* Creation and configuration
	*/
	Cryptographer exampleCryptographer = new Cryptographer("Hello, world!"); // Setting message via constructor
	exampleCryptographer.setCipher("HOWDY"); // Set cipher for encryption

	/*
	* Encryption
	*/
	System.out.println(exampleCryptographer.getMessage()+", encryped with the cipher "+exampleCryptographer.getCipher()+" is "+exampleCryptographer.encryptMessage());

	/*
	* Decryption
	*/
	System.out.println(exampleCryptographer.getMessage()+", decrypted with the cipher "+exampleCryptographer.getCipher()+" is "+exampleCryptographer.decryptMessage());

License
-------
[![Creative Commons License][2]][1]  
This work is licensed under a [Creative Commons Attribution-NonCommercial-ShareAlike 3.0 Unported License](http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en).  
You are allowed to modify and distribute this freely, as long as it is released under the same Creative Commons License, and gives credit to it's original author (me).  
All other licenses can be found inside **LICENSE.md**.
	
   [1]: http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en
   [2]: http://i.creativecommons.org/l/by-nc-sa/3.0/88x31.png