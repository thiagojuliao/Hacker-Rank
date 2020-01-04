package br.com.thiagojuliao;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	private static List<Long> fiboList = new ArrayList<>();
	
	private static void buildFiboList(long n) {
		
		while (fiboList.get(fiboList.size() - 1) < n) {
			long fibo00 = fiboList.get(fiboList.size() - 2);
			long fibo01 = fiboList.get(fiboList.size() - 1);
			
			fiboList.add(fibo00 + fibo01);
		}
	}
	
	public static String solve(long n) {
		
		if (fiboList.isEmpty()) {
			fiboList.add(0L);
			fiboList.add(1L);
		}
		
		buildFiboList(n);
//		System.out.println(fiboList);
		
		if (fiboList.contains(n)) return "IsFibo";
		
		return "IsNotFibo";
	}
}
