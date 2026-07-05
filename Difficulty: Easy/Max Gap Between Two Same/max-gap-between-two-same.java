class Solution {
    public int maxCharGap(String s) {
        //optimal solution 
        int[] first = new int[26];
        Arrays.fill(first, -1);

        int ans = -1;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            int index = ch - 'a';

            if (first[index] == -1) {
                // First occurrence of the character
                first[index] = i;
            } else {
                // Character already seen
                int distance = i - first[index] - 1;
                ans = Math.max(ans, distance);
            }
        }

        return ans;
    }
}