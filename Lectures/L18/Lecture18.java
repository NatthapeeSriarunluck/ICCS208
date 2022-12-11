package L18;

public class Lecture18<E> {
    public static class treenode<E> {
        E key;
        treenode<E> left, right;

        public treenode(E key) {
            this.key = key;
            this.left = null;
            this.right = null;
        }

        public int depth(treenode<E> r) {     // T(n) = 2T(n/2) + O(1) solves to O(n)
            if (r == null)
                return 0;
            return 1 + Math.max(depth(r.left), depth(r.right)); //we call recursively left half and right half of the tree
        }

        public static int count(treenode<?> tree) {
            if (tree == null) return 0;
            return 1 + count(tree.left) + count(tree.right);
        }

        public static String concatPreorder(treenode<String> tree) {
            if (tree == null) return "";
            StringBuilder answer = new StringBuilder();
            answer.append(tree.key);
            answer.append(concatPreorder(tree.left));
            answer.append(concatPreorder(tree.right));
            return answer.toString();
        }
    }
}
