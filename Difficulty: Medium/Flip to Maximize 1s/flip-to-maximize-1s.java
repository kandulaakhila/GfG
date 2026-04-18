class Solution {
    int maxOnes(int[] arr) {
        // code here
        int n = arr.length;
        int originalOnes = 0;
        int[] gain = new int[n];

        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                originalOnes++;
                gain[i] = -1;
            } else {
                gain[i] = 1;
            }
        }

        // Kadane’s Algorithm
        int maxGain = 0, currentSum = 0;
        for (int val : gain) {
            currentSum = Math.max(val, currentSum + val);
            maxGain = Math.max(maxGain, currentSum);
        }
         return originalOnes + maxGain;
    }
}