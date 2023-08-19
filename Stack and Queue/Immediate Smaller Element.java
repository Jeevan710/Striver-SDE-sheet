import java.util.Stack;
public class Solution {
    public static void immediateSmaller(int []a) {
        int n=a.length;
        Stack<Integer> s=new Stack<>();
        s.push(a[0]);
        for(int i=1;i<n;i++)
        {
            if(s.peek()>a[i])
            {
                a[i-1]=a[i];
            }
            else
            {
                a[i-1]=-1;
            }
        s.push(a[i]);
        }
        a[n-1]=-1;
    }
}
