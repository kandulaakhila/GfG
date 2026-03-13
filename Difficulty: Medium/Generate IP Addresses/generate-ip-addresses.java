class Solution {
    public ArrayList<String> generateIp(String s) {
        // code here
        ArrayList<String> result = new ArrayList<>();
        dfs(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void dfs(String s, int index, ArrayList<String> path, ArrayList<String> result) {
        // If 4 segments are formed
        if (path.size() == 4) {
            if (index == s.length()) {
                result.add(String.join(".", path));
            }
            return;
        }

        int remaining = s.length() - index;
        int segmentsLeft = 4 - path.size();

        // Pruning: too few or too many chars left
        if (remaining < segmentsLeft || remaining > segmentsLeft * 3) return;

        // Try segments of length 1 to 3
        for (int len = 1; len <= 3 && index + len <= s.length(); len++) {
            String segment = s.substring(index, index + len);
            if (isValid(segment)) {
                path.add(segment);
                dfs(s, index + len, path, result);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isValid(String s) {
        if (s.length() > 1 && s.charAt(0) == '0') return false; // no leading zeros
        int val = Integer.parseInt(s);
        return val >= 0 && val <= 255;
    }
}