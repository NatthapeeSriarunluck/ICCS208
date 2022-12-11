package L19;

public class MyTreeMap<K extends Comparable<K>, V> {
    Node root;

    class Node {
        K key;
        V value;
        Node left, right;

        public Node(K inputKey, V inputValue) {
            key = inputKey;
            value = inputValue;
            left = right = null;
        }
    }

    MyTreeMap() {
        root = null;
    }

    V get(K k) {
        return getHelper(root, k);
    }

    V getHelper(Node t, K k) {
        if (t== null) return null;
        else if (t.key.equals(k)) return t.value;
        else if (t.key.compareTo(k) < 0) return getHelper(t.right, k);
        else return getHelper(t.left, k);

    }

    void put(K k, V v) {
        root = putHelper(root, k, v);
    }

    Node putHelper(Node t, K k, V v) {
        if (t == null) {
            t = new Node(k, v);
            return t;
        }  if (k.equals(t.key)) {
            t.value = v;
            return t;
        }  if (k.compareTo(t.key) > 0) t.right = putHelper(t.right, k, v);
         else t.left = putHelper(t.left, k, v);
        return t;
    }


    K lowerKey(K k) {
        return lowerKeyHelper(root, k);
    }

    K lowerKeyHelper(Node t, K k) {
        if (t == null) return null;
        if (k.compareTo(t.key) < 0 && t.left != null) return lowerKeyHelper(t.left, k);
        if (k.compareTo(t.key) > 0) {
            K rightFloor = (t.right != null) ? lowerKeyHelper(t.right, k) : null;
            return (rightFloor == null) ? t.key : rightFloor;
        }
        return null;
    }


    public static void main(String[] args) {
        MyTreeMap<Integer, Integer> test = new MyTreeMap<>();
        test.put(8, 8);
        test.put(3, 3);
        test.put(10, 10);
        test.put(14, 14);
        test.put(13, 13);
        test.put(1, 1);
        test.put(6, 6);
        test.put(4, 4);
        test.put(7, 7);

    }
}
