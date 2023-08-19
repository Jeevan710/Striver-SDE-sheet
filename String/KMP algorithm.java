class Solution {
    public int strStr(String hay, String needle) {
        int n=hay.length();
        int m=needle.length();
        int pi[]=new int[m];

        int i=1,j=0;
        pi[0]=0;
        while(i<m)
        {
            if(needle.charAt(i)==needle.charAt(j))
            {
                j++;
                pi[i]=j;
                i++;
            }
            else
            {
                if(j!=0)
                {
                    j=pi[j-1];
                }
                else
                {
                    pi[i]=j;
                    i++;
                }
            }
        }

        j=0;
        i=0;
        while(i<n)
        {
            if(hay.charAt(i)==needle.charAt(j))
            {
                i++;
                j++;
            }
            if(j==m)
            {
                return i-m;
            }
            else if(i<n && hay.charAt(i)!=needle.charAt(j))
            {
                if(j!=0)
                {
                    j=pi[j-1];
                }
                else
                {
                    i++;
                }
            }
        }
        return -1;
    }
}