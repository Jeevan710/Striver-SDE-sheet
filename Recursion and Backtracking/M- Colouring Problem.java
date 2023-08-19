

class solve {
    
    public boolean isSafe(int node,int[] col,boolean graph[][],int k,int n)
    {
        for(int i=0;i<n;i++)
        {
            if(i!=node && graph[i][node]==true && col[i]==k)
            {
                return false;
            }
        }
        return true;
    }
    
    public boolean solve(int node,int[] col,boolean graph[][],int m,int n)
    {
        if(node==n)
        {
            return true;
        }
        for(int i=1;i<=m;i++)
        {
            if(isSafe(node,col,graph,i,n))
            {
                col[node]=i;
                if(solve(node+1,col,graph,m,n))return true;
                col[node]=0;
            }
        }
        return false;
    }
    public boolean graphColoring(boolean graph[][], int m, int n) {
        int col[]=new int[n];
        for(int i=0;i<n;i++)
        {
            col[i]=0;
        }
        if(solve(0,col,graph,m,n))
        {
            return true;
        }
        return false;
    }
}