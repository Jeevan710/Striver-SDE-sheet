import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {

    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        int xo=0;
	for(int i=0;i<n;i++)
	{
		xo=xo^arr.get(i);
		xo=xo^(i+1);
	}
	int bitno=(xo & ~(xo-1));
	int one=0;
	int zero=0;



	for(int i=0;i<n;i++)
	{
		if((bitno & arr.get(i))!=0)
		{
			one=one^arr.get(i);
		}
		else
		{
			zero=zero^arr.get(i);
		}
	}
	for(int i=1;i<=n;i++)
	{
		if((bitno & i)!=0)
		{
			one=one^i;
		}
		else
		{
			zero=zero^i;
		}
	}


	int count=0;
	for(int i=0;i<n;i++)
	{
		if(one==arr.get(i))
		count++;
	}
	if(count==2)
	{
		return new int[]{zero,one};
	}
	return new int[]{one,zero};
    }
}