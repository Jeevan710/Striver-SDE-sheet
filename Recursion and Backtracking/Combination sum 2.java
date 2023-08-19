class Solution {

    public void combination(int []can,int target,List<List<Integer>> res,List<Integer> r, int n,int i)
    {
        if(target==0)
        {
            res.add(new ArrayList<>(r));
            return ;
        }

        for(int ind=i;ind<n;ind++)
        {
            if(ind>i && can[ind]==can[ind-1])continue;
            if(can[ind]>target)break;
            r.add(can[ind]);
            combination(can,target-can[ind],res,r,n,ind+1);
            r.remove(r.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target)    {
        Arrays.sort(candidates);
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> r=new ArrayList<>();
        combination(candidates,target,res,r,candidates.length,0);
        return res;
    }
}