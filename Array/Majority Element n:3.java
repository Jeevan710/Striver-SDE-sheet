class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        int c1=0;
        int num1=Integer.MAX_VALUE;
        int c2=0;
        int num2=Integer.MAX_VALUE;
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(nums[i]==num1)
            {
                c1++;
            }
            else if(nums[i]==num2)
            {
                c2++;
            }
            else if(c1==0)
            {
                c1=1;
                num1=nums[i];
            }
            else if(c2==0)
            {
                c2=1;
                num2=nums[i];
            }
            else 
            {
                c1--;
                c2--;
            }
        
        }
        c1=0;
        c2=0;
        for(int i=0;i<n;i++)
        {
            if(num1==nums[i])
            {
                c1++;
            }
            if(nums[i]==num2)
            {
                c2++;
            }
        }
        if(c1>n/3)
        {
            res.add(num1);
        }
        if(c2>n/3)
        {
            res.add(num2);
        }
        return res;
    }
}