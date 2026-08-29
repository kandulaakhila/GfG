class Solution {
    static final long MOD = 1_000_000_007;
    public int countSubsequences(String s, int n) {
        // code here
        long[] dp = new long[n];

        for (char ch : s.toCharArray()) {

            int digit = ch - '0';

            // Case 1: Don't take the current digit
            long[] newDp = dp.clone();

            // Case 2: Start a new subsequence with current digit
            int rem = digit % n;
            newDp[rem] = (newDp[rem] + 1) % MOD;

            // Case 3: Add current digit to existing subsequences
            for (int r = 0; r < n; r++) {

                int newRem = (r * 10 + digit) % n;

                newDp[newRem] =
                    (newDp[newRem] + dp[r]) % MOD;
            }

            dp = newDp;
            }

            // dp[0] = subsequences divisible by n
            return (int) dp[0];
    }
}