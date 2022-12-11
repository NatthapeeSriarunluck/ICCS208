import java.util.Arrays;

public class Subsel {
    public static int[] takeEvery(int[] a, int stride){
        return takeEvery(a, stride, 0);
    }
    public static int[] takeEvery(int[] a, int stride, int beginWith) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (beginWith + i * stride < a.length && beginWith + i* stride >=0) {
                count += 1;
            } else {
                break;
            }
        }
        int[] ans = new int[count];
        for (int i = 0; i < a.length; i++) {
            if (beginWith + i * stride >= a.length || beginWith + i * stride<0) {
                break;
            } else {
                ans[i] = a[beginWith + i * stride];
            }
        }
        return ans;
    }
}
