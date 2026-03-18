/*
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
*/

class Solution {
    private int moves;
    public int distCandy(Node root) {
        // code here
        moves = 0;
        dfs(root);
        return moves;
    }

    private int dfs(Node node) {
        if (node == null) return 0;

        // Post-order traversal
        int leftBalance = dfs(node.left);
        int rightBalance = dfs(node.right);

        // Count moves: absolute flow from children
        moves += Math.abs(leftBalance) + Math.abs(rightBalance);

        // Return balance to parent
        // (candies at node - 1 needed + balances from children)
        return node.data - 1 + leftBalance + rightBalance;
    }
}