import java.io.*;
import java.util.*;
import java.security.*;
import java.math.*;

public class Solution {

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(
    s.getBytes());

        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
        String hex = Integer.toHexString(0xff & hash[i]);
        if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        System.out.println(hexString.toString());
    }
}

