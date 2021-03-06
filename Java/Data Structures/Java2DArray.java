import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[6][6];
        int topSum;
        int midSum;
        int botSum;
        int sum;

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int max = 0;
        boolean first = true;

        for (int i = 0; i < 4; i++){
            
            for (int j = 0; j < 4; j++){
                
                topSum = arr[i][j] + arr[i][j+1] + arr[i][j+2];
                midSum = arr[i+1][j+1];
                botSum = arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
                sum = topSum + midSum + botSum;

                if (first){
                    max = sum;
                    first = false;
                }else{
                    max = Math.max(max, sum);
                }
            }
        }
        scanner.close();
        System.out.print(max);
    }
}
