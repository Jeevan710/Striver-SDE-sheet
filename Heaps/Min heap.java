import java.util.* ;
import java.io.*; 

public class Solution {

    // minHeap function which take size of Queries and Queries as Input.
// Returns an array out outputs depending on the query.

    public static void swap(int[] q,int i,int j)
    {
        int t=q[i];
        q[i]=q[j];
        q[j]=t;
    }

    public static void heapify(int index,int[] q,int size)
    {
        int lchild=2*index+1;
        int rchild=2*index+2;
        int smallest=index;

        if(lchild<size && q[lchild]<q[smallest])
        {
            smallest=lchild;
        }
        if(rchild<size && q[rchild]<q[smallest])
        {
            smallest=rchild;
        }
        if(smallest!=index)
        {
            swap(q,index,smallest);
            heapify(smallest,q,size);
        }
    }
    static int s;
    public static void insert(int[] q,int val)
    {
        q[s]=val;
        int i=s;
        s++;
        while(i!=0 && q[(i-1)/2]>q[i])
        {
            int t=q[i];
            q[i]=q[(i-1)/2];
            q[(i-1)/2]=t;
            i=(i-1)/2;
        }
    }
    public static int removeTop(int[] q)
    {
        if(s==1)
        {
            s--;
            return q[0];
        }
        int val=q[0];
        q[0]=q[s-1];
        s--;
        heapify(0, q,s);
        return val;
    }

    static int[] minHeap(int n, int[][] q) {
        int size=0;
        int[] heap=new int[n];

        int tot=0;
        for(int i=0;i<n;i++)
        {
            if(q[i][0]==1)tot++;
        }
        int[] res=new int[tot];
        int id=0;
        for(int i=0;i<n;i++)
        {
            if(q[i][0]==0)
            {
                s=size;
                insert(heap,q[i][1]);
                size=s;
            }
            else
            {
                s=size;
                res[id++]=removeTop(heap);
                size=s;
            }
        }
        return res;
    }
    
}