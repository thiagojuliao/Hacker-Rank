import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        List<Integer> l = new ArrayList<>();

        // Reading Inputs
        int n = sc.nextInt();

        for (int i = 0; i < n; i++){

            int e = sc.nextInt();
            l.add(e);
        }

        // Reading Queries
        int q = sc.nextInt();
        String s;
        int index;
        int e;
        
        for (int i = 0; i < q; i++){

             s = sc.next();

            switch (s){
                case "Delete":
                    index = sc.nextInt();
                    l.remove(index);
                    break;
                case "Insert":
                    index = sc.nextInt();
                    e = sc.nextInt();
                    l.add(index, e);
                    break;
                default:
                    break;
            }
        }

        // Showing Results
        for (int ele : l){
            System.out.print(ele + " ");
        }
    }
}
