class Solution {
    public boolean canSplit(int arr[]) {
        // code here
         long totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        // If total sum is odd, cannot split equally
        if (totalSum % 2 != 0) return false;

        long halfSum = totalSum / 2;
        long prefixSum = 0;

        // Traverse until second last element (to ensure both sides are non-empty)
        for (int i = 0; i < arr.length - 1; i++) {
            prefixSum += arr[i];
            if (prefixSum == halfSum) {
                return true; 
            }
        }

        return false; 
    }
}