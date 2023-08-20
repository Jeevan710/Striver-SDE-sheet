import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {

	public static ArrayList<Integer> countDistinctElements(ArrayList<Integer> arr, int k) {
		HashMap<Integer,Integer> map=new HashMap<>();
		ArrayList<Integer> res=new ArrayList<>();
		int i=0;
		for(;i<k;i++)
		{
			if(map.containsKey(arr.get(i)))
			{
				map.put(arr.get(i),map.get(arr.get(i))+1);
			}
			else
			{
				map.put(arr.get(i),1);
			}
		}
		res.add(map.size());
		for(;i<arr.size();i++)
		{
			if(map.containsKey(arr.get(i)))
			{
				map.put(arr.get(i),map.get(arr.get(i))+1);
			}
			else
			{
				map.put(arr.get(i),1);
			}
			if(map.get(arr.get(i-k))==1)
			{
				map.remove(arr.get(i-k));
			}
			else
			{
				map.put(arr.get(i-k),map.get(arr.get(i-k))-1);
			}
			res.add(map.size());
		}
		return res;
	}
}
