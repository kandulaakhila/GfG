class Solution {
    public boolean canRepresentBST(List<Integer> arr) {
        // code here
        Stack<Integer> stack = new Stack<>();

        int lowerBound = Integer.MIN_VALUE;

        for (int value : arr) {

            // If current value is less than the allowed minimum,
            // preorder cannot represent a BST.
            if (value < lowerBound)
                return false;

            // Pop all smaller ancestors because we are moving
            // to their right subtree.
            while (!stack.isEmpty() && value > stack.peek()) {
                lowerBound = stack.pop();
            }

            // Push current node.
            stack.push(value);
        }

        return true;
        
        
    }
}