//Negative marking

class Solution {
    public int findDuplicate(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            int cur=Math.abs(nums[i]);
            if(nums[cur]<0)
            {
                return cur;
            }
            else
            {
                nums[cur]=-nums[cur];
            }
        }
        return -1;
    }
}


//Slow Fast method

class Solution {
    public int findDuplicate(int[] nums) {
        int i=nums[0],j=nums[0];
        do{
            i=nums[i];
            j=nums[nums[j]];
        }while(i!=j);
        i=nums[0];
        while(i!=j)
        {
            i=nums[i];
            j=nums[j];
        }
        return i;

    }
}