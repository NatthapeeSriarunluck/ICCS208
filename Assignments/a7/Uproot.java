import java.util.*;

public class Uproot {
    public static HashMap<Integer, Integer> treeToParentMap(BinaryTreeNode T) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        mapHelper(hash, T);
        return hash;
    }

    public static void mapHelper(HashMap<Integer, Integer> hash, BinaryTreeNode T) {
        if (T.left != null) {
            hash.put(T.left.key, T.key);
            mapHelper(hash, T.left);
        }
        if (T.right != null) {
            hash.put(T.right.key, T.key);
            mapHelper(hash, T.right);
        }
    }

    public static BinaryTreeNode parentMapToTree(Map<Integer, Integer> map) {
        Map<Integer, Integer> original = map;
        Map<Integer, List<Integer>> parentChild = parentChild(map);
        BinaryTreeNode root = new BinaryTreeNode(null, findRoot(parentChild, original), null);
        return generateTree(root, parentChild);
    }

    public static HashMap<Integer, List<Integer>> parentChild(Map<Integer, Integer> parentChild) {
        HashMap<Integer, List<Integer>> newMap = new HashMap<>();
        for (Integer key : parentChild.keySet()) {
            if (!newMap.containsKey(parentChild.get(key))) {
                newMap.put(parentChild.get(key), new ArrayList<>());
            }
            newMap.get(parentChild.get(key)).add(key);
        }
        return newMap;
    }

    public static Integer findRoot(Map<Integer, List<Integer>> parentChild, Map<Integer, Integer> original) {
        Integer root = 0;
        for (Map.Entry<Integer, Integer> entry : original.entrySet()) {
            if (entry.getKey() == entry.getValue() || entry.getValue() == null) {
                root = entry.getKey();
            }
        }
        List<List<Integer>> lists = new ArrayList<>(parentChild.values());
        Set<Integer> keySet = parentChild.keySet();
        Object[] keysArray = keySet.toArray();
        HashSet<Integer> valueSet = new HashSet<>();
        for (List<Integer> list : lists) {
            for (int num : list) {
                if (parentChild.containsKey(num)) {
                    valueSet.add(num);
                }
            }
        }
        for (Object o : keysArray) {
            if (!valueSet.contains(o)) {
                root = (Integer) o;
                break;
            }
        }
        return root;
    }

    public static BinaryTreeNode generateTree(BinaryTreeNode root, Map<Integer, List<Integer>> hash) {
        List<Integer> children = hash.get(root.key);
        if (!hash.containsKey(root.key)) {
            return root;
        }
        if (hash.get(root.key).size() > 1) {
            root.left = generateTree(new BinaryTreeNode(null, children.get(0), null), hash);
            root.right = generateTree(new BinaryTreeNode(null, children.get(1), null), hash);
        } else {
            root.left = generateTree(new BinaryTreeNode(null, children.get(0), null), hash);
        }
        return root;
    }
}