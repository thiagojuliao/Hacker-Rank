import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        BitSet b1 = new BitSet(N);
        BitSet b2 = new BitSet(N);
        
        //System.out.println("B1: " + b1);
        //System.out.println("B2: " + b2);
        //System.out.println();

        int arg1;
        int arg2;

        while (sc.hasNext()){

            String op = sc.next();
            arg1 = sc.nextInt();
            arg2 = sc.nextInt();

            //System.out.println(op + " " + arg1 + " " + arg2);
            switch (op){
                case "AND":
                    if (arg1 == 1){
                        b1.and(b2);
                    }else{
                        b2.and(b1);
                    }
                    break;
                case "OR":
                    if (arg1 == 1){
                        b1.or(b2);
                    }else{
                        b2.or(b1);
                    }
                    break;
                case "XOR":
                    if (arg1 == 1){
                        b1.xor(b2);
                    }else{
                        b2.xor(b1);
                    }
                    break;
                case "SET":
                    if (arg1 == 1){
                        b1.set(arg2);
                    }else{
                        b2.set(arg2);
                    }
                    break;
                default:
                    if (arg1 == 1){
                        b1.flip(arg2);
                    }else{
                        b2.flip(arg2);
                    }
            }
            //System.out.println("B1: " + b1);
            //System.out.println("B2: " + b2);
            System.out.println(b1.cardinality() + " " + b2.cardinality());
        }
    }
}

