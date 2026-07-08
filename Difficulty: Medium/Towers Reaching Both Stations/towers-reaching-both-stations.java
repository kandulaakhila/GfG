class Solution {

    int n, m;

    int[][] dir = {
        {-1,0},
        {1,0},
        {0,-1},
        {0,1}
    };

    public int countCoordinates(int[][] mat) {

        n = mat.length;
        m = mat[0].length;

        boolean[][] stationP = new boolean[n][m];
        boolean[][] stationQ = new boolean[n][m];

        for(int j = 0; j < m; j++)
            dfs(0, j, stationP, mat);

        for(int i = 0; i < n; i++)
            dfs(i, 0, stationP, mat);

        for(int j = 0; j < m; j++)
            dfs(n - 1, j, stationQ, mat);

        for(int i = 0; i < n; i++)
            dfs(i, m - 1, stationQ, mat);

        int count = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(stationP[i][j] && stationQ[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(int row, int col, boolean[][] visited, int[][] mat) {

        visited[row][col] = true;

        for(int[] d : dir) {

            int newRow = row + d[0];
            int newCol = col + d[1];

            if(newRow >= 0 && newRow < n &&
               newCol >= 0 && newCol < m &&
               !visited[newRow][newCol] &&
               mat[newRow][newCol] >= mat[row][col]) {

                dfs(newRow, newCol, visited, mat);
            }
        }
    }
}