class Solution {
    public long pairAndSum(int[] arr) {
        // code here
       long ans = 0;

             // Check all 32 bits
             for (int bit = 0; bit < 32; bit++) {

                 long count = 0;

                 // Count numbers having this bit set
                 for (int num : arr) {
                     if ((num & (1 << bit)) != 0) {
                         count++;
                     }
                 }

                 // Number of pairs having this bit set in AND
                 long pairs = count * (count - 1) / 2;

                 // Add contribution of this bit
                 ans += pairs * (1L << bit);
             }

             return ans;
    }
}