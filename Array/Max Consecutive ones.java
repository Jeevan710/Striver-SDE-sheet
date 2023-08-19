class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n=nums.length;
        int sum=0;
        int index=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]==1)
            {
                sum++;
            }
            else
            {
                sum=0;
            }
            index=Math.max(sum,index);
        }
        return index;
    }
}