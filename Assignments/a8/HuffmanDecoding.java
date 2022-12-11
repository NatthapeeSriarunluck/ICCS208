abstract class Node implements Comparable<Node> {

    public int frequency; // the frequency of this tree
    public char data;
    public Node left, right;

    public Node(int freq) {
        frequency = freq;
    }

    // compares on the frequency
    public int compareTo(Node tree) {
        return frequency - tree.frequency;
    }

}

class HuffmanLeaf extends Node {

    public HuffmanLeaf(int freq, char val) {
        super(freq);
        data = val;
    }

}

class HuffmanNode extends Node {

    public HuffmanNode(Node l, Node r) {
        super(l.frequency + r.frequency);
        left = l;
        right = r;
    }

}

public class HuffmanDecoding {
    void decode(String s, Node root) {
        Node current = root;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                current = current.left;
            } else {
                current = current.right;
            }
            if (current.left ==null & current.right == null) {
                System.out.print(current.data);
                current = root;
            }
        }
    }
}