class Solution {
    public int minimumCost(int[] cost, int w) {
        // code here
         int INF = (int)1e9;

        int[] dp = new int[w + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        int n = cost.length;

        for (int i = 0; i < n; i++) {
            if (cost[i] == -1) continue;

            int wt = i + 1;

            for (int j = wt; j <= w; j++) {
                if (dp[j - wt] != INF) {
                    dp[j] = Math.min(dp[j],
                                     dp[j - wt] + cost[i]);
                }
            }
        }

        return dp[w] == INF ? -1 : dp[w];
    }
}