import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();

        System.out.println(A.length() + B.length());

        if (A.compareTo(B) > 0){

            System.out.println("Yes");
        }else {

            System.out.println("No");
        }
        
      String A_ = A.toUpperCase().substring(0, 1) + A.substring(1);
      String B_ = B.toUpperCase().substring(0, 1) + B.substring(1);
      System.out.print(A_ + " " + B_);
    }
}
