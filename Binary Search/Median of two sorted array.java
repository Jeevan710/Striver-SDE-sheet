class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length)
        {
            return findMedianSortedArrays(nums2,nums1);
        }
        int start=0,end=nums1.length;
        int med=(nums1.length+nums2.length+1)/2;
        while(start<=end)
        {
            int cut1=(start+end)/2;
            int cut2=med-cut1;
            int INT_MIN=Integer.MIN_VALUE;
            int INT_MAX=Integer.MAX_VALUE;
            int l1 = (cut1 == 0)? INT_MIN:nums1[cut1-1];
            int l2 = (cut2 == 0)? INT_MIN:nums2[cut2-1];
            int r1 = (cut1 == nums1.length)? INT_MAX:nums1[cut1];
            int r2 = (cut2 == nums2.length)? INT_MAX:nums2[cut2];

            if(l2<=r1 && l1<=r2)
            {
                if((nums1.length+nums2.length)%2==1)
                {
                    return Math.max(l1,l2);
                }
                else
                {
                    return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                }
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
        return 0.0;
    }
}