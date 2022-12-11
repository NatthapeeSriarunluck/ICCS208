import java.math.BigInteger;

public class Fib {
    public static int firstNDigit(int n) {
        BigInteger first = BigInteger.ONE, second = BigInteger.ONE;
        if (n == 1) {
            return 1;
        }
        BigInteger current;
        int ans = 3;
        for (int i = 1; i <= 40_000; i++) {;
            if (i == 1 || i == 2){
                continue;
            }
            current = first.add(second);

            if (current.toString().length() == n){
                break;
            }
            first = second;
            second = current;
            ans += 1;
            }
        return ans;
        }
}