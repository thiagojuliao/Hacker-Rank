package br.com.thiagojuliao;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
	
	private static Deque<Long> stack = new LinkedList<>();
	
	private static void putOnStack(long n) {
		stack.add(n * 10);
		stack.add(n * 10 + 9);
	}
	
	public static String solve(int n) {
		stack.clear();
		stack.add((long) 9);
		
		while (!stack.isEmpty()) {
			long ele = stack.pollFirst();
			
			if (ele % n == 0) return String.valueOf(ele);
			putOnStack(ele);
		}
		
		return "9";
	}
}
