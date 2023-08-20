class Solution {
    public int minC(int[] cuts,int sStick,int eStick,int i,int j)
    {
        if(i>j)
        {
            return 0;
        }
        int cost=Integer.MAX_VALUE;
        for(int x=i;x<=j;x++)
        {
            int lcut=minC(cuts,sStick,cuts[x],i,x-1);
            int rcut=minC(cuts,cuts[x],eStick,x+1,j);
            int c=eStick-sStick+lcut+rcut;
            cost=Math.min(cost,c);
        }
        return cost;
    }
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        return minC(cuts,0,n,0,cuts.length-1);
    }
}