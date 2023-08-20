class Solution {
    public boolean canPartition(int[] nums) {
        long sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            sum+=nums[i];
        }
        if(sum%2==1)
        {
            return false;
        }
        sum=sum/2;
        boolean dp[][]=new boolean[n+1][(int)sum+1];
        dp[0][0]=true;
        for(int i=0;i<=n;i++)
        {
            dp[i][0]=true;
        }
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=sum;j++)
            {
                dp[i][j]=dp[i-1][j];
                if(nums[i-1]<=j)
                {
                    dp[i][j]=dp[i][j] || dp[i-1][j-nums[i-1]]==true?true:false;
                }
            }
        }
        return dp[n][(int)sum];
    }
}