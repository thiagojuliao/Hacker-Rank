package StrangeGridAgain;

public class Solution {

    public static long strangeGrid(int r, int c){
        long R = r - 1;
        long C = c - 1;

        if (R % 2 == 0){
            return  2 * C + 10 * (R / 2);
        }else{
            return  2 * C + 1 + 10 * (R / 2);
        }
    }
}
