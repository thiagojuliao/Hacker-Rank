package br.com.thiagojuliao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
	
    public static List<Integer> solve(int[] a) {
        Set<Integer> sums = new HashSet<>();
        
        int sum = 0;
        int aMax = Integer.MIN_VALUE;
        
        for (int value : a) {
        	sum += value;
        	sums.add(sum);
        	
        	aMax = Math.max(value, aMax);
        }
        
        final int Sum = sum;
        final int aMAX = aMax;
        final Set<Integer> Sums = sums;
        
        List<Integer> validFactors = sums.stream().filter(factor -> (Sum - factor) % factor == 0 && factor >= aMAX)
        		.collect(Collectors.toList());
        
        List<Integer> busSizes = validFactors.stream()
        		.filter
        		(
        			factor -> {
        				if (factor >= Sum / 2) return true;
        				
        				for (int k = 2; k <= Sum / factor; k++) {
        					if (!Sums.contains(k * factor)) return false;
        				}
        				return true;
        			}
        		).sorted().collect(Collectors.toList());
        
        return busSizes;
    }
}
