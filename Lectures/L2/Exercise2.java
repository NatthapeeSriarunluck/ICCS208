package L2;

import java.math.BigInteger;
import java.util.Arrays;

public class Exercise2 {
    public static void main(String[] args) {
        System.out.println(numTrailingZeros(20));
        windowPosSum(new int[]{1, 2, -3, 4, 5, 4}, 3);
        windowPosSum(new int[]{1, -1, -1, 10, 5, -1}, 2);
    }
    public static int numTrailingZeros(int n){
        BigInteger nFac = BigInteger.ONE;
        for (int i=2;i<=n;i++){
            nFac = nFac.multiply(BigInteger.valueOf((long)i));
        }
        String sFac = nFac.toString();
        char[] aFac = sFac.toCharArray();
        int count = 0;
        for (int i = aFac.length-1;i>=0;i--){
            if (aFac[i] == '0'){
                count += 1;
            } else if (aFac[i] != '0'){
                break;
            }
        }
        return count;
    }
        public static void windowPosSum(int[] a, int n) {
            int num = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i] < 0) {
                    continue;
                }
                if (i + n >= a.length) {
                    for (int j = i; j < a.length; j++) {
                        num += a[j];
                    }
                } else {
                    for (int k = i; k <= i + n; k++) {
                        num += a[k];
                    }
                }
                a[i] = num;
                num = 0;
            }
            System.out.println(Arrays.toString(a));
        }
}


