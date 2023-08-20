import java.util.*;

public class Solution {
    public static int find(int i,int[] par)
    {
        if(par[i]==i)
        {
            return i;
        }
        return par[i]=find(par[i],par);
    }
    public static String cycleDetection(int[][] edges, int n, int m) {
        int[] par=new int[n+1];
        int[] rank=new int[n+1];

        for(int i=0;i<=n;i++)
        {
            par[i]=i;
            rank[i]=1;
        }
        for(int[] a:edges)
        {
            int u=a[0];
            int v=a[1];

            int p1=find(u,par);
            int p2=find(v,par);

            if(p1!=p2)
            {
                par[p1]=p2;
            }
            else
            {
                return "Yes";
            }
        }
        return "No";
    }
}
    
