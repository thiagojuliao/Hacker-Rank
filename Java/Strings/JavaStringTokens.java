import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        
        String[] S = s.split("([\\s,!?._@'])");
        int numberOfTokens = 0;

        for (int i = 0; i < S.length; i ++){

            if (!S[i].isEmpty()){

                numberOfTokens++;
            }
        } 

        System.out.println(numberOfTokens);

        for (String S_ : S){

            if (!S_.isEmpty()){

                System.out.println(S_);
            }
        }

        scan.close();
    }
}
