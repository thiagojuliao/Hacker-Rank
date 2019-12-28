package br.com.thiagojuliao;

import java.math.BigInteger;

public class Solution {
	
	public static long solve(int n, int m, int[][] operations) {
		BigInteger sum = BigInteger.ZERO;
		
		for (int i = 0; i < m; i++) {
			BigInteger big00 = new BigInteger(String.valueOf(operations[i][0])).negate();
			BigInteger big01 = new BigInteger(String.valueOf(operations[i][1]));
			BigInteger big02 = new BigInteger(String.valueOf(operations[i][2]));
			
			BigInteger step00 = big01.add(big00).add(BigInteger.ONE);
			BigInteger step01 = step00.multiply(big02);
			sum = sum.add(step01);
		}
		return sum.divide(new BigInteger(String.valueOf(n))).longValue();
	}
}
