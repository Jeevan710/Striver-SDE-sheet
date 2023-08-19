import java.util.* ;
import java.io.*; 
/*
	This is signature of helper function 'knows'.
	You should not implement it, or speculate about its implementation.

	boolean knows(int A, int B); 
	Function 'knows(A, B)' will returns "true" if the person having
	id 'A' know the person having id 'B' in the party, "false" otherwise.
	Use it as Runner.knows(A, B);
*/
	
public class Solution {
	public static int findCelebrity(int n) {
        int i=0,j=n-1;
		while(i<j)
		{
			if(Runner.knows(i,j))
			{
				i++;
			}
			else
			{
				j--;
			}
		}
		int c=i;

		for(i=0;i<n;i++)
		{
			if (i != c && (Runner.knows(c, i) || !Runner.knows(i, c)))
                return -1;
		}
		return c;
    }
}