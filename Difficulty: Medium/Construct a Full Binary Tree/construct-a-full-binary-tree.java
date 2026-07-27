/* Structure of Binary Tree Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution {
    int preIndex = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    public Node constructBinaryTree(int[] pre, int[] preMirror) {
        // code here
        for (int i = 0; i < preMirror.length; i++) {
            map.put(preMirror[i], i);
        }

        return build(pre, 0, preMirror.length - 1);
    }

    private Node build(int[] pre, int l, int r) {

        // No nodes
        if (preIndex >= pre.length || l > r)
            return null;

        // Create current root
        Node root = new Node(pre[preIndex++]);

        // Leaf node
         if (l == r || preIndex >= pre.length)
            return root;

        // Next preorder element is left child
        int next = pre[preIndex];

        // Find its position in mirror preorder
        int pos = map.get(next);

        // Build left subtree
        root.left = build(pre, pos, r);

        // Build right subtree
        root.right = build(pre, l + 1, pos - 1);

        return root;
        
    }
}