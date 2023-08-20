class Node
{
    Node arr[]=new Node[2];
}
class Solution {
    Node root=new Node();
   
    void insert(int num)
    {
        Node temp=root;
        for(int i=31;i>=0;i--)
        {
            int bit=(num>>i) & 1;
            if(temp.arr[bit]==null)
            {
                temp.arr[bit]=new Node();
            }
            temp=temp.arr[bit];
        }
    }
    
    int getMax(int num)
    {
        Node temp=root;
        int res=0;
        for(int i=31;i>=0;i--)
        {
            int bit=(num>>i) & 1;
            if(temp.arr[1-bit]!=null)
            {
                res=res | (1<<i);
                temp=temp.arr[1-bit];
            }
            else
            {
                temp=temp.arr[bit];
            }
        }
        return res;
    }
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        int m=queries.length;
        int[][] q=new int[m][3];
        for(int i=0;i<m;i++)
        {
            q[i][0] = queries[i][0];
            q[i][1] = queries[i][1];
            q[i][2] = i;
        }
        Arrays.sort(q,(a,b)->{
            return a[1]-b[1];
        });
        int i=0;
        int n=nums.length;
        int[] res=new int[m];
        for(int query[]:q)
        {
            while(i<n && nums[i]<=query[1])
            {
                insert(nums[i]);
                i++;
            }
            int ans=-1;
            if(i!=0)
            {
                ans=getMax(query[0]);
            }
            res[query[2]]=ans;
        }
        return res;
    }
}