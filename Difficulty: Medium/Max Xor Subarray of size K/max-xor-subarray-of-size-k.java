class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {
        // code here
         int n = arr.length;
        int xor = 0;

        // Step 1: XOR of the first k elements
        for (int i = 0; i < k; i++) {
            xor ^= arr[i];
        }

        int maxXor = xor;

        // Step 2: Slide the window across the array
        for (int i = k; i < n; i++) {
            xor ^= arr[i - k]; // remove outgoing element
            xor ^= arr[i];     // add incoming element
            maxXor = Math.max(maxXor, xor);
        }

        return maxXor;
    }
}
