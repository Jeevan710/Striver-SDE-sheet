class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        int n=nums.length;
        if(n==0)
        {
            return 0;
        }
        for(int i=0;i<n;i++)
        {
            set.add(nums[i]);
        }
        int res=1;
        int cur=1;
        for(int i=0;i<n;i++)
        {
            if(!set.contains(nums[i]-1))
            {
                cur=1;
                int curNum=nums[i];
                while(set.contains(curNum+1))
                {
                    curNum++;
                    cur++;
                }
                res=Math.max(res,cur);
            }
        }
        return res;
    }
}