class Solution {
    public ArrayList<Integer> search(int[] a, int[] b){
                ArrayList<Integer> result = new ArrayList<>();
        int n = a.length, m = b.length;

        // Step 1: Build LPS (Longest Prefix Suffix) array for b[]
        int[] lps = new int[m];
        int len = 0;
        for (int i = 1; i < m; ) {
            if (b[i] == b[len]) {
                lps[i++] = ++len;
            } else if (len != 0) {
                len = lps[len - 1];
            } else {
                lps[i++] = 0;
            }
        }
// Step 2: Search b[] in a[] using LPS
        int i = 0, j = 0;
        while (i < n) {
            if (a[i] == b[j]) {
                i++; j++;
                if (j == m) {
                    result.add(i - j);   // match found
                    j = lps[j - 1];      // continue search
                }
            } else if (j != 0) {
                j = lps[j - 1];          // fallback using LPS
            } else {
                i++;
            }
        }
        return result;
    }
}