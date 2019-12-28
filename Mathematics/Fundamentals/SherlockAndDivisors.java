package br.com.thiagojuliao;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	
	public static int divisors(int n) {
		Set<Integer> divs = new HashSet<>();
		int maxIter = (int) Math.sqrt(n);
		
		if (n % 2 != 0) return 0;
		
		divs.add(n);
		
		for (int i = 2; i <= maxIter; i++) {
			int aux = n / i;
			if (n % i == 0 && i % 2 == 0) divs.add(i);
			if (n % aux == 0 && aux % 2 == 0) divs.add(aux);
		}
		return divs.size();
	}
}
