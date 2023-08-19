class Solution {

    public void subset(int i,int[] nums,List<Integer> r,List<List<Integer>> res,int n,Boolean flag)
    {
        if(i>=n)
        {
            return;
        }
        if(i==0 || nums[i-1]!=nums[i] ||flag)
        {
            int val=nums[i];
            r.add(val);
            subset(i+1,nums,r,res,n,true);
            res.add(new ArrayList<>(r));
            r.remove(r.size()-1);
        }
        subset(i+1,nums,r,res,n,false);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        res.add(new ArrayList<>());
        int start=0;
        int end=0;
        for(int i=0;i<nums.length;i++)
        {
            start=0;
            if(i>0 && nums[i]==nums[i-1])
            {
                start=end+1;
            }
            int n=res.size();
            end=n-1;
            for(int j=start;j<n;j++)
            {
                List<Integer> in=new ArrayList<>(res.get(j));
                in.add(nums[i]);
                res.add(in);
            }
        }
        return res;
    }
}