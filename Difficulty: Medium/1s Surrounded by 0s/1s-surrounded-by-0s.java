class Solution {
    int cntOnes(int[][] grid) {
        // code here
                int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<int[]> q = new LinkedList<>();

        // Add boundary 1s to queue
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1) { q.add(new int[]{i,0}); visited[i][0] = true; }
            if (grid[i][m-1] == 1) { q.add(new int[]{i,m-1}); visited[i][m-1] = true; }
        }
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1) { q.add(new int[]{0,j}); visited[0][j] = true; }
            if (grid[n-1][j] == 1) { q.add(new int[]{n-1,j}); visited[n-1][j] = true; }
        }

        // BFS marking escapable 1s
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int x = cell[0], y = cell[1];
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k], ny = y + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m &&
                    grid[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        // Count trapped 1s
        int trapped = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) trapped++;
            }
        }
        return trapped;
    }
}