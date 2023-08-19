
import java.util.Arrays;
public class Solution {

    public static boolean calculate(int[] arr,int a,int k)
    {
        int n=arr.length;
        int cows=1;
        int sum=arr[0];
        for(int i=1;i<n;i++)
        {
            if(arr[i]-sum>=a)
            {
                sum=arr[i];
                cows++;
            }
            if(cows>=k)return true;
        }
        return false;
    }
    public static int aggressiveCows(int []stalls, int k) {
        Arrays.sort(stalls);
        int n=stalls.length;
        int end=stalls[n-1]-stalls[0];
        int start=1;
        while(start<=end)
        {
            int mid=(start+end)/2;
            if(calculate(stalls,mid,k))
            {
                start=mid+1;
            }
            else
            {
                end=mid-1;
            }
        }
        return end;
    }
}