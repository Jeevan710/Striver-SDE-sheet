public final class Solution {
    public static int cal(int[] matrix,int n,int mid)
    {
        int start=0;
        int end=n-1;
        while(start<=end)
        {
            int m=(start+end)/2;
            if(matrix[m]<=mid)
            {
                start=m+1;
            }
            else
            {
                end=m-1;
            }
        }
        return start;
    }
    public static int findMedian(int matrix[][], int m, int n) {
        int start=1;
        int end=1000000000;
        while(start<=end)
        {
            int mid=(start+end)/2;

            int count=0;
            for(int i=0;i<m;i++)
            {
                count+=cal(matrix[i],n,mid);
            }

            if(count>(m*n)/2)
            {
                end=mid-1;
            }
            else
            {
                start=mid+1;
            }
        }
        return start;
    }
}