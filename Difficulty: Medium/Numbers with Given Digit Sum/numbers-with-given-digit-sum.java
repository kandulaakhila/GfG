class Solution {
    int[][]dp;
    int solve(int pos,int n,int sum){
        if(sum<0) return 0;
        if(pos==n) return sum==0?1:0;
        if(dp[pos][sum]!=-1)
        return dp[pos][sum];
        int ways=0;
        for(int digit=0;digit<=9;digit++){
            if(digit<=sum){
                ways+=solve(pos+1,n,sum-digit);
            }
        }
        return dp[pos][sum]=ways;
    }
    public int countWays(int n, int sum) {
        // code here
        if(sum>9*n) return -1;
        dp=new int[n+1][sum+1];
        for(int i=0;i<n;i++)
        Arrays.fill(dp[i],-1);
        int ans=0;
        for(int first=1;first<=9;first++){
            if(first<=sum)
            ans+=solve(1,n,sum-first);
        }
        if(ans==0)
        return -1;
        return ans;
    }
};