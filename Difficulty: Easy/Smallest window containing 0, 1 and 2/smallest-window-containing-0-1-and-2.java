class Solution {
    public int smallestSubstring(String s) {
        // code here
         int n = s.length();
        int[] lastSeen = new int[3]; // store last seen indices of '0','1','2'
        // initialize with -1 (not seen yet)
        for (int i = 0; i < 3; i++) lastSeen[i] = -1;

        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - '0';
            lastSeen[idx] = i; // update last seen index

            // check if all three have been seen
            if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {
                int minIndex = Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2]));
                int maxIndex = Math.max(lastSeen[0], Math.max(lastSeen[1], lastSeen[2]));
                minLen = Math.min(minLen, maxIndex - minIndex + 1);
            }
        }

        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
};
