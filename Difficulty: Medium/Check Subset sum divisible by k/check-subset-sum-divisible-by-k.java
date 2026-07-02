class Solution {
    public boolean divisibleByK(int[] arr, int k) {
        // code here
        // dp[r] = true means there exists a subset
        // whose sum % k = r
        boolean[] dp = new boolean[k];

        // Process every number in the array
        for (int num : arr) {

            // Copy previous DP state
            boolean[] newDp = dp.clone();

            // Current number alone forms a subset
            newDp[num % k] = true;

            // Add current number to all previously possible remainders
            for (int rem = 0; rem < k; rem++) {

                if (dp[rem]) {

                    int newRem = (rem + num) % k;

                    newDp[newRem] = true;
                }
            }

            // Update DP
            dp = newDp;

            // If remainder 0 is possible, answer is true
            if (dp[0]) {
                return true;
            }
        }
         return false;
    }
}