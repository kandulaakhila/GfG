class Solution {
    public static String minWindow(String s, String p) {
         if (p.length() > s.length()) return "";

        // Step 1: Build frequency map for characters in p
        Map<Character, Integer> freqP = new HashMap<>();
        for (char c : p.toCharArray()) {
            freqP.put(c, freqP.getOrDefault(c, 0) + 1);
        }

        int required = freqP.size();  // distinct characters to match
        int formed = 0;               // distinct characters matched so far
        Map<Character, Integer> windowCounts = new HashMap<>();

        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        // Step 2: Expand the window with the right pointer
        while (right < s.length()) {
            char c = s.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            // If current char matches required frequency in p
            if (freqP.containsKey(c) && windowCounts.get(c).intValue() == freqP.get(c).intValue()) {
                formed++;
            }

            // Step 3: Try to shrink the window from the left
            while (left <= right && formed == required) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
 }

                char leftChar = s.charAt(left);
                windowCounts.put(leftChar, windowCounts.get(leftChar) - 1);

                if (freqP.containsKey(leftChar) && windowCounts.get(leftChar).intValue() < freqP.get(leftChar).intValue()) {
                    formed--;
                }
                left++;
            }
            right++;
        }

        // Step 4: Return result
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}

