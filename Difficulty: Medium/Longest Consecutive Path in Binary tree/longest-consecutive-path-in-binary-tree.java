/* Structure of Binary Tree Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
}*/
class Solution {
    int maxLen=1;
    public int longestConsecutive(Node root) {
        // code here
        if (root == null)
            return -1;

        // Start DFS from the root
        dfs(root, 1);

        // If maxLen is still 1, no consecutive parent-child pair exists
        return (maxLen == 1) ? -1 : maxLen;
    }

    // DFS function
    // len = current consecutive sequence length ending at 'node'
    private void dfs(Node node, int len) {

        if (node == null)
            return;

        // Update the global maximum
        maxLen = Math.max(maxLen, len);

        // Process left child
        if (node.left != null) {

            if (node.left.data == node.data + 1) {
                // Consecutive value → extend the sequence
                dfs(node.left, len + 1);
            } else {
                // Sequence breaks → start a new sequence
                dfs(node.left, 1);
            }
        }

        // Process right child
        if (node.right != null) {
             if (node.right.data == node.data + 1) {
                // Consecutive value → extend the sequence
                dfs(node.right, len + 1);
            } else {
                // Sequence breaks → start a new sequence
                dfs(node.right, 1);
            }
        }
    }
}