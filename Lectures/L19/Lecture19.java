package L19;

public class Lecture19 {
    static class BSTNode {
        int key;
        BSTNode left, right;

        BSTNode(BSTNode left, int key, BSTNode right) {
            this.left = left;
            this.right = right;
            this.key = key;
        }
    }

    // O(h) where h is the height of the tree
    int lastKey(BSTNode t) {
        if (t.right == null) return t.key;
        return lastKey(t.right);
    }

    // O(h)
    boolean containsKey(BSTNode t, int k) {
        if (t == null) return false;
        if (t.key == k) return true;
        if (t.key < k) return containsKey(t.left, k);
        else return containsKey(t.right, k);
    }

    // O(h)
    Integer floorKey(BSTNode t, int k) {
        if (t.key == k) return k;
        if (k < t.key && t.left != null) return floorKey(t.left, k);
        if (k > t.key) {
            Integer rightFLoor = (t.right != null) ? floorKey(t.right, k) : null;
            return (rightFLoor == null) ? t.key : rightFLoor;
        }
        return null;
    }
}
