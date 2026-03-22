class Solution {
    static class Cell {
        int x, y, time;
        Cell(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    public int orangesRot(int[][] mat) {
        // code hereint rows = mat.length;
         int rows = mat.length;
        int cols = mat[0].length;
        Queue<Cell> queue = new LinkedList<>();
        int freshCount = 0;

        // Step 1: Add all rotten oranges to queue and count fresh ones
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 2) {
                    queue.add(new Cell(i, j, 0));
                } else if (mat[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        // Step 2: BFS to rot adjacent oranges
        int time = 0;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        
        while (!queue.isEmpty()) {
            Cell curr = queue.poll();
            time = curr.time;

            for (int[] dir : directions) {
                int nx = curr.x + dir[0];
                int ny = curr.y + dir[1];

                if (nx >= 0 && ny >= 0 && nx < rows && ny < cols && mat[nx][ny] == 1) {
                    mat[nx][ny] = 2; // rot the orange
                    freshCount--;
                    queue.add(new Cell(nx, ny, curr.time + 1));
                }
            }
        }

        // Step 3: If fresh oranges remain, return -1
        return freshCount == 0 ? time : -1;
    }
}
