package DiwaliLights;

import java.math.BigInteger;

public class Solution {

    public static long lights(int n){
        BigInteger div = new BigInteger("100000");
        BigInteger total = (new BigInteger("2").pow(n)).add(BigInteger.ONE.negate());
        return total.mod(div).longValue();
    }
}
