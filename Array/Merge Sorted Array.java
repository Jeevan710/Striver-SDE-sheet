class Solution {
    public void swap(int[] a, int i,int j)
    {
        int x=a[i];
        a[i]=a[j];
        a[j]=x;
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1,j=n-1,k=m+n-1;
        if(m==0)
        {
            for(int a=0;a<n;a++)
            {
                nums1[a]=nums2[a];
            }
            return;
        }
        while(k>=0 && j>=0 && i>=0)
        {
            if(nums2[j]>=nums1[i])
            {
                nums1[k--]=nums2[j--];
            }
            else if(nums2[j]<nums1[i])
            {
                nums1[k--]=nums1[i--];
            }
        }
        while(j>=0 && k>=0)
        {
            nums1[k--]=nums2[j--];
        }
    }
}