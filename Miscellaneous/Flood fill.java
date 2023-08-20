class Solution {
    public void dfs(int[][] image,int row,int intcol,int col,int color,int n,int m)
    {
        image[row][col]=color;
        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
        for(int[] d:dir)
        {
            int x=row+d[0];
            int y=col+d[1];
            if(x>=0 && x<n && y>=0 && y<m && image[x][y]==intcol && image[x][y]!=color)
            {
                dfs(image,x,intcol,y,color,n,m);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int a=image[sr][sc];
        dfs(image,sr,a,sc,color,image.length,image[0].length);
        return image;
    }
}