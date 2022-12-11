import java.util.Arrays;

public class Happy {
    public static long sumOfDigitsSquared(long n) {
        long sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        return sum;
    }

    public static boolean isHappy(long n) {
        long ans = n;
        while (ans != 1 && ans != 4) {
            ans = sumOfDigitsSquared(ans);
        }
        return ans == 1;
    }

    public static long[] firstK(int k) {
        long[] ans = new long[k];
        int index = 0;
        long candidate = 1;
        while (index < k) {
            if (isHappy(candidate)) {
                ans[index] = candidate;
                index += 1;
            }
            candidate += 1;
        }
        return ans;
    }
}

