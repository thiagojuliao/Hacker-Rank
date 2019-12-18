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
	
	// Seja Tn = n^2 - (n-1)^2 e Sn = T1 + T2 + ... + Tn para todo n e N tal que n >= 1
	// Observe que:
	// Tn+1 - Tn = [(n+1)^2 - n^2] - [n^2 - (n-1)^2] = [n^2 + 2n + 1 - n^2] - [n^2 - n^2 - 2n -1] =
	// = [2n + 1] + [1 - 2n] = 1 + 1 = 2
	// Portanto, Tn+1 = Tn + 2 => temos uma P.A de razão 2 onde T1 = 1.
	// A soma (Sn) dos n termos dessa P.A pode ser calculada em função de Tn da seguinte maneira:
	// Tn = T1 + 2 * (n - 1)
	// Tn = T2 + 2 * (n - 2)
	// ...
	// Tn = Tn-1 + 2 * 1
	// Tn = Tn + 2 * 0
	// Somando-se todas as expressões acima temos que:
	// n * Tn = (T1 + T2 + ... + Tn) + 2 * (1 + 2 + ... + n-1)
	// Note que o primeiro termo após a igualdade é nada mais do que nossa soma Sn =>
	// n * Tn = Sn + 2 * (1 + 2 + ... + n-1)
	// Somemos 2 * n em ambos os lados:
	// n * Tn + 2 * n = Sn + 2 * (1 + 2 + ... + n-1 + n)
	// Note que esta soma 1 + 2 + ... + n-1 + n nada mais é do que a soma dos n termos de uma P.A de razão 1 onde seu valor
	// é dado por : n * (n+1) / 2
	// Portanto:
	// n * Tn + 2 * n = Sn + 2 * (n * (n + 1) / 2) => n * Tn + 2 * n = Sn + n * (n + 1) =>
	// Sn = n * Tn + 2 * n - n * (n + 1) => Sn = n * (Tn + 2 - n - 1) => 
	// Sn = n * (Tn - n + 1), onde n é o n-ésimo termo de S e Tn = 1 + 2 * (n - 1) [c.q.d]
}
