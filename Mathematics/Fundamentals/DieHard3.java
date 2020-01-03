package br.com.thiagojuliao;

public class Solution {
	
	public static String solve(int a, int b, int c) {
		int max = Math.max(a, b);
		int min = Math.min(a, b);
		int aux = max;
		int tries = 1000;
		
		if (a == c || b == c) return "YES";
		if (a < c && b < c) return "NO";
		
		while (tries > 0) {
			int r = aux % min;
	
			if (c % min == r) return "YES";
			
			aux = max - min + r;
			tries--;
		}
		
		return "NO";
	}
}
