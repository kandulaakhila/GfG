// class Node
// {
//     int data;
//     Node left, right;

//     public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }

class Solution {
    static class NodeInfo {
        boolean isBST;
        int size, min, max;
        NodeInfo(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    static int maxBSTSize;

    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root) {
        // Write your code here
        maxBSTSize = 0;
        postOrder(root);
        return maxBSTSize;
    }

    private static NodeInfo postOrder(Node node) {
        if (node == null) {
            return new NodeInfo(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        NodeInfo left = postOrder(node.left);
        NodeInfo right = postOrder(node.right);

        // Check BST property
        if (left.isBST && right.isBST && node.data > left.max && node.data < right.min) {
            int size = left.size + right.size + 1;
            maxBSTSize = Math.max(maxBSTSize, size);
            return new NodeInfo(true, size,
                                Math.min(node.data, left.min),
                                Math.max(node.data, right.max));
        }

        return new NodeInfo(false, 0, 0, 0);
    }
}