public class Last {
    public static Integer binarySearchLast(int[] a, int k) {
            return binarySearchLastHelper(a, 0, a.length, k);
        }

        public static Integer binarySearchLastHelper(int[] array, int lo, int hi, int targetKey) {
            if (lo >= hi) {
                return null;
            } else {
                int m = (lo + hi) / 2;
                if ((m == array.length - 1 || array[m] < array[m+1]) && targetKey == array[m]) {
                    return m;
                } else if (targetKey < array[m]) {
                    return binarySearchLastHelper(array, lo, m, targetKey);
                } else {
                    return binarySearchLastHelper(array, m + 1, hi, targetKey);
                }
            }
        }
    }

