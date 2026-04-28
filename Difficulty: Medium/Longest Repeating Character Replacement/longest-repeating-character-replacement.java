class Solution {
    public int longestSubstr(String s, int k) {
        // code here
        int[] freq = new int[26];   // Step 1: frequency array for A–Z
    int left = 0;               // Step 2: left pointer of sliding window
    int maxCount = 0;           // Step 3: track max frequency in window
    int result = 0;             // Step 4: store longest valid window length

    for (int right = 0; right < s.length(); right++) {
        // Step 5: include current character in window
        freq[s.charAt(right) - 'A']++;

        // Step 6: update maxCount (most frequent char in window)
        maxCount = Math.max(maxCount, freq[s.charAt(right) - 'A']);

        // Step 7: check if window is invalid (too many changes needed)
        while ((right - left + 1) - maxCount > k) {
            freq[s.charAt(left) - 'A']--; // shrink window
            left++;
        }

        // Step 8: update result with current valid window size
        result = Math.max(result, right - left + 1);
    }
     return result; // Step 9: final answer
}
}
