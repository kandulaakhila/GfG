class Solution {
    public int maxSumWithK(int[] arr, int k) {
        // code here
         int n = arr.length;
          // maxEnd[i] = maximum subarray sum ending at index i
        int[] maxEnd = new int[n];
        maxEnd[0] = arr[0];

        for (int i = 1; i < n; i++) {
            maxEnd[i] = Math.max(arr[i], maxEnd[i - 1] + arr[i]);
        }

        // Sum of first k elements
        int windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int ans = windowSum;

        // Slide the window
        for (int i = k; i < n; i++) {

            // Remove left element and add new element
            windowSum += arr[i] - arr[i - k];

            // Case 1: Exactly k elements
            ans = Math.max(ans, windowSum);

            // Case 2: More than k elements
            ans = Math.max(ans, windowSum + maxEnd[i - k]);
        }

        return ans;
    }
}