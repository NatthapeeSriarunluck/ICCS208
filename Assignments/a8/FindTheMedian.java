import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindTheMedian {

    public static int findMedian(List<Integer> arr) {
        Collections.sort(arr);
        return arr.get((arr.size()-1)/2);

    }
}