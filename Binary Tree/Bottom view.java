class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        ArrayList<Integer> res=new ArrayList<>();
        if(root==null)
        {
            return res;
        }
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Node> q=new LinkedList<>();
        root.hd=0;
        q.add(root);
        while(q.isEmpty()==false)
        {
            Node temp=q.peek();
            int hd=temp.hd;
            map.put(hd,temp.data);
            q.remove();
            if(temp.left!=null)
            {
                temp.left.hd=hd-1;
                q.add(temp.left);
            }
            if(temp.right!=null)
            {
                temp.right.hd=hd+1;
                q.add(temp.right);
            }
        }
        for(Map.Entry<Integer,Integer> m:map.entrySet())
        {
            res.add(m.getValue());
        }
        return res;
    }
}