import java.io.*;
import java.util.* ;

import java.util.ArrayList;

public class Solution {
 
  
	public static int subarraysXor(ArrayList<Integer> arr, int k) {
		int a=0;
		int count=0;
		int b=0;
		HashMap<Integer,Integer> m=new HashMap<>();
		m.put(a,1);
		for(int i=0;i<arr.size();i++)
		{
			a=a^arr.get(i);
			if(m.containsKey(a^k))
			{
				b=m.get(a^k);
				count+=b;
			}
			if(m.containsKey(a))
			{
				m.put(a,m.get(a)+1);
			}
			else
			m.put(a,1);
		}
		return count;
	}
}