class Solution {
    public boolean canFinish(int num, int[][] pre) {
		int[] in=new int[num];
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>(num);
        for(int i=0;i<num;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int[] a:pre)
        {
            adj.get(a[1]).add(a[0]);
            in[a[0]]++;
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<num;i++)
        {
            if(in[i]==0)
            {
                q.add(i);
            }
        }
        int n=0;
        while(!q.isEmpty())
        {
            int temp=q.peek();
            q.remove();
            n++;
            for(int a:adj.get(temp))
            {
                in[a]--;
                if(in[a]==0)
                {
                    q.add(a);
                }
            }
        }
        return n==num;
    }
}