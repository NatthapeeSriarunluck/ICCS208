package L2;

public class WindowedSum {
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
    }
}


