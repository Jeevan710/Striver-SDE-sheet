import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

class Pair
{
	public int first,second,third;
	Pair(int first,int second,int third)
	{
		this.first=first;
		this.second=second;
		this.third=third;
	}
}
class PairComp implements Comparator<Pair>
{
	@Override
	public int compare(Pair pair1,Pair pair2)
	{
		return pair1.first-pair2.first;
	}
}
public class Solution 
{
	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
	{
		ArrayList<Integer> res=new ArrayList<>();
		PairComp cp=new PairComp();
		PriorityQueue<Pair> pq=new PriorityQueue<>(cp);
		for(int i=0;i<kArrays.size();i++)
		{
			pq.add(new Pair(kArrays.get(i).get(0),i,0));
		}
		while(pq.isEmpty()==false)
		{
			Pair cur=pq.peek();
			pq.remove();
			int i=cur.second;
			int j=cur.third;
			res.add(cur.first);
			if(j+1<kArrays.get(i).size())
			{
				pq.add(new Pair(kArrays.get(i).get(j+1),i,j+1));
			}
		}
		return res;
		
	}
}
