/* Structure for Tree Node
class Node {
    int data;
    Node left, right;

    // Constructor
    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
};
*/
class Solution {
        private int transform(Node root) {
            if (root == null) return 0;

        // Recursively transform left and right subtrees
        int leftSum = transform(root.left);
        int rightSum = transform(root.right);

        // Store old value
        int oldValue = root.data;

        // Update current node to sum of left and right subtree values
        root.data = leftSum + rightSum;

        // Return total sum including old value (for parent use)
        return root.data + oldValue;
    }

    public void toSumTree(Node root) {
        // code here
        transform(root);
        
    }
}