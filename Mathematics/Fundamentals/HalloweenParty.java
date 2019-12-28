package br.com.thiagojuliao;

public class Solution {

	public static long halloweenParty(int k) {
		if (k % 2 == 0) {
			return (long) (Math.pow(k, 2) / 4);
		}else {
			return (long) ((Math.pow(k, 2) - 1) / 4);
		}
	}
}
