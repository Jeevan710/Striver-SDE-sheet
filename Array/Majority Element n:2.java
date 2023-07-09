class Solution {
    public int majorityElement(int[] nums) {
        int max=nums[0];
        int count=1;
        int num=nums[0];
        int n=nums.length;
        for(int i=1;i<n;i++)
        {
            if(nums[i]==num)
            {
                count++;
            }
            else
            {
                count--;
            }
            if(count==0)
            {
                count=1;
                num=nums[i];
            }
        }
        count=0;
        for(int i=0;i<n;i++){
            if(nums[i]==num)
            {
                count++;
            }
        }
        if(count>=n/2)
        {
            return num;
        }
        return -1;
    }
}