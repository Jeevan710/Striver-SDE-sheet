import java.util.* ;
import java.io.*; 
public class Solution {

    public static int calculate(int[] time,long a)
    {
        int stu=1;
        long sum=0;
        for(int i=0;i<time.length;i++)
        {
            if(time[i]+sum<=a)
            {
                sum+=time[i];
            }
            else
            {
                stu++;
                sum=time[i];
            }
        }
        return stu;
    }
    public static long ayushGivesNinjatest(int m, int n, int[] arr) {
         if (m > n)
            return -1;

        long low = Integer.MIN_VALUE;
        long high=0;
        for(int i=0;i<n;i++)
        {
            high+=arr[i];
            low=Math.max(low,arr[i]);
        }
        while (low <= high) {
            long mid = (low + high) / 2;
            int students = calculate(arr, mid);

            if (students > m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}