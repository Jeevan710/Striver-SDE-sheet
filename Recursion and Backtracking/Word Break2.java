import java.util.* ;
import java.io.*;
import java.rmi.Remote;
import java.util.ArrayList;





public class Solution {

	public static void solve(int ind,String s,ArrayList<String> dictionary,ArrayList<String> res,List<String> ds)
	{
		if(ind==s.length())
		{
			StringBuffer str=new StringBuffer();
			for(int i=0;i<ds.size();i++)
			{
				str.append(ds.get(i));
				str.append(" ");
			}
			res.add(str.toString());
			return ;
		}
		for(int i=ind;i<s.length();i++)
		{
			if(dictionary.contains(s.substring(ind,i+1)))
			{
				ds.add(s.substring(ind,i+1));
				solve(i+1, s, dictionary, res, ds);
				ds.remove(ds.size()-1);
			}
		}
	}
	public static ArrayList<String> wordBreak(String s, ArrayList<String> dictionary) {
		ArrayList<String> res=new ArrayList<>();
		List<String> r=new ArrayList<>();
		solve(0,s,dictionary,res,r);
		return res;
		
	}
}