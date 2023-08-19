

//User function Template for Java


class Solution {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        if(n>m)
        {
            return kthElement(arr2,arr1,m,n,k);
        }
        int start=Math.max(0,k-m),end=Math.min(n,k);
        while(start<=end)
        {
            int cut1=(start+end)/2;
            int cut2=k-cut1;
            
            int l1=(cut1==0)? Integer.MIN_VALUE:arr1[cut1-1];
            int l2=(cut2==0)? Integer.MIN_VALUE:arr2[cut2-1];
            int r1=(cut1==n)? Integer.MAX_VALUE:arr1[cut1];
            int r2=(cut2==m)? Integer.MAX_VALUE:arr2[cut2];
            
            if(l2<=r1 && l1<=r2)
            {
                return Math.max(l1,l2);
            }
            else if(l2>r1)
            {
                start=cut1+1;
            }
            else
            {
                end=cut1-1;
            }
        }
        return 1;
        
    }
}