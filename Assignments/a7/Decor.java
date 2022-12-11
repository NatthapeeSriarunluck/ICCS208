import java.util.*;

public class Decor {
    public static BinaryTreeNode mkTree(List<Integer> postOrder, List<Integer> inOrder) {
        if (postOrder.size() != inOrder.size() || postOrder.size() == 0 || inOrder.size() == 0) {
            return null;
        }
        HashMap<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < postOrder.size(); i++) {
            inOrderMap.put(inOrder.get(i), i);
        }
        return buildTree(inOrderMap, 0, inOrder.size() - 1, 0, postOrder.size() - 1, postOrder);
    }

    public static BinaryTreeNode buildTree(Map<Integer, Integer> map, int inS, int inE, int posS, int posE, List<Integer> postOrder) {
        if (inS > inE || posS > posE) return null;
        BinaryTreeNode root = new BinaryTreeNode(null, postOrder.get(posE), null);
        Integer rootIndex = map.get(root.key);
        root.left = buildTree(map, inS, rootIndex - 1, posS, posS + rootIndex - inS - 1, postOrder);
        root.right = buildTree(map, rootIndex + 1, inE, posS + rootIndex - inS, posE - 1, postOrder);
        return root;
    }
}
