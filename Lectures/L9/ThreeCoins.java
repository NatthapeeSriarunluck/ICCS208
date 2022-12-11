package L9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeCoins {

    /**
     * THM: x cents is payable if x >= 20.
     * .
     * Predicate: P(i) = i cents is payable
     * .
     * Base Case(s):
     * P(20): 5,5,5,5
     * P(21): 11,5,5
     * P(22): 11,11
     * P(23): 11,12
     * P(24): 12,12
     * .
     * Proof:
     * Assume that j baht is payable. j = 20,21,22,23,24 ... k
     * WTS: k+1 is payable
     * We could pay a 5 baht coupon: k+1-5 = k-4
     * Then we have k-4 baht to pay with the coupons.
     * By IH, since k-4 is in the set of j {20,21,22,23,24 ... k}, k-4 is payable. Therefore k+1 is payable
     *
     */
    static List<Integer> list = new ArrayList<>();

    public static List<Integer> change(int n) {
        List<Integer> ReturnList = new ArrayList<>();

        switch (n) {
            case 20:
                List<Integer> coupon20 = Arrays.asList(5, 5, 5, 5);
                list.addAll(coupon20);
                ReturnList.addAll(list);
                list.clear();
                return ReturnList;
            case 21:
                List<Integer> coupon21 = Arrays.asList(5, 5, 11);
                list.addAll(coupon21);
                ReturnList.addAll(list);
                list.clear();
                return ReturnList;
            case 22:
                List<Integer> coupon22 = Arrays.asList(11, 11);
                list.addAll(coupon22);
                ReturnList.addAll(list);
                list.clear();
                return ReturnList;
            case 23:
                List<Integer> coupon23 = Arrays.asList(11, 12);
                list.addAll(coupon23);
                ReturnList.addAll(list);
                list.clear();
                return ReturnList;
            case 24:
                List<Integer> coupon24 = Arrays.asList(12, 12);
                list.addAll(coupon24);
                ReturnList.addAll(list);
                list.clear();
                return ReturnList;
        }
        list.add(5);
        return change(n - 5);
    }

    public static void main(String[] args) {

    }
}
