

// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {

    
    public static void solve(int[][] vis,ArrayList<String> res,String s,int[][] board,int i,int j,int n)
    {
        if(i==n-1 && j==n-1)
        {
            res.add(s);
            return;
        }
        if(i>n || j>n || i<0 ||j<0)
        {
            return;
        }
        if(i+1<n && board[i+1][j]==1 && vis[i+1][j]==0)
        {
            vis[i+1][j]=1;
            solve(vis,res,s+"D",board,i+1,j,n);
            vis[i+1][j]=0;
        }
        if(i-1>=0 && board[i-1][j]==1 && vis[i-1][j]==0)
        {
            vis[i-1][j]=1;
            solve(vis,res,s+"U",board,i-1,j,n);
            vis[i-1][j]=0;
        }
        if(j+1<n && board[i][j+1]==1 && vis[i][j+1]==0)
        {
            vis[i][j+1]=1;
            solve(vis,res,s+"R",board,i,j+1,n);
            vis[i][j+1]=0;
        }
        if(j-1>=0 && board[i][j-1]==1 && vis[i][j-1]==0)
        {
            vis[i][j-1]=1;
            solve(vis,res,s+"L",board,i,j-1,n);
            vis[i][j-1]=0;
        }
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        int[][] vis=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                vis[i][j]=0;
            }
        }
        ArrayList<String> res=new ArrayList<>();
        if(m[0][0]==1)
        {
            vis[0][0]=1;
            solve(vis,res,"",m,0,0,n);
        }
        return res;
    }
}