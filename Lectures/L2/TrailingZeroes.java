package L2;
import java.math.BigInteger;

public class TrailingZeroes{
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
    public static void main(String[] args) {
        System.out.println(numTrailingZeros(20));
    }
}
