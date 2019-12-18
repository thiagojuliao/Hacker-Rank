package br.com.thiagojuliao;

import java.math.BigInteger;

public class Solution {
	
	public static long getT(long n) {
		return 1 + 2 * (n - 1);
	}
	
	public static int summingSeries (long n) {

		BigInteger N = new BigInteger(String.valueOf(n));
		BigInteger T = new BigInteger(String.valueOf(getT(n)));
		BigInteger div = new BigInteger(String.valueOf(1000000007));
		
		BigInteger step0 = T.add(N.negate()).add(BigInteger.ONE);
		BigInteger step1 = N.multiply(step0);
		BigInteger bigSum = step1.mod(div);
		
		return bigSum.intValue();
	}
}
