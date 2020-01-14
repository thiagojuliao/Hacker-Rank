import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
       String input = null;
       int line = 0;

       while(scan.hasNext()){
           input = scan.nextLine();
           line++;
           System.out.println(line + " " + input);
       }
    }
}
