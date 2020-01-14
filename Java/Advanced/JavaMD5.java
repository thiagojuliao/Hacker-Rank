import java.io.*;
import java.util.*;
import java.security.*;
import java.math.*;

public class Solution {

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        MessageDigest m = MessageDigest.getInstance("MD5");
        m.update(s.getBytes(), 0, s.length());
        System.out.println(new BigInteger(1, m.digest()).toString(16));
    }
}

