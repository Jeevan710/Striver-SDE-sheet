class Solution {
    public void setZeroes(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int col=1;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(matrix[i][j]==0)
                {
                    matrix[i][0]=0;
                if(j!=0)
                {
                    matrix[0][j]=0;
                }
                else
                {
                    col=0;
                }
                }
            }
        }

        for(int i=1;i<matrix.length;i++)
        {
            for(int j=1;j<matrix[0].length;j++)
            {
                if(matrix[i][j]!=0){
                if((matrix[i][0]==0) || (matrix[0][j]==0))
                {
                    matrix[i][j]=0;
                }}
            }
        }
        for(int i=0;i<matrix[0].length;i++)
        {
            if(matrix[0][0]==0)
            {
                matrix[0][i]=0;
            }
        }
        for(int i=0;i<matrix.length;i++)
        {
            if(col==0)
            {
                matrix[i][0]=0;
            }
        }
    }
}