class Solution {
    int n,m;
    int[][] dir={
        {-1,0},
        {1,0},
        {0,-1},
        {0,1}
    };
    public int longestPath(int[][] mat, int xs, int ys, int xd, int yd) {
        // code here
        n=mat.length;
        m=mat[0].length;
        if(mat[xs][ys]==0||mat[xd][yd]==0)
        return -1;
        boolean[][] visited=new boolean[n][m];
        return dfs(mat,xs,ys,xd,yd,visited);
    }
    private int dfs(int[][]mat,int x,int y,int xd,int yd,boolean[][] visited){
        if(x==xd && y==yd)
            return 0;
            
            visited[x][y]=true;
            int max=-1;
            for(int[]d:dir){
                int nx=x+d[0];
                int ny=y+d[1];
                if(nx>=0 && ny>=0 && nx<n && ny<m &&mat[nx][ny]==1 && !visited[nx][ny]){
                    int ans=dfs(mat,nx,ny,xd,yd,visited);
                    if(ans!=-1){
                        max=Math.max(max,ans+1);
                    }
                }
            }
            visited[x][y]=false;
            return max;
        }
    }