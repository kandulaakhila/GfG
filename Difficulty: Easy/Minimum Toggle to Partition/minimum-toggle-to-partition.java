class Solution {
    int minToggle(int[] arr) {
        // code here
        int n = arr.length;

        // Count total zeros
        int totalZeros = 0;
        for (int num : arr) {
            if (num == 0) totalZeros++;
        }

        int minToggles = Integer.MAX_VALUE;
        int onesSoFar = 0, zerosSoFar = 0;

        for (int i = 0; i <= n; i++) {
            int zerosRemaining = totalZeros - zerosSoFar;
            int toggles = onesSoFar + zerosRemaining;
            minToggles = Math.min(minToggles, toggles);

            // Update counts if not past end
            if (i < n) {
                if (arr[i] == 1) onesSoFar++;
                else zerosSoFar++;
            }
        }
        return minToggles;
    }
}