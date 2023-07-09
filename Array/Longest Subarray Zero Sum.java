import java.io.*;
import java.util.* ;

import java.util.ArrayList;

public class Solution {

	public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {
		HashMap<Integer,Integer> m=new HashMap<>();
		int res=0;
		int sum=0;
		int n=arr.size();
		m.put(0,-1);
		for(int i=0;i<n;i++)
		{
			sum+=arr.get(i);
			if(m.containsKey(sum))
			{
				res=Math.max(i-m.get(sum),res);
			}
			else
			{
				m.put(sum, i);
			}
		}
		return res;
	}
}