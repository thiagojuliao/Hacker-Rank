package br.com.thiagojuliao;

//import java.util.Arrays;

public class Solution {
	
	private static double distance(int[] P1, int[] P2) {
		double X = Math.pow(P1[0] - P2[0], 2);
		double Y = Math.pow(P1[1] - P2[1], 2);
		return Math.sqrt(X + Y);
	}
	
	private static double[] getDistances(int[][] X, int[][] Y) {
		double[] distances = new double[6];
		
		distances[0] = distance(X[0], X[1]);
		distances[1] = distance(Y[0], Y[1]);
		distances[2] = distance(X[0], Y[1]);
		distances[3] = distance(X[1], Y[0]);
		distances[4] = distance(X[0], Y[0]);
		distances[5] = distance(X[1], Y[1]);
		
		return distances;
	}
	
	public static double solve(int[][] coordinates) {
		int minX = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE;
		int minY = Integer.MAX_VALUE;
		int maxY = Integer.MIN_VALUE;
		double maxDistance = 0;
		
		for (int i = 0; i < coordinates.length; i++) {
			minX = Math.min(minX, coordinates[i][0]);
			maxX = Math.max(maxX, coordinates[i][0]);
			minY = Math.min(minY, coordinates[i][1]);
			maxY = Math.max(maxY, coordinates[i][1]);
		}
		
		int [][] X = {{minX, 0}, {maxX, 0}};
		int [][] Y = {{0, minY}, {0, maxY}};
		
//		System.out.printf("• X<min, max> : <%d, %d>%n", minX, maxX);
//		System.out.printf("• Y<min, max> : <%d, %d>%n", minY, maxY);
		
		double[] distances = getDistances(X, Y);
		
		for (double distance : distances) {
			maxDistance = Math.max(maxDistance, distance);
		}
		
//		System.out.println(Arrays.toString(distances));
		return maxDistance;
	}
}
