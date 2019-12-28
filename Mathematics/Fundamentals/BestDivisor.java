package br.com.thiagojuliao;

public class Solution {
	
	public static char[] buildCharArray(String s) {
		char[] charset = s.toCharArray();
		return charset;
	}
	
	public static int bestDivisor(int n) {
		int max = 1;
		int num = 1;
		
		for (int i = 2; i <= n; i++) {
			if (n % i == 0) {
				String s = String.valueOf(i);
				char[] charset = buildCharArray(s);
				int sumOfS = 0;
				for (char c : charset) {
					sumOfS += Integer.valueOf(String.valueOf(c));
				}
				if (max < sumOfS) {
					max = sumOfS;
					num = i;
				}
			}
		}
		return num;
	}
}
