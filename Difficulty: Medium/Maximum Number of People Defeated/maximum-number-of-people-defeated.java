class Solution {
    int maxPeopleDefeated(int p) {
        // code here
         long l = 1;
        long r = (long) Math.sqrt(p);
        int ans = 0;

        while (l <= r) {
            long mid = (l + r) / 2;
            long sum = (mid * (mid + 1) * (2 * mid + 1)) / 6;

            if (sum <= p) {
                ans = (int) mid; 
                l = mid + 1;     
            } else {
                r = mid - 1;    
            }
        }

        return ans;
        
    }
};