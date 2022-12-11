import java.util.Arrays;

public class MakeTree {
    public static BinaryTreeNode buildBST(int[] keys) { // O(nlogn) + O(logn) = O(nlogn)
        Arrays.sort(keys); //guarantees a O(nlogn) runtime
        return buildHelper(keys, 0, keys.length - 1);
    }

    public static BinaryTreeNode buildHelper(int[] keys, int low, int high) { // 2T(n/2) + O(1) solves to O(logn)
        if (low > high) return null; //O(1)
        int mid = (low + high) / 2; //O(1)
        BinaryTreeNode root = new BinaryTreeNode(null, keys[mid], null); //O(1)
        root.key = keys[mid]; //O(1)
        root.left = buildHelper(keys, low, mid - 1); // T(n/2)
        root.right = buildHelper(keys, mid + 1, high); // T(n/2)
        return root;
    }
}