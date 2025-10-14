/*
class Node {
    int data;
    Node left, right;
    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public int nodeSum(Node root, int l, int r) {
        // code here
        Stack<Node>stack=new Stack();
        int sum=0;
        stack.push(root);
        while(!stack.isEmpty()){
            Node node=stack.pop();
            if(node==null)continue;
             // If node is within range, add to sum
            if (node.data >= l && node.data <= r) {
                sum += node.data;
            }

            // If node is greater than l, left subtree might have valid nodes
            if (node.data > l) {
                stack.push(node.left);
            }

            // If node is less than r, right subtree might have valid nodes
            if (node.data < r) {
                stack.push(node.right);
            }
        }

        return sum;
    }
}