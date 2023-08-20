class Solution {

    public boolean dfs(int[][] graph, int col[],int c,int i)
    {
        col[i]=c;

        for(int it:graph[i])
        {
            if(col[it]==-1)
            {
                if(dfs(graph,col,1-c,it)==false)
                {
                    return false;
                }
            }
            else if(col[it]==c)
            {
                return false;
            }
        }
        return true;
    }
    public boolean dfsHelper(int[][] graph)
    {
        int n=graph.length;
        int col[]=new int[n];
        Arrays.fill(col,-1);

        for(int i=0;i<n;i++)
        {
            if(col[i]==-1)
            {
                if(dfs(graph,col,0,i)==false)
                {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean bfs(int[][] graph,int col[],int i)
    {
        Queue<Integer> q=new LinkedList<>();
        q.add(i);
        col[i]=0;
        while(!q.isEmpty())
        {
            int temp=q.peek();
            q.remove();
            for(int it:graph[temp])
            {
                if(col[it]==-1)
                {
                    col[it]=1-col[temp];
                    q.add(it);
                }
                else if(col[it]==col[temp])
                {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int col[]=new int[n];
        Arrays.fill(col,-1);

        for(int i=0;i<n;i++)
        {
            if(col[i]==-1)
            {
                if(bfs(graph,col,i)==false)
                {
                    return false;
                }
            }
        }
        return true;
    }
}