package L14;

import java.util.Objects;

public class Lecture14 {
    public static int linearSearch(String[] array, String targetKey) {
        for (String s : array) {
            if (Objects.equals(s, targetKey)) {
                return 1;
            }
        }
        return 0;
    }

    public static int binarySearch(String[] array, String targetKey) {
        return binarySearchHelper(array, 0, array.length, targetKey);
    }

    public static int binarySearchHelper(String[] array, int lo, int hi, String targetKey) {
        if (lo >= hi) {
            return -1;
        } else {
            int m = (lo + hi) / 2;
            if (array[m].compareTo(targetKey) == 0) {
                return m;
            } else if (targetKey.compareTo(array[m]) < 0) {
                return binarySearchHelper(array, lo, m , targetKey);
            } else {
                return binarySearchHelper(array, m + 1, hi, targetKey);
            }
        }
    }

    public static void main(String[] args) {
        String[] test = {"ab", "bex","bex", " bex","cc", "def"};
        System.out.println(binarySearch(test, "bex"));
    }
}

/*
int primSum(int[] xs) {
     if (xs.length == 1) return xs[0];
     if (xs.length == 2) return xs[0] + xs[1];
     else {
         int[] ys = Arrays.copyOfRange(xs, 1, xs.length);   -> O(n)
         return xs[0]+xs[1]+primSum(ys); -> T(n-1)
     }
}

T(n-1) + O(n) solves to O(n^2)

int whazIt(int[] ys) {
    if (ys.length == 0) return 0;
    if (ys.length == 1) return ys[0];
    int n = ys.length;
    int m = n/2;
    for (int i=0;i<n;i++) {  -> O(n)
        int theSum = 0;
        for (int j=0;j<=i;j++) { theSum += ys[j]; }  -> O(n)
        ys[i] = theSum;
    }
    int a = whazIt(Arrays.copyOfRange(ys, 0, m));  -> T(n/2)
    int b = whazIt(Arrays.copyOfRange(ys, m, ys.length)); -> T(n/2)
    return a + b;
}

T(n/2) + T(n/2) + O(n) = 2T(n/2) + O(n) solves to O(n)
 */
