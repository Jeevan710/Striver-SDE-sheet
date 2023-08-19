class Solution {

    public void combination(int[] can,int target,int n,int i,List<List<Integer>> res,List<Integer> r,int sum)
    {
        if(sum==target)
        {
            res.add(new ArrayList<>(r));
            return;
        }
        if(i>=n || sum>target)
        {
            return;
        }
        r.add(can[i]);
        combination(can,target,n,i,res,r,sum+can[i]);
        //combination(can,target,n,i+1,res,r,sum+can[i]);
        r.remove(r.size()-1);
        combination(can,target,n,i+1,res,r,sum);

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> r=new ArrayList<>();
        combination(candidates,target,candidates.length,0,res,r,0);
        return res;
    }
}