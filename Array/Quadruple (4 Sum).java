class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n=nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(i>0 && nums[i]==nums[i-1])
            {
                continue;
            }
            for(int j=i+1;j<n;j++)
            {
                if(j>i+1 && nums[j]==nums[j-1])
                {
                    continue;
                }
                int start=j+1,end=n-1;
                long tar=(long)target-nums[i]-nums[j];
                while(start<end)
                {
                    if((long)nums[start]+nums[end]>tar)
                    {
                        end--;
                    }
                    else if((long)nums[start]+nums[end]<tar)
                    {
                        start++;
                    }
                    else
                    {
                        List<Integer> r=new ArrayList<>();
                        r.add(nums[i]);
                        r.add(nums[j]);
                        r.add(nums[start]);
                        r.add(nums[end]);
                        res.add(r);
                        start++;
                        end--;

                        while(start<end && nums[start]==nums[start-1])start++;
                        while(start<end && nums[end]==nums[end+1])end--;
                    }
                }
            }
        }
        return res;
    }
}