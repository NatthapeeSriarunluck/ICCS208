package L10;

import java.util.Iterator;

public class L10 {
    public static void main(String[] args) {
        ArraySet<Integer> ms = new ArraySet<>();
        ms.add(7);
        ms.add(1);
        ms.add(17);

        Iterator<Integer> it = ms.iterator();
        while (it.hasNext()) {
            int num = it.next();
            System.out.println(num);
        }
    }
}
