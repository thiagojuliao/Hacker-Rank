package br.com.thiagojuliao;

import java.math.BigInteger;

public class Solution {
	
	public static String solve(long a, long b, long x, long y) {
		
		BigInteger A = new BigInteger(String.valueOf(a));
		BigInteger B = new BigInteger(String.valueOf(b));
		BigInteger X = new BigInteger(String.valueOf(x));
		BigInteger Y = new BigInteger(String.valueOf(y));
		
		String result = A.gcd(B).compareTo(X.gcd(Y))  == 0 ? "YES" : "NO";
		return result;
	}
}
