class Solution {
    public int derangeCount(int n) {
        // code here
        // Base cases
        if (n == 0) return 1;  // convention: !0 = 1
        if (n == 1) return 0;  // only one element, no derangement possible

        // DP array to store results
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 0;

        // Recurrence: !n = (n-1) * (!(n-1) + !(n-2))
        for (int i = 2; i <= n; i++) {
            dp[i] = (i - 1) * (dp[i - 1] + dp[i - 2]);
        }

        return dp[n];
    }
}