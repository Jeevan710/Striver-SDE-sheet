class Solution 
{

    static int eggDrop(int egg, int floor) 
	{
	   int[][] dp=new int[egg+1][floor+1];
	   
	   for(int i=1;i<=floor;i++)
	   {
	       dp[1][i]=i;
	   }
	   for(int i=1;i<=egg;i++)
	   {
	       dp[i][0]=0;
	       dp[i][1]=1;
	   }
	
	   for(int i=2;i<=egg;i++)
	   {
	       for(int j=2;j<=floor;j++)
	       {
	           dp[i][j]=Integer.MAX_VALUE;
	           for(int k=1;k<=j;k++)
	           {
	               dp[i][j]=Math.min(dp[i][j],1+Math.max(dp[i-1][k-1],dp[i][j-k]));
	           }
	       }
	   }
	   return dp[egg][floor];
	}
}