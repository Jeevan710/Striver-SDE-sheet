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
    public int findMaximumXOR(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            insert(nums[i]);
        }
        int res=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            int x=getMax(nums[i]);
            res=Math.max(res,x);
        }
        return res;
    }
}