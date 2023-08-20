import java.util.* ;

import sun.net.www.content.text.plain;

import java.io.*; 

class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}

public class Solution {
	
	public static ArrayList < Integer > dijkstra(ArrayList< ArrayList < Integer > > vec, int v, int edges, int source){
		ArrayList<ArrayList<Pair>> graph=new ArrayList<>(v);
		for(int i=0;i<v;i++)
		{
			graph.add(new ArrayList<Pair>());
		}
		for(int i=0;i<vec.size();i++)
		{
			graph.get(vec.get(i).get(0)).add(new Pair(vec.get(i).get(2), vec.get(i).get(1)));
			graph.get(vec.get(i).get(1)).add(new Pair(vec.get(i).get(2), vec.get(i).get(0)));
		}

		PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.first-b.first);
		int dis[]=new int[v];
		boolean vis[]=new boolean[v];
		Arrays.fill(vis,false);
		Arrays.fill(dis,Integer.MAX_VALUE);

		pq.add(new Pair(0,source));
		dis[source]=0;

		while(!pq.isEmpty())
		{
			int node=pq.peek().second;
			pq.remove();
			vis[node]=true;

			for(Pair it:graph.get(node))
			{
				int w=it.first;
				int adj=it.second;

				if(dis[node]+w<dis[adj] && vis[adj]==false)
				{
					dis[adj]=dis[node]+w;
					pq.add(new Pair(dis[adj], adj));
				}
			}
		}
		ArrayList<Integer> res=new ArrayList<>();
		for(int i=0;i<v;i++)
		{
			res.add(dis[i]);
		}
		return res;
	}
}