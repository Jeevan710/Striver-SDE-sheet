

//User function Template for Java

class Solution{
    static boolean isPalindrome(String string, int i, int j)
      {
    while(i < j)
    {
      if(string.charAt(i) != string.charAt(j))
        return false;  
      i++;
      j--;
    }
    return true;
  }
  static int minP(String string,int i,int j,int[] dp)
  {
      if(i==j)
      {
          return 0;
      }
      if(dp[i]!=-1)
      {
          return dp[i];
      }
      int ans=Integer.MAX_VALUE;
      int count=0;
      for(int ind=i;ind<j;ind++)
      {
          if(isPalindrome(string,i,ind))
          {
               count=minP(string,ind+1,j,dp)+1;
                  ans=Math.min(ans,count);
          }
         
      }
      return dp[i]=ans;
  }
   static int palindromicPartition(String str)
    {
        int dp[]=new int[str.length()+1];
        Arrays.fill(dp,0);
        for(int i=str.length()-1;i>=0;i--)
        {
             int ans=Integer.MAX_VALUE;
                int count=0;
            for(int ind=i;ind<str.length();ind++)
            {
                if(isPalindrome(str,i,ind))
                {
                    count=dp[ind+1]+1;
                    ans=Math.min(ans,count);
                }
            }
            dp[i]=ans;
        }
        return dp[0]-1;
    }
}