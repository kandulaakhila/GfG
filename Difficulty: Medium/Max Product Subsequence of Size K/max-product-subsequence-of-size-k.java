import java.util.*;

class Solution {
    public int maxProduct(int[] arr, int k) {

        long[] maxDP = new long[k + 1];
        long[] minDP = new long[k + 1];

        Arrays.fill(maxDP, Long.MIN_VALUE);
        Arrays.fill(minDP, Long.MAX_VALUE);

        // Selecting 0 elements
        maxDP[0] = 1;
        minDP[0] = 1;

        for (int num : arr) {

            // Go backwards
            for (int j = k; j >= 1; j--) {

                long oldMax = maxDP[j - 1];
                long oldMin = minDP[j - 1];

                // Take maximum previous product
                if (oldMax != Long.MIN_VALUE) {
                    long value = oldMax * num;

                    maxDP[j] = Math.max(maxDP[j], value);
                    minDP[j] = Math.min(minDP[j], value);
                }

                // Take minimum previous product
                if (oldMin != Long.MAX_VALUE) {
                    long value = oldMin * num;

                    maxDP[j] = Math.max(maxDP[j], value);
                    minDP[j] = Math.min(minDP[j], value);
                }
            }
        }

        return (int) maxDP[k];
    }
}