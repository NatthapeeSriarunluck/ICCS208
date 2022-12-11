import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KFactorization {
    public static List<Integer> kFactorization(int n, List<Integer> A) {
        Collections.sort(A);
        List<Integer> ans = new ArrayList<>();
        minFactor(n, A, A.size() - 1, ans);
        if(ans.size() == 0){
            ans.add(-1);
        }else{
            ans.add(1);
            Collections.sort(ans);
        }
        return ans;
    }

    private static void minFactor(int number, List<Integer> factors, int i,
                                  List<Integer> result){
        if(number == 1) {
            return;
        }
        if(i < 0) {
            result.clear();
            return;
        }
        if(number % factors.get(i) == 0){
            result.add(number);
            minFactor(number/factors.get(i), factors, i, result);
        }else {
            minFactor(number, factors, i - 1, result);
        }
    }
}
