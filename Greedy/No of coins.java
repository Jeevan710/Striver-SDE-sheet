

class Solution{

	public int minCoins(int coins[], int M, int V) 
	{ 
	    int dp[]=new int[V+1];
	    dp[0]=0;
	    for(int i=1;i<V+1;i++)
	    {
	        dp[i]=Integer.MAX_VALUE;
	    }
	    for(int i=0;i<M;i++)
	    {
	        for(int j=0;j<=V;j++)
	        {
	            if(coins[i]<=j)
	            {
	                int s=dp[j-coins[i]];
	                if(s!=Integer.MAX_VALUE && s+1<dp[j])
	                {
	                    dp[j]=s+1;
	                }
	            }
	        }
	    }
	    if(dp[V]==Integer.MAX_VALUE)
	    {
	        return -1;
	    }
	    return dp[V];
	} 
}