import java.util.*;
public class Solution {
  public static boolean detectCycleInDirectedGraph(int num, ArrayList < ArrayList < Integer >> pre) {
        num=num+1;
        int[] in=new int[num];
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>(num);
        for(int i=0;i<num;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(ArrayList<Integer> a:pre)
        {
            adj.get(a.get(0)).add(a.get(1));
            in[a.get(1)]++;
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
        return n==num?false:true;
  }
}