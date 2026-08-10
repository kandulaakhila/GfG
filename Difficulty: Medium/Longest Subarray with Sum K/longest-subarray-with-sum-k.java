class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
      // prefix sum -> earliest index
        HashMap<Long, Integer> map = new HashMap<>();

        // Current prefix sum
        long sum = 0;

        // Answer
        int maxLen = 0;

        // Important: handles subarrays starting from index 0
        map.put(0L, -1);

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {

            // Add current element
            sum += arr[i];

            // Previous prefix sum we need
            long required = sum - k;

            // If required prefix sum exists
            if (map.containsKey(required)) {

                // Calculate subarray length
                int len = i - map.get(required);

                // Update maximum length
                maxLen = Math.max(maxLen, len);
            }
                // Store only first occurrence
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return maxLen;
    }
}