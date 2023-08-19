public class Solution {

    public static int cal(int mid,int n,int m)
    {
        long ans=1;
        for(int i=0;i<n;i++)
        {
            ans=(long)ans*mid;
            if(ans>m)
            {
                return 2;
            }
        }
        if(ans<m)
        {
            return 1;
        }
        return 0;
    } 
    public static int NthRoot(int n, int m) {
        int res=0;
        int start=1;
        int end=m;
        while(start<=end)
        {
            int mid=(start+end)/2;
            int ans=cal(mid,n,m);
            if(ans==2)
            {
                end=mid-1;
            }
            else if(ans==1)
            {
                start=mid+1;
            }
            else
            {
                return mid;
            }
        }
        return -1;
    }
}
