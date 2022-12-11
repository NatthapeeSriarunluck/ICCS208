import java.util.Arrays;
import java.util.Comparator;

public class Zombies {
    public static int countBad(int[] hs) {
        int n = hs.length;
        if (n <=1) {
            return 0;
        }

        int[] left = Arrays.copyOfRange(hs, 0, n / 2);
        int[] right = Arrays.copyOfRange(hs, n/2, n);
        return countBad(left) + countBad(right) + mergeInto(left, right, hs);
    }

    static int mergeInto(int[] a, int[] b, int[] out) {
        int ans = 0;
        int i = 0, j = 0;
        for (int o = 0; o < out.length; o++) {
            if (i >= a.length) {
                out[o] = b[j++];
            } else if (j >= b.length) {
                out[o] = a[i++];
            } else if ((a[i] <= b[j])) {
                out[o] = a[i++];
                ans += b.length-j;
            } else {
                out[o] = b[j++];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] test = {1, 7, 22, 13, 25, 4, 10, 34, 16, 28, 19, 31};
        System.out.println(countBad(test));
        System.out.println(Arrays.toString(test));
    }
}
