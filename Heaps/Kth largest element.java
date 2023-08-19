class Solution {

    public int partition(int[] nums,int start,int end)
    {
        int p=nums[start];
        int l=start+1;
        int r=end;
        while(l<=r)
        {
            if(nums[l]<p && nums[r]>p)
            {
                int t=nums[l];
                nums[l]=nums[r];
                nums[r]=t;
                l++;
                r--;
            }
            if(nums[l]>=p)
            {
                l++;
            }
            if(nums[r]<=p)
            {
                r--;
            }
        }
        int t1=nums[start];
        nums[start]=nums[r];
        nums[r]=t1;
        return r;
    }
    public int findKthLargest(int[] arr, int k) {
         int left = 0, right = arr.length - 1, kth;
    while (true) {
        int idx = partition(arr, left, right);
        if (idx == k - 1) {
            kth = arr[idx];
            break;
        }
        if (idx < k - 1) {
            left = idx + 1;
        } else {
            right = idx - 1;
        }
    }
    return kth;
    }
}