class Solution {
    public void dfs(char[][] grid,boolean[][] vis,int row,int col)
    {
        vis[row][col]=true;
        int n=grid.length;
        int m=grid[0].length;

        int xRow[]={-1,1,0,0};
        int yRow[]={0,0,1,-1};

        for(int i=0;i<4;i++)
        {
            int nRow=row+xRow[i];
            int nCol=col+yRow[i];

            if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && vis[nRow][nCol]==false && grid[nRow][nCol]=='1')
            {
                dfs(grid,vis,nRow,nCol);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        boolean vis[][]=new boolean[n][m];
        for(boolean row[]:vis)
        {
            Arrays.fill(row,false);
        }
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(vis[i][j]==false && grid[i][j]=='1')
                {
                    cnt++;
                    dfs(grid,vis,i,j);
                }
            }
        }
        return cnt;
    }
}