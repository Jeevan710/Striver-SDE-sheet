class Solution {
    public void swap(int[][] matrix,int i,int j,int a,int b)
    {
        int x=matrix[i][j];
        matrix[i][j]=matrix[a][b];
        matrix[a][b]=x;
    }
    public void rotate(int[][] matrix) {
         int n=matrix.length;
         int m=matrix[0].length;

         for(int i=0;i<n;i++)
         {
             for(int j=i;j<m;j++)
             {
                 swap(matrix,i,j,j,i);
             }
         }
         for(int i=0;i<n;i++)
         {
             for(int j=0;j<m/2;j++)
             {
                 swap(matrix,i,j,i,m-j-1);
             }
         }
    }
}