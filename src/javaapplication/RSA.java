/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication;
 

import java.math.BigInteger;
import java.util.Random;
import java.io.*;
import java.math.BigInteger;

public class RSA {
/**
 *
 * @author AGHEZZAF Mohamed
 */
	public static BigInteger p;
	public static BigInteger q;
	private BigInteger N;
	private BigInteger phi;
	private BigInteger e;
	private BigInteger d;
	private int bitlength = 62;
	private int blocksize = 256;

	private Random r;

	public RSA() {

	//	r = new Random();
	//	p = BigInteger.probablePrime(bitlength, r);
      	//	q = BigInteger.probablePrime(bitlength, r);
                
                long x=3053880317135553533L;
                long y=3916702577991933803L;
                long z=1678030687;
                 p = BigInteger.valueOf(x);
	 	 q = BigInteger.valueOf(y);
	 	 e=	BigInteger.valueOf(z);
		N = p.multiply(q);
		phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
	//	e = BigInteger.probablePrime(bitlength / 2, r);


		while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0) {
	
			e.add(BigInteger.ONE);		//e=e+1
		}

		d = e.modInverse(phi);
	
	

}
	public RSA(BigInteger e, BigInteger d, BigInteger N) {

		this.e = e;
		this.d = d;
		this.N = N;

	}

	public static void main(String[] args) throws IOException {

		RSA rsa = new RSA();
		DataInputStream in = new DataInputStream(System.in);
		String teststring;
		System.out.println("Enter the plain text:");
		teststring = in.readLine(); 
		System.out.println("Encrypting String: " + teststring);
		System.out.println("String in Bytes: " + bytesToString(teststring.getBytes()));

		// encrypt

		byte[] encrypted = rsa.encryptRSA(teststring.getBytes());
		System.out.println("Encrypted String in Bytes: " + bytesToString(encrypted));
		//  decrypt
		byte[] decrypted = rsa.decryptRSA(encrypted);
		System.out.println("Decrypted String in Bytes: " + bytesToString(decrypted));
		System.out.println("Decrypted String: " + new String(decrypted));

	}

public static String bytesToString(byte[] encrypted) {

		String test = "";
		for (byte b : encrypted) {
			test += Byte.toString(b);
		}

		return test;
	}

	// Encrypt message

	public byte[] encryptRSA(byte[] message) {
		
		return (new BigInteger(message)).modPow(e, N).toByteArray();
	}

	// Decrypt message

	public byte[] decryptRSA(byte[] message) {
		return (new BigInteger(message)).modPow(d, N).toByteArray();

	}
}