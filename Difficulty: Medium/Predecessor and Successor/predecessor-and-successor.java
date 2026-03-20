/*
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {
    public ArrayList<Node> findPreSuc(Node root, int key) {
        // code here
         ArrayList<Node> result = new ArrayList<>();
        Node predecessor = null, successor = null;
        Node curr = root;

        while (curr != null) {
            if (curr.data == key) {
                // Predecessor = rightmost node of left subtree
                if (curr.left != null) {
                    Node temp = curr.left;
                    while (temp.right != null) temp = temp.right;
                    predecessor = temp;
                }
                // Successor = leftmost node of right subtree
                if (curr.right != null) {
                    Node temp = curr.right;
                    while (temp.left != null) temp = temp.left;
                    successor = temp;
                }
                break;
            } else if (curr.data > key) {
                successor = curr;   // potential successor
                curr = curr.left;
            } else {
                predecessor = curr; // potential predecessor
                curr = curr.right;
            }
        }

        result.add(predecessor); // may be null
        result.add(successor);   // may be null
        return result;
    }
}