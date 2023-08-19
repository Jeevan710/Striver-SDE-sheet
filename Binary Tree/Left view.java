class Tree
{
    void left(Node root,ArrayList<Integer> res,int level)
    {
        if(root==null)
        {
            return;
        }
        if(res.size()<level)
        {
            res.add(root.data);
        }
        left(root.left,res,level+1);
        left(root.right,res,level+1);
    }
    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> res=new ArrayList<>();
        left(root,res,1);
        return res;
    }
}