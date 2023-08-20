class Solution
{   
    public int small(Node root,int[] k)
    {
        if(root==null)
        {
            return Integer.MIN_VALUE;
        }
        int l=small(root.right,k);
        if(l!=Integer.MIN_VALUE)
        {
            return l;
        }
        k[0]--;
        if(k[0]==0)
        {
            return root.data;
        }
        int r=small(root.left,k);
        return r;
    }
    public int kthLargest(Node root,int K)
    {
        int p[]=new int[]{K};
        return small(root,p);
    }
}