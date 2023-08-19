import java.util.* ;
import java.io.*; 
public class Solution {
    public static int[] maxMinWindow(int[] a, int n) {
        Stack<Integer> s=new Stack<>();
        int left[]=new int[n];
        int right[]=new int[n];
        for(int i=0;i<n;i++)
        {
            while(s.isEmpty()==false && a[s.peek()]>=a[i])
            {
                right[s.peek()]=i;
                s.pop();
            }
            s.push(i);
        }
        while(s.isEmpty()==false)
        {
            right[s.peek()]=n;
            s.pop();
        }

        for(int i=0;i<n;i++)
        {
            while(s.isEmpty()==false && a[s.peek()]>=a[i])
            {
                s.pop();
            }
            if(s.isEmpty())
            {
                left[i]=-1;
            }
            else
            {
                left[i]=s.peek();
            }
            s.push(i);
        }
      
        int[] res=new int[n];
        for(int i=0;i<n;i++)
        {
            res[i]=Integer.MIN_VALUE;
        }
        for(int i=0;i<n;i++)
        {
            int len=right[i]-left[i]-1;
            res[len-1]=Math.max(res[len-1],a[i]);
        }
        for(int i=n-2;i>=0;i--)
        {
            res[i]=Math.max(res[i],res[i+1]);
        }
        return res;
    }
}

