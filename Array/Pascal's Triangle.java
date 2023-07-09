class Solution {

    public List<Integer> calculateRows(int i)
    {
        List<Integer> row=new ArrayList<>();
        row.add(1);
        long ans=1;
        for(int j=1;j<i;j++)
        {
            ans=ans*(i-j);
            ans=ans/j;
            row.add((int)ans);
        }
        return row;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<numRows;i++)
        {
            res.add(calculateRows(i+1));
        }
        return res;
    }
}