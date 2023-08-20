import java.util.*;

class Graph{
    private static int noOfNodes;

    // Pointer to an array containing adjacency lists.
    private static ArrayList < Integer > adj[];

    // Act as Constructor.
    Graph(int noOfNodes) {
        adj = new ArrayList[noOfNodes];

        for (int i = 0; i < noOfNodes; i++) {
            adj[i] = new ArrayList < Integer > ();
        }

        this.noOfNodes = noOfNodes;
    }

    // To add an edge to between two nodes in a Graph.
    public void addEdge(int a, int b) {
        // Add b to a's list.
        adj[a].add(b);
    }

    public boolean isCycle(int v,boolean[] vis,boolean[] path)
    {
            vis[v]=true;
            path[v]=true;
            for(int i:adj[v])
            {
                if(vis[i]==false)
                {
                    if(isCycle(i,vis,path))
                    {
                        return true;
                    }
                }
                else if(path[i]==true)
                {
                    return true;
                }
            }
            path[v]=false;
        return false;
    }
}
public class Solution {
    
  public static boolean detectCycleInDirectedGraph(int num, ArrayList < ArrayList < Integer >> pre) {
        Graph g=new Graph(num+1);
        for(int i=0;i<pre.size();i++)
        {
            g.addEdge(pre.get(i).get(0), pre.get(i).get(1));
        }
        boolean vis[]=new boolean[num+1];
        boolean path[]=new boolean[num+1];
        Arrays.fill(vis,false);
        Arrays.fill(path,false);
        for(int i=1;i<=num;i++)
        {
            if(g.isCycle(i, vis,path))
            {
                return true;
            }
        }
        return false;
  }
}