package br.com.thiagojuliao;

public class Solution {
	
	private static int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 
			37, 41, 43, 47};
	
	public static int primeCount(long n) {
		long result = 1;
		int count = 0;
		
		for (int prime : primes) {
			if (result * prime <= n) {
				result *= prime;
				count++;
			}
		}
		return count;
	}
}
