class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        boolean dp[][]=new boolean[n][n];
        int start=0,end=0;
        int maxL=0;
        for(int i=n-1;i>=0;i--)
        {
            for(int j=i;j<n;j++)
            {
                if(i==j)
                {
                    dp[i][j]=true;
                }
                else if(s.charAt(i)==s.charAt(j) && (dp[i+1][j-1]==true || j-i==1))
                {
                    if(maxL<j-i+1)
                    {
                        start=i;
                        end=j;
                        maxL=j-i+1;
                    }
                    dp[i][j]=true;
                }
            }
        }
        return s.substring(start,end+1);
    }
}