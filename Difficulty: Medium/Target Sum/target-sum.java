import java.util.*;

class Solution {
    Map<String, Integer> memo = new HashMap<>();

    public int totalWays(int[] arr, int target) {
        return dfs(arr, 0, 0, target);
    }

    private int dfs(int[] arr, int i, int sum, int target) {
        // Base case: if we’ve used all numbers
        if (i == arr.length) {
            return sum == target ? 1 : 0;
        }

        // Create a unique key for this state
        String key = i + "," + sum;
        if (memo.containsKey(key)) return memo.get(key);

        // Choice 1: add arr[i]
        int plus = dfs(arr, i + 1, sum + arr[i], target);

        // Choice 2: subtract arr[i]
        int minus = dfs(arr, i + 1, sum - arr[i], target);

        // Store result in memo
        memo.put(key, plus + minus);

        return plus + minus;
    }
}
