import java.util.PriorityQueue;

public class Solution {
    public static int[] findMedian(int[] arr, int n) {
        PriorityQueue<Integer> minq=new PriorityQueue<>();
        PriorityQueue<Integer> maxq=new PriorityQueue<>((a,b)->b-a);
        int[] res=new int[n];
        int j=0;
        for(int i=0;i<n;i++)
        {
            if(maxq.isEmpty())
            {
                //System.out.println("i "+i+".one ");
                maxq.add(arr[i]);
                res[j++]=arr[i];
                continue;
            }
            else if(minq.isEmpty())
            {
                if(maxq.peek()>arr[i])
                {
                    //System.out.println("i "+i+".two ");
                    minq.add(maxq.peek());
                    maxq.remove();
                    maxq.add(arr[i]);
                    res[j++]=(maxq.peek()+minq.peek())/2;
                }
                else
                {
                    //System.out.println("i "+i+".three ");
                    minq.add(arr[i]);
                    res[j++]=(maxq.peek()+minq.peek())/2;
                }
                continue;
            }
            else if(i%2==0)//odd
            {
                if(minq.peek()<arr[i])
                {
                    //System.out.println("i "+i+".four ");
                    maxq.add(minq.peek());
                    minq.remove();
                    minq.add(arr[i]);
                    res[j++]=maxq.peek();
                }
                else
                {
                    //System.out.println("i "+i+".five ");
                    maxq.add(arr[i]);
                    res[j++]=maxq.peek();
                }
            }
            else//even
            {
                if(maxq.peek()>arr[i])
                {
                    //System.out.println("i "+i+".six ");
                    minq.add(maxq.peek());
                    maxq.remove();
                    maxq.add(arr[i]);
                    res[j++]=(maxq.peek()+minq.peek())/2;
                }
                else
                {
                    //System.out.println("i "+i+".seven ");
                    minq.add(arr[i]);
                    res[j++]=(maxq.peek()+minq.peek())/2;
                }
            }
        }
        return res;
    }
}
