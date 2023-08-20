class Solution {
    public List<String> maxNumOfSubstrings(String S) {
        int n=S.length();
	    int min[]=new int[26];
        int max[]=new int[26];
        boolean exists[]=new boolean[26];
        Arrays.fill(min,Integer.MAX_VALUE);
        Arrays.fill(max,-1);
        Arrays.fill(exists,false);
        int prefixSum[][]=new int[n+1][26];
        
        for(int i=0;i<n;i++)
        {
            int ind=S.charAt(i)-'a';
            System.arraycopy(prefixSum[i],0,prefixSum[i+1],0,26);
            prefixSum[i+1][ind]++;
            min[ind]=Math.min(min[ind],i);
            max[ind]=Math.max(max[ind],i);
            exists[ind]=true;
        }

        boolean[][] graph=new boolean[26][26];
        for(int i=0;i<26;i++)
        {
            if(exists[i])
            {
                for(int j=0;j<26;j++)
                {
                    if(prefixSum[max[i]+1][j]-prefixSum[min[i]][j]>0)
                    {
                        graph[i][j]=true;
                    }
                }
            }
        }

        Stack<Integer> s=new Stack<>();
        boolean vis[]=new boolean[26];
        for(int i=0;i<26;i++)
        {
            if(exists[i] && !vis[i])
            {
                dfs(i,s,graph,vis);
            }
        }

        int batch=0;
        int[] batches=new int[26];
        int[] degree=new int[26];
        Arrays.fill(batches,-1);
        while(!s.isEmpty())
        {
            int v=s.peek();
            s.pop();
            if(batches[v]<0)
            {
                dfs(v,graph,batches,degree,batch);
                batch++;
            }
        }
        List<String> res=new ArrayList<>();
        for(int i=batch-1;i>=0;i--)
        {
            if(degree[i]==0)
            {
                int mi=Integer.MAX_VALUE;
                int ma=-1;
                for(int j=0;j<26;j++)
                {
                    if(batches[j]==i)
                    {
                        mi=Math.min(mi,min[j]);
                        ma=Math.max(ma,max[j]);
                    }
                }
                res.add(S.substring(mi,ma+1));
            }
        }
        return res;
    }
    void dfs(int v,boolean[][] graph,int[] batches,int[] degree,int batch)
    {
        if(batches[v]<0)
        {
            batches[v]=batch;
            for(int i=0;i<26;i++)
            {
                if(graph[i][v])
                {
                    dfs(i,graph,batches,degree,batch);
                }
            }
        }
        else if(batches[v]!=batch)
        {
            degree[batches[v]]++;
        }
    }
    void dfs(int i,Stack<Integer> s,boolean[][] graph,boolean vis[])
    {
        vis[i]=true;
        for(int it=0;it<26;it++)
        {
            if(vis[it]==false && graph[i][it])
            {
                dfs(it,s,graph,vis);
            }
        }
        s.push(i);
    }

}