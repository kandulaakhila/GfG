class Solution {
    public int findMax(int n, int[] a, int[] b, int[] k) {
        // code here
        long[] diff=new long[n+1];
         int m = a.length;

        // Apply range updates
        for (int i = 0; i < m; i++) {
            diff[a[i]] += k[i];

            if (b[i] + 1 < n) {
                diff[b[i] + 1] -= k[i];
            }
        }

        long max = 0;
        long current = 0;

        // Prefix sum and find maximum
        for (int i = 0; i < n; i++) {
            current += diff[i];
            max = Math.max(max, current);
        }

        return (int) max;
        
    }
}
