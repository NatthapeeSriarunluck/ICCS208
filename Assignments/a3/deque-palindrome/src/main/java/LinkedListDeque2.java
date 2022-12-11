import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;

public class LinkedListDeque2<T> implements Deque<T>, LinkedListDeque3 {
    class Node {

        private T value;
        private Node next, prev;

        public Node(T value, Node previous, Node next) {
            this.value = value;
            this.prev = previous;
            this.next = next;
        }
    }

    private Node frontSen;
    private Node backSen;
    private int size;

    public void LinkedListDeque() {
        frontSen = new Node(null, null, null);
        backSen = new Node(null, frontSen, null);
        frontSen.next = backSen;
        size = 0;

    }

    @Override

    public void addFirst(Object item) {
        frontSen.next = new Node((T) item, frontSen, frontSen.next);
        frontSen.next.next.prev = frontSen.next;
        size++;
    }

    @Override

    public void addLast(Object item) {
        backSen.prev = new Node((T) item, backSen.prev, backSen);
        backSen.prev.prev.next = backSen.prev;
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public Iterator<T> descendingIterator() {
        return null;
    }

    @Override
    public String toString() {
        Node current = frontSen.next;
        if (size == 0) {
            return "[]";
        }
        String ans = "";
        while (current != null) {
            ans += current.value + " ";
            current = current.next;
        }
        return ans;
    }

    @Override
    public boolean offerFirst(T t) {
        return false;
    }

    @Override
    public boolean offerLast(T t) {
        return false;
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T removed = frontSen.next.value;
        frontSen.next = frontSen.next.next;
        frontSen.next.prev = frontSen;
        size--;
        return removed;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T removed = backSen.prev.value;
        backSen.prev = backSen.prev.prev;
        backSen.prev.next = backSen;
        size--;
        return removed;
    }

    @Override
    public T pollFirst() {
        return null;
    }

    @Override
    public T pollLast() {
        return null;
    }

    @Override
    public T getFirst() {
        return null;
    }

    @Override
    public T getLast() {
        return null;
    }

    @Override
    public T peekFirst() {
        return null;
    }

    @Override
    public T peekLast() {
        return null;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean add(T t) {
        return false;
    }

    @Override
    public boolean offer(T t) {
        return false;
    }

    @Override
    public T remove() {
        return null;
    }

    @Override
    public T poll() {
        return null;
    }

    @Override
    public T element() {
        return null;
    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public void push(T t) {

    }

    @Override
    public T pop() {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public T get(int index) {
        int count = 0;
        Node current = frontSen.next;
        while (current.value != null) {
            if (count == index) {
                return current.value;
            } else {
                count++;
                current = current.next;
            }
        }
        return null;
    }
}

