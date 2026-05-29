class Solution {
        Map<String, Integer> memo = new HashMap<>();
    public int validGroups(String s) {
        // code here
                return dfs(s, 0, 0);
    }

    private int dfs(String s, int index, int prevSum) {
        // Base case: reached end of string → one valid grouping
        if (index == s.length()) return 1;

        // Memoization key
        String key = index + "," + prevSum;
        if (memo.containsKey(key)) return memo.get(key);

        int count = 0;
        int sum = 0;

        // Try all substrings starting at index
        for (int j = index; j < s.length(); j++) {
            sum += s.charAt(j) - '0';  // digit sum of substring s[index..j]
            if (sum >= prevSum) {
                count += dfs(s, j + 1, sum);
            }
        }

        memo.put(key, count);
        return count;
        
    }
}