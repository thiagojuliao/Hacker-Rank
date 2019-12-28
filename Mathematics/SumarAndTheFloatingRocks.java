package br.com.thiagojuliao;

import java.math.BigInteger;

public class Solution {
		
	private static int gcd(int a, int b) {
		BigInteger A = new BigInteger(String.valueOf(a));
		BigInteger B = new BigInteger(String.valueOf(b));
		
		return A.gcd(B).intValue();
	}
	
	public static int solve(int x1, int y1, int x2, int y2) {
		int dX = Math.abs(x2 - x1);
		int dY = Math.abs(y2 - y1);
		
		return gcd(dX, dY) - 1;
	}
}
