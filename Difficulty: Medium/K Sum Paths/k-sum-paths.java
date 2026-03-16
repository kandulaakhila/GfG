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
    public int countAllPaths(Node root, int k) {
        // code here
        Map<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L, 1); // base case: empty path sum
        return dfs(root, 0L, k, prefix);
    }

    private int dfs(Node node, long currSum, int k, Map<Long, Integer> prefix) {
        if (node == null) return 0;

        // Step 1: Update current sum
        currSum += node.data;

        // Step 2: Check if there exists a prefix sum such that currSum - k exists
        int count = prefix.getOrDefault(currSum - k, 0);

        // Step 3: Add current sum to hashmap
        prefix.put(currSum, prefix.getOrDefault(currSum, 0) + 1);

        // Step 4: DFS into children
        count += dfs(node.left, currSum, k, prefix);
        count += dfs(node.right, currSum, k, prefix);

        // Step 5: Backtrack (remove current sum before returning)
        prefix.put(currSum, prefix.get(currSum) - 1);

        return count;
    }
}