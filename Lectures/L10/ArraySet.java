package L10;


import java.util.ArrayList;
import java.util.Iterator;


public class  ArraySet<T> {
    private final ArrayList<T> items = new ArrayList<>();


    public void add(T value) {
        if (!contains(value)) {
            items.add(value);

        }
    }

    public boolean contains(T value) {
        for (T i : items) {
            if (value.equals(i)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return items.size();
    }

    private class ArraySetIterator implements Iterator<T> {
        private int itPos;

        public ArraySetIterator() {
            itPos = 0;
        }

        @Override
        public boolean hasNext() {
            return itPos < items.size();
        }

        @Override
        public T next() {
            if (hasNext()) {
                return items.get(itPos++);
            }
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public Iterator<T> iterator() {
        return new ArraySetIterator();
    }

}
