class Orange
{
    int row;
    int col;
    int time;
    Orange(int row,int col,int time)
    {
        this.row=row;
        this.col=col;
        this.time=time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int res=0;
        int n=grid.length;
        int m=grid[0].length;
        Queue<Orange> q=new LinkedList<>();
        boolean vis[][]=new boolean[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                vis[i][j]=false;
                if(grid[i][j]==2)
                {
                    q.add(new Orange(i,j,0));
                    vis[i][j]=true;
                }
            }
        }
        while(q.isEmpty()==false)
        {
            Orange o=q.peek();
            q.remove();
            vis[o.row][o.col]=true;
            res=Math.max(res,o.time);
            int i=o.row;
            int j=o.col;
            if(i-1>=0 && vis[i-1][j]==false && grid[i-1][j]==1)
            {
                vis[i-1][j]=true;
                q.add(new Orange(i-1,j,o.time+1));
            }
            if(i+1<n && vis[i+1][j]==false && grid[i+1][j]==1)
            {
                vis[i+1][j]=true;
                q.add(new Orange(i+1,j,o.time+1));
            }
            if(j-1>=0 && vis[i][j-1]==false && grid[i][j-1]==1)
            {
                vis[i][j-1]=true;
                q.add(new Orange(i,j-1,o.time+1));
            }
            if(j+1<m && vis[i][j+1]==false && grid[i][j+1]==1)
            {
                vis[i][j+1]=true;
                q.add(new Orange(i,j+1,o.time+1));
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1 && vis[i][j]==false)
                {
                    return -1;
                }
            }
        }
        return res;
    }
}