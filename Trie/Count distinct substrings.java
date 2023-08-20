
import java.util.*;
class Node
{
	Node arr[]=new Node[26];
	boolean end=false;
}
public class Solution 
{
	static Node root=new Node();
	public static int countDistinctSubstrings(String s) 
	{
		int n=s.length();
		int res=0;
		for(int i=0;i<n;i++)
		{
			Node temp=root;
			for(int j=i;j<n;j++)
			{
				int ind=s.charAt(j)-'a';
				if(temp.arr[ind]==null)
				{
					temp.arr[ind]=new Node();
					res++;
				}
				temp=temp.arr[ind];
			}
			temp.end=true;
		}
		return res+1;
	}

}