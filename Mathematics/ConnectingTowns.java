package br.com.thiagojuliao;

public class Solution {
	
	public static int connectingTowns(int n, int[] routes) {
		int numberOfRoutes = 1;
		
		for (int route : routes) {
			numberOfRoutes *= route;
			numberOfRoutes = numberOfRoutes % 1234567;
		}
		return numberOfRoutes;
	}
}
