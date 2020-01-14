import java.util.*;
import java.text.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();
        
        NumberFormat lp;  //Local Payment

        lp = NumberFormat.getCurrencyInstance(Locale.US);
        String us = lp.format(payment);

        lp = NumberFormat.getCurrencyInstance(new Locale("en", "in"));
        String india = lp.format(payment);

        lp = NumberFormat.getCurrencyInstance(Locale.CHINA);
        String china = lp.format(payment);

        lp = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        String france = lp.format(payment); 
        
        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
}
