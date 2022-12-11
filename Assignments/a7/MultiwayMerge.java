import java.util.*;

public class MultiwayMerge {

    public static LinkedList<Integer> mergeAll(LinkedList<Integer>[] lists) {
        LinkedList<Integer> ans = new LinkedList<>();
        PriorityQueue<LinkedList<Integer>> queue = new PriorityQueue<>(lists.length, new Comparator<LinkedList<Integer>>() {
            @Override
            public int compare(LinkedList<Integer> o1, LinkedList<Integer> o2) {
                if (o2.size() == 0) return -1;
                if (o1.size() == 0) return 1;
                return o1.get(0).compareTo(o2.get(0));
            }
        });
        for (LinkedList<Integer> list : lists) queue.offer(list);
        while (!queue.isEmpty()) {
            LinkedList<Integer> polled = queue.poll();
            if (!polled.isEmpty()) {
                queue.offer(polled);
                ans.add(polled.getFirst());
                polled.removeFirst();
            }
        }
        return ans;
    }
}
