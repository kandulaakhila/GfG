class Solution {
    int maxSubstring(String s) {
        // code here
          int n = s.length();
        int maxSoFar = Integer.MIN_VALUE;
        int currSum = 0;
        boolean hasZero = false;

        for (int i = 0; i < n; i++) {
            int val = (s.charAt(i) == '0') ? 1 : -1;
            if (val == 1) hasZero = true;

            currSum = Math.max(val, currSum + val);
            maxSoFar = Math.max(maxSoFar, currSum);
        }

        return hasZero ? maxSoFar : -1;
    }
}