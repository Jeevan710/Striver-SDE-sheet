class Solution {
    public void sortColors(int[] nums) {
        int i=0,j=nums.length-1,k=0;
        while(k<=j)
        {
            if(nums[k]==0)
            {
                int x=nums[i];
                nums[i]=nums[k];
                nums[k]=x;
                i++;
                k++;
            }
            else if(nums[k]==2)
            {
                int x=nums[j];
                nums[j]=nums[k];
                nums[k]=x;
                j--;
            }
            else
            k++;
        }
    }
}