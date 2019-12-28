package br.com.thiagojuliao;

public class Solution {
	
	public static int restaurant(int l, int b) {
		int maxIter = Math.min(l, b);
		int maxSize = 1;
		int numberOfSquaresOfMaxSize = l * b;
		
		for (int i = 2; i <= maxIter; i++) {
			int size = i * i;
			int numberOfSquares = (l * b) / size;
			if (l % i == 0 && b % i == 0 && maxSize < size) {
				numberOfSquaresOfMaxSize = numberOfSquares;
			}
		}
		return numberOfSquaresOfMaxSize;
	}
}
