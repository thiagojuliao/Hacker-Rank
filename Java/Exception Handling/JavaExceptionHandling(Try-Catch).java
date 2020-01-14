import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        try{
            int x = sc.nextInt();
            int y = sc.nextInt();

            try{
                System.out.println(x/y);
            }catch (ArithmeticException ae){
                System.out.println("java.lang.ArithmeticException: / by zero");
            System.exit(0);
            }
        }catch (InputMismatchException ime){
            System.out.println("java.util.InputMismatchException");
            System.exit(0);
        }
    }
}

