class Solution {
    public Boolean isSafe(char[][] board,int row,int col)
    {
        int r=row;
        int c=col;
        for(int i=0;i<c;i++)
        {
            if(board[row][i]=='Q')
            {
                return false;
            }
        }
        while(r>=0 && c>=0)
        {
            if(board[r][c]=='Q')
            {
                return false;
            }
            r--;
            c--;
        }
        r=row;
        c=col;
        while(c>=0 && r<board.length)
        {
            if(board[r][c]=='Q')
            {
                return false;
            }
            r++;
            c--;
        }
        return true;
    }
    public List<String> construct(char[][] board)
    {
        List<String> r=new ArrayList<>();
        for(int i=0;i<board.length;i++)
        {
            String s=new String(board[i]);
            r.add(s);
        }
        return r;
    }
    public void dfs(char[][] board,List<List<String>> res,int col)
    {
        if(col==board.length)
        {
            res.add(construct(board));
            return;
        }
        for(int row=0;row<board.length;row++)
        {
            if(isSafe(board,row,col))
            {
                board[row][col]='Q';
                dfs(board,res,col+1);
                board[row][col]='.';
            }
        }

    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                board[i][j]='.';
            }
        }
        List<List<String>> res=new ArrayList<>();
        dfs(board,res,0);
        return res;
    }
}