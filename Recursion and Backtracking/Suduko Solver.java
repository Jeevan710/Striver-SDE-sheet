class Solution {
    public Boolean isSafe(char[][] board,int row,int col,char num)
    {
        for(int i=0;i<9;i++)
        {
            if(board[i][col]==num)
            {
                return false;
            }
            if(board[row][i]==num)
            {
                return false;
            }
            if(board[(row/3)*3+i/3][(col/3)*3+(i%3)]==num)
            {
                return false;
            }
        }
        return true;
    }
    public Boolean solve(char[][] board,int row,int col)
    {
        if(row==9)
        {
            return true;
        }
        int nextRow,nextCol;
        if(col==8)
        {
            nextRow=row+1;
            nextCol=0;
        }
        else
        {
            nextRow=row;
            nextCol=col+1;
        }
        if(board[row][col]=='.')
        {
            for(char i='1';i<='9';i++)
            {
                if(isSafe(board,row,col,i))
                {
                    board[row][col]=i;
                    if(solve(board,nextRow,nextCol))
                    return true;
                    else
                    board[row][col]='.';
                }
            }
        }
        else
        {
            if(solve(board,nextRow,nextCol))
            return true;
        }
        return false;
    }
    public void solveSudoku(char[][] board) {
        solve(board,0,0);
    }
}