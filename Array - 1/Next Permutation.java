import java.util.*;
class Solution {

    public void nextPermutation(int[] nums) {
        int index=-1;
        for(int i=nums.length-2;i>=0;i--)
        {
            if(nums[i]<nums[i+1])
            {
                index=i;
                break;
            }
        }
        if(index==-1)
        {
            index=0;
        int high=nums.length-1;
        while(index<=high){
            int x=nums[index];
            nums[index]=nums[high];
            nums[high]=x;
            high--;index++;
        }
            return ;
        }
        for(int i=nums.length-1;i>0;i--)
        {
            if(nums[i]>nums[index])
            {
                int x=nums[index];
                nums[index]=nums[i];
                nums[i]=x;
                break;
            }

        }
        int high=nums.length-1;
        index++;
        while(index<=high){
            int x=nums[index];
            nums[index]=nums[high];
            nums[high]=x;
            high--;index++;
        }
    }
}