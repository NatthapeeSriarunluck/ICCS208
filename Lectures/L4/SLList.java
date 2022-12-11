package L4;

public class SLList {
    static class Node {
        private final int value;
        private Node next;

        public Node(int i, Node n) {
            value = i;
            next = n;
        }
    }

    private final Node sentinel;
    private int size;

    public SLList() {
        sentinel = new Node(0, null);
        size = 0;
    }

    public SLList(int x) {
        sentinel = new Node(0, null);
        sentinel.next = new Node(x, null);
        size = 1;
    }

    public void addFirst(int x) {
        sentinel.next = new Node(x, sentinel.next);
        size++;
    }

    public void addLast(int x) {
        Node current = sentinel;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(x, null);
        size++;
    }

    public int getFirst() {
        return sentinel.next.value;
    }

    public int getLast() {
        int ans = 0;
        Node current = sentinel.next;
        while (current != null) {
            ans = current.value;
            current = current.next;
        }
        return ans;
    }

    public int size() {
        return size;
    }

    public String toString() {
        String ans = "";
        Node current = sentinel.next;
        while (current != null) {
            ans += " " + current.value;
            current = current.next;
        }
        return ans;
    }

    public void removeFirst() {
        if (size != 0) {
            sentinel.next = null;
            size--;
        }
    }

    public void insert(int newValue, int k) {
        Node current = sentinel;
        int count = 0;
        while (count + 1 < k) {
            current = current.next;
            count++;
        }
        current.next = new Node(newValue, current.next);
        size++;
    }
}
