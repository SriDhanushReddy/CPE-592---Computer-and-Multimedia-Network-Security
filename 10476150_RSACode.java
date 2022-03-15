/*Tried doing this assignment in python but couldn’t get to convert my text to numeric for some reason to properly perform math on it and get the same output from decryption*/
/*So here I converted text to bytes and encrypted/decrypted to bytes then back to text*/
/*Here I am taking the random parameters for RSA*/
import java.math.BigInteger;

import java.util.Random;

import java.util.Scanner;

import java.io.*;

public class RSA {

private BigInteger p;

private BigInteger q;

private BigInteger N;

private BigInteger phi;

private BigInteger e;

private BigInteger d;

private int bitlength = 1024;

private int blocksize = 256;

//blocksize in byte

private Random r;

public RSA() {

r = new Random();

p = BigInteger.probablePrime(bitlength, r);

q = BigInteger.probablePrime(bitlength, r);

N = p.multiply(q);

phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

e = BigInteger.probablePrime(bitlength/2, r);

while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0 ) {

e.add(BigInteger.ONE);

}

d = e.modInverse(phi);

}

public RSA(BigInteger e, BigInteger d, BigInteger N) {

this.e = e;

this.d = d;

this.N = N;

}

public static void main (String[] args) throws IOException {

RSA rsa = new RSA();

Scanner sc = new Scanner(System.in);

String ts ;

System.out.println("My name:");

ts = sc.nextLine();

System.out.println("Encrypting String: " + ts);

System.out.println("String in Bytes: " + bytesToString(ts.getBytes()));

// encrypt

byte[] encrypted = rsa.encrypt(ts.getBytes());

System.out.println("Encrypted String in Bytes: " + bytesToString(encrypted));

// decrypt

byte[] decrypted = rsa.decrypt(encrypted);

System.out.println("Decrypted String in Bytes: " + bytesToString(decrypted));

System.out.println("Decrypted String: " + new String(decrypted));

}

private static String bytesToString(byte[] encrypted) {

String test = "";

for (byte b : encrypted) {

test += Byte.toString(b);

}

return test;

}

//Encrypt message

public byte[] encrypt(byte[] message) {

return (new BigInteger(message)).modPow(e, N).toByteArray();

}

// Decrypt message

public byte[] decrypt(byte[] message) {

return (new BigInteger(message)).modPow(d, N).toByteArray();

}

}