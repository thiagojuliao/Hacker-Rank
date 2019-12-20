package ReverseGame;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {

    public static int solve(Deque<Integer> dq, int n, int k){
        List<Integer> ls = new ArrayList<>();
        int e;

        for (int i = 0; i < n; i++){
            if (i % 2 == 0){
                e = dq.pollLast();
            }else {
                e = dq.pollFirst();
            }
            ls.add(e);
            if (e == k) break;
        }
        return ls.indexOf(k);
    }
}
