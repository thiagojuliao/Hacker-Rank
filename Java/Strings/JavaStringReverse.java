import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();

        int j = A.length() - 1;
        boolean isAPalindrome = true;

        for (int i = 0; i < A.length(); i++){

             if (A.charAt(i) != A.charAt(j - i)){

                isAPalindrome = false;
            }
        }
           
        System.out.print(isAPalindrome?"Yes":"No");
    }
}
