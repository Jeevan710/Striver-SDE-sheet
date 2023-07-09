class Solution {

    public int uniquePaths(int m, int n) {
        int step=(m+n)-2;
        m=m-1;
        double res=1;
        for(int i=1;i<=m;i++)
        {
            res=res*(step-m+i)/i;
        }
        return (int)res;
    }
}