package L10;

import java.util.Iterator;

public class SLList<T> implements Iterable<T> {

    private int size = 0;

    private class IntNode {
        T value; // an int data item
        IntNode next; // ref to the next node

        public IntNode(T val, IntNode r) {
            this.value = val;
            this.next = r;
        }
    }

    private IntNode first;

    public SLList() {
        first = null;
    }


    public void addFirst(T x) {
        first = new IntNode(x, first);
        size++;
    }

    public T getFirst() throws IndexOutOfBoundsException {
        if (first == null) {
            throw new IndexOutOfBoundsException("List can't be empty");
        }
        return first.value;
    }

    public T get(int index) {
        int count = 0;
        IntNode current = first;
        while (current != null) {
            if (count == index) {
                return current.value;
            } else {
                count++;
                current = current.next;
            }
        }
        throw new IndexOutOfBoundsException("Index out of range");
    }

    public int size() {
        return size;
    }

    public class LinkedListIterator implements Iterator<T> {
        private IntNode current = null;

        public LinkedListIterator() {
            this.current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (current == null) {
                throw new ArrayIndexOutOfBoundsException();
            }
            T ans = current.value;
            current = current.next;
            return ans;
        }
    }

    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    public boolean equals(SLList<T> other) {
        Iterator<T> iter1 = this.iterator();
        Iterator<T> iter2 = other.iterator();
        if (size == other.size) {
            while (iter1.hasNext() && iter2.hasNext()) {
                if (!iter1.next().equals(iter2.next())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
