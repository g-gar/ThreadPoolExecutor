package com.ggar.dev.test;

import java.math.BigInteger;

public class RecursionTest {
	 
	private static void recurse() {recurse(0);}
    private static void recurse(int i) {
        try {
        	recurse(i+1);
		} catch (java.lang.StackOverflowError e) {
		    System.out.println("Recursion depth on this system is " + i + ".");
		}
    }
    
    private static BigInteger fibonacci(Integer n) {
    	return fibonacci(n, BigInteger.ONE);
    }
    private static BigInteger fibonacci(Integer n, BigInteger acc) {
    	return n <= 1
    			? acc
    			: fibonacci(n-1, acc.add(BigInteger.valueOf(n)));
    }
 
    public static void main(String[] args) {
        recurse();
        int n = 2;
        System.out.println(n + ": " + fibonacci(n));
    }
}
