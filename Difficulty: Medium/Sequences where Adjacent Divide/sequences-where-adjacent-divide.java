class Solution {
    public int count(int n, int m) {
        // code here
        // dp[len][val] = number of arrays of length len
        // ending with value val
        int[][] dp = new int[n + 1][m + 1];

        // Base case
        for (int val = 1; val <= m; val++) {
            dp[1][val] = 1;
        }

        // Build DP
        for (int len = 2; len <= n; len++) {

            // Current ending value
            for (int curr = 1; curr <= m; curr++) {

                // Previous ending value
                for (int prev = 1; prev <= m; prev++) {

                    // Check divisibility condition
                    if (curr % prev == 0 || prev % curr == 0) {

                        dp[len][curr] += dp[len - 1][prev];
                    }
                }
            }
        }

        // Sum all arrays of length n
        int ans = 0;
         for (int val = 1; val <= m; val++) {
            ans += dp[n][val];
        }

        return ans;
    }
}