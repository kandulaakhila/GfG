class Solution {
    public int findCoverage(int[][] mat) {
        // code here
        int n = mat.length, m = mat[0].length;
        int total = 0;

        // Row-wise left/right
        boolean[][] left = new boolean[n][m];
        boolean[][] right = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            boolean seenOne = false;
            for (int j = 0; j < m; j++) {
                left[i][j] = seenOne;
                if (mat[i][j] == 1) seenOne = true;
            }
            seenOne = false;
            for (int j = m - 1; j >= 0; j--) {
                right[i][j] = seenOne;
                if (mat[i][j] == 1) seenOne = true;
            }
        }

        // Column-wise up/down
        boolean[][] up = new boolean[n][m];
        boolean[][] down = new boolean[n][m];
        for (int j = 0; j < m; j++) {
            boolean seenOne = false;
            for (int i = 0; i < n; i++) {
                up[i][j] = seenOne;
                if (mat[i][j] == 1) seenOne = true;
            }
            seenOne = false;
            for (int i = n - 1; i >= 0; i--) {
                down[i][j] = seenOne;
                if (mat[i][j] == 1) seenOne = true;
            }
        }

        // Final coverage
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    int coverage = 0;
                    if (left[i][j]) coverage++;
                    if (right[i][j]) coverage++;
                    if (up[i][j]) coverage++;
                    if (down[i][j]) coverage++;
                    total += coverage;
                }
            }
        }
        return total;
    }
}