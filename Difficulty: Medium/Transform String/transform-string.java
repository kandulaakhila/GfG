class Solution {
    int transform(String s1, String s2) {
        // code here
        // Lengths must be same
         int n = s1.length();
        if (n != s2.length())
            return -1;

        // Check whether both strings contain same characters
        int[] freq = new int[256];

        for (char c : s1.toCharArray())
            freq[c]++;

        for (char c : s2.toCharArray())
            freq[c]--;

        for (int x : freq) {
            if (x != 0)
                return -1;
        }

        // Find longest common suffix
        int i = n - 1;
        int j = n - 1;

        while (i >= 0 && j >= 0) {

            if (s1.charAt(i) == s2.charAt(j)) {
                i--;
                j--;
                            } else {
                                i--;
                            }
                        }

                        // Remaining characters in s2 must be moved
                        return j + 1;
        
    }
}