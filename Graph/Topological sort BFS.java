class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int in[]=new int[V];
        for(int i=0;i<V;i++)
        {
            for(int j=0;j<adj.get(i).size();j++)
            {
                in[adj.get(i).get(j)]++;
            }
        }
        
        Queue<Integer> q=new LinkedList<>();
        int res[]=new int[V];
        int i=0;
        
        for(int j=0;j<V;j++)
        {
            if(in[j]==0)
            {
                q.add(j);
            }
        }
        int cnt=0;
        while(!q.isEmpty())
        {
            int temp=q.peek();
            q.remove();
            cnt++;
            res[i++]=temp;
            for(int a:adj.get(temp))
            {
                in[a]--;
                if(in[a]==0)
                {
                    q.add(a);
                }
            }
        }
        return res;
    }
}