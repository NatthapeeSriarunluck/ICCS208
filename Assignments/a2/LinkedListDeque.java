public class LinkedListDeque<T> {
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

    public LinkedListDeque() {
        frontSen = new Node(null, null, null);
        backSen = new Node(null, frontSen, null);
        frontSen.next = backSen;
        size = 0;

    }

    public LinkedListDeque(LinkedListDeque<T> other) {
        LinkedListDeque<T> deepCopy = new LinkedListDeque<>();
        Node current = other.backSen;
        while (current.prev != other.frontSen) {
            deepCopy.addFirst(current.prev.value);
            current = current.prev;
        }
    }


    public void addFirst(T item) {
        frontSen.next = new Node(item, frontSen, frontSen.next);
        frontSen.next.next.prev = frontSen.next;
        size++;
    }

    public void addLast(T item) {
        backSen.prev = new Node(item, backSen.prev, backSen);
        backSen.prev.prev.next = backSen.prev;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

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


}
