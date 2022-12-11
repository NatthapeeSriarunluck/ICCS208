import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyPriorityQueue<T> implements IPriorityQueue<T>, Iterable<T> {
    private final List<T> queueItems;
    private final CompareWith<T> cc;
    private int size;

    public MyPriorityQueue(CompareWith<T> cc) {
        this.queueItems = new ArrayList<>();
        this.cc = cc;
        size = 0;
    }

    public class MyPriorityQueueIterator implements Iterator<T> {
        private int count;

        public MyPriorityQueueIterator() {
            count = 0;
        }

        @Override
        public boolean hasNext() {
            return count < queueItems.size();
        }

        @Override
        public T next() {
            if (hasNext()) {
                return queueItems.get(count++);
            }
            throw new IndexOutOfBoundsException();
        }
    }

    public class MyPriorityQueueRevIterator implements Iterator<T> {
        private int count;

        public MyPriorityQueueRevIterator() {
            count = size() - 1;
        }

        @Override
        public boolean hasNext() {
            return count >= 0;
        }

        @Override
        public T next() {
            if (hasNext()) {
                return queueItems.get(count--);
            }
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void add(T item) {
        if (size == 0) {
            queueItems.add(item);
            size++;

        } else {
            for (int i = 0; i < size; i++) {
                if (cc.lessThan(item, queueItems.get(i))) {
                    queueItems.add(i, item);
                }
            }
            size++;
        }
    }

    @Override
    public void addAll(List<T> items) {
        for (T item : items) {
            for (int j = 0; j < size; j++) {
                if (cc.lessThan(item, queueItems.get(j))) {
                    queueItems.add(j, item);
                    break;
                }
            }
            size++;
        }
    }

    @Override
    public T getMinimum() {
        return queueItems.get(0);
    }

    @Override
    public void removeMinimum() {
        size--;
        queueItems.remove(0);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyPriorityQueueIterator();
    }

    @Override
    public Iterator<T> revIterator() {
        return new MyPriorityQueueRevIterator();
    }

    public String toString() {
        String ans = "";
        for (int i = 0; i < size; i++) {
            ans += " " + queueItems.get(i);
        }
        return ans;
    }
}
