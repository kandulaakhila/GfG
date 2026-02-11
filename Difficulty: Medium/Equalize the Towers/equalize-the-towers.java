class Solution {
    public int minCost(int[] heights, int[] cost) {
        // code here
        int minH = Integer.MAX_VALUE, maxH = Integer.MIN_VALUE;
    for (int h : heights) {
        minH = Math.min(minH, h);
        maxH = Math.max(maxH, h);
    }
    
    int ans = Integer.MAX_VALUE;
    for (int target = minH; target <= maxH; target++) {
        long currCost = 0;
        for (int i = 0; i < heights.length; i++) {
            currCost += (long)Math.abs(heights[i] - target) * cost[i];
        }
        ans = (int)Math.min(ans, currCost);
    }
    return ans;
}
}
