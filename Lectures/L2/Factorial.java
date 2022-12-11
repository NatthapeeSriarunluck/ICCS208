package L2;

import java.math.BigInteger;

public class Factorial{
    public static void main(String[] args) {
        int n = 150;
        BigInteger nFac = BigInteger.ONE;
        for (int i=2;i<=n;i++){
            nFac = nFac.multiply(BigInteger.valueOf((long)i));
        } 
    System.out.println(nFac);    
        }
    }