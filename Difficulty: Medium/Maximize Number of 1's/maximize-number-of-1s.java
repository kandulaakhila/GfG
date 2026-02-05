class Solution {
    public int maxOnes(int arr[], int k) {
        // code here
        int left = 0; // left pointer of window
        int maxLen = 0; // result
        int zeroCount = 0; // count of zeros in current window 
        for (int right = 0;right < arr.length; right++) { 
            // expand window by including arr[right] 
            if (arr[right] == 0) { 
                zeroCount++;
                } // if window has more than k zeros, shrink from left 
                while (zeroCount > k) { 
                    if (arr[left] == 0) {
                        zeroCount--;
                        } 
                        left++;
                        } // update max length of valid window
                        maxLen = Math.max(maxLen, right - left + 1);
                        } return maxLen;
    }
}