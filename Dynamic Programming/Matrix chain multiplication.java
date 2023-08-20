

//User function Template for Java

class Solution{
    static int mat(int n,int arr[],int i,int j,int[][] dp)
    {
        if(i==j)
        {
            return 0;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        dp[i][j]=Integer.MAX_VALUE;
        for(int k=i;k<j;k++)
        {
            int ans=mat(n,arr,i,k,dp)+mat(n,arr,k+1,j,dp)+arr[i-1]*arr[k]*arr[j];
            dp[i][j]=Math.min(dp[i][j],ans);
        }
        return dp[i][j];
    }
    static int matrixMultiplication(int N, int p[])
    {
        int dp[][]= new int[N][N];
    
        for(int row[]:dp)
        Arrays.fill(row,-1);
        
        int i =1;
        int j = N-1;
        return mat(N,p,i,j,dp);
    
    }
}