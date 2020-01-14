import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> arrs = new ArrayList<>();

        // Inputs
        int n = sc.nextInt();

        for (int i = 0; i < n; i++){

            int d = sc.nextInt();
            ArrayList<Integer> inputs = new ArrayList<>();
            inputs.add(0, d);

            for(int j = 1; j <= d; j++){
            
                int input = sc.nextInt();
                inputs.add(j, input);
            }
            arrs.add(i, inputs);
        }

        // Queries
        int q = sc.nextInt();

        for (int i = 0; i < q; i++){

            int line = sc.nextInt();
            int index = sc.nextInt();

            if (index > arrs.get(line - 1).get(0)){

                System.out.println("ERROR!");
            }else{

                System.out.println(arrs.get(line - 1).get(index));
            }
        }
    }
}
