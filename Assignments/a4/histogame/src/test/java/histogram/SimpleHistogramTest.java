package histogram;

import org.junit.Test;

import java.util.Iterator;

import static junit.framework.TestCase.assertEquals;



public class SimpleHistogramTest {

    @Test
    public void testHistogram() {
        Character[] target = {'a', 'b', 'c', 'a'};
        SimpleHistogram<Character> h1 = new SimpleHistogram<Character>(target);
        Histogram<Character> h2 = new SimpleHistogram<>(h1);
        Iterator<Character> iter = h1.iterator();
        int elemCount = 0;
        while (iter.hasNext()) {
            iter.next();
            elemCount++;
        }

        //test functions
        assertEquals(3, elemCount);
        assertEquals(2, h1.getCount('a'));
        assertEquals(1, h1.getCount('b'));
        assertEquals(1, h1.getCount('c'));
        assertEquals(0, h1.getCount('d'));
        h1.setCount('a', 1);
        h1.setCount('e', 1);
        assertEquals(1, h1.getCount('a'));
        assertEquals(1, h1.getCount('e'));
        assertEquals(4, h1.getTotalCount());
        //test constructor
        assertEquals(3, elemCount);
        assertEquals(2, h2.getCount('a'));
        assertEquals(1, h2.getCount('b'));
        assertEquals(1, h2.getCount('c'));
        assertEquals(4, h2.getTotalCount());

    }
}
