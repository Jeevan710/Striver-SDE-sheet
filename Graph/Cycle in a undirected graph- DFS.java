import java.util.*;


public class Solution {
  
    public static boolean isCycle (int vertex, ArrayList< ArrayList < Integer > > graph, ArrayList < Boolean > visited, int parent)
	{
	    visited.set(vertex, true);

	    for (int adjVertex : graph.get(vertex))
	    {
	        if (visited.get(adjVertex) == false)
	        {
	            if (isCycle (adjVertex, graph, visited, vertex) == true)
	            {
	                return true;
	            }
	        }
	        else if (adjVertex != parent)
	        {
	            return true;
	        }
	    }

	    return false;
	}
    public static String cycleDetection(int[][] edges, int n, int m) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>(n+1);
        for(int i=0;i<=n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++)
        {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        ArrayList<Boolean> vis=new ArrayList<>();
        for(int i=0;i<=n;i++)
        {
            vis.add(false);
        }
        for(int i=1;i<=n;i++)
        {
            if(vis.get(i)==false)
            {
                if(isCycle(i, adj, vis, -1))
                {
                    return "Yes";
                }
            }
        }
        return "No";
    }
}
    
