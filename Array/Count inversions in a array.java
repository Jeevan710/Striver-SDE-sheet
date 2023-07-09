import java.util.* ;
import java.io.*; 
public class Solution {

    public static long merge(long arr[],int start,int mid,int end)    {
        
        ArrayList<Long> temp=new ArrayList<>();
        int i=start,j=mid+1;
        long res=0;
        while(i<=mid && j<=end)
        {
            if(arr[i]<=arr[j])
            {
                temp.add(arr[i]);
                i++;
            }
            else{
                temp.add(arr[j]);
                res+=(long)(mid-i+1);
                j++;
            }
        }        

        while(i<=mid)
        {
            temp.add(arr[i]);
            i++;
        }
        while(j<=end)
        {
            temp.add(arr[j]);
            j++;
        }
        for(int k=start;k<=end;k++)
        {
            arr[k]=temp.get(k-start);
        }
        return res;
    }
    public static long mergesort(long arr[],int start,int end)
    {
        long res=0;
        if(start>=end)
        {
            return res;
        }
        int mid=(start+end)/2;
        res+=mergesort(arr, start, mid);
        res+=mergesort(arr, mid+1, end);
        res+=merge(arr,start,mid,end);
        return res;
    }
    public static long getInversions(long arr[], int n) {
        long res=mergesort(arr, 0, n-1);
        return res;
    }
}