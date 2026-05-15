class Solution {
    public int optimalKeys(int n) {
        // code here
                if (n <= 6) return n;

        // dp[i] will store the maximum number of 'A's possible with i key presses
        int[] dp = new int[n + 1];

        // Initialize small values
        for (int i = 0; i <= 6; i++) {
            dp[i] = i;
        }

        // Fill dp for larger n
        for (int i = 7; i <= n; i++) {
            dp[i] = 0;
            // Try all breakpoints j where we do Ctrl+A, Ctrl+C at step j
            for (int j = i - 3; j >= 1; j--) {
                // After j presses, we can paste (i - j - 1) times
                int curr = dp[j] * (i - j - 1);
                dp[i] = Math.max(dp[i], curr);
            }
        }

        return dp[n];
        
    }
}