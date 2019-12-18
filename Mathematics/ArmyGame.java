package br.com.thiagojuliao;

public class Solution {
	
	public static int gameWithCells(int n, int m) {
		
		if (n == 0 || m == 0) {
			return 0;
		}else if (n == 1 || m == 1) {
			return (n + m)/2;
		}else {
			return 1 + gameWithCells(n - 2, 2) + gameWithCells(n, m - 2);
		}
	}
}
