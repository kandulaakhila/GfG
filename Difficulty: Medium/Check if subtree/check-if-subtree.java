/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {
    
    // Helper function to check if two trees are identical
    public boolean isSubTreeEqual(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        // If one is null or data mismatch
        if (root1 == null || root2 == null || root1.data != root2.data) {
            return false;
        }
        
        // Check left and right subtrees
        return isSubTreeEqual(root1.left, root2.left) && isSubTreeEqual(root1.right, root2.right);
    }
    
    // Main function to check if root2 is a subtree of root1
    public boolean isSubTree(Node root1, Node root2) {
        // Base case
        if (root1 == null) {
            return false;
        }
        // If data matches and subtree matches
        if (root1.data == root2.data && isSubTreeEqual(root1, root2)) {
            return true;
        }
        
        // Otherwise check left or right subtree
        return isSubTree(root1.left, root2) || isSubTree(root1.right, root2);
    }
}
