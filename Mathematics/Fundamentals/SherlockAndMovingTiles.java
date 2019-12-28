package SherlockAndMovingTiles;

public class Solution {

    public static double solve(int l, int s1, int s2, long q){
        double step1 = (Math.sqrt(q) - l) * Math.sqrt(2);
        double step2 = step1 / (double) (s1 - s2);
        return Math.abs(step2);
    }

    public static double[] movingTiles(int l, int s1, int s2, long[] queries){
        double[] results = new double[queries.length];

        for (int i = 0; i < queries.length; i++){
            results[i] = solve(l, s1, s2, queries[i]);
        }
        return results;
    }
}
