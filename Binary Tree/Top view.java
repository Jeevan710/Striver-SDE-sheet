class Pair
{
    Node node;
    int hd;
    Pair(Node node,int hd)
    {
        this.node=node;
        this.hd=hd;
    }
}
class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        ArrayList<Integer> res=new ArrayList<>();
        if(root==null)
        {
            return res;
        }
        Map<Integer,Integer> map=new TreeMap<>();
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0));
        while(q.isEmpty()==false)
        {
            Pair temp=q.peek();
            q.remove();
            int hd=temp.hd;
            Node t=temp.node;
            if(map.get(hd)==null)
            {
                map.put(hd,t.data);
            }
            if(t.left!=null)
            {
                q.add(new Pair(t.left,hd-1));
            }
            if(t.right!=null)
            {
                q.add(new Pair(t.right,hd+1));
            }
        }
        for(Map.Entry<Integer,Integer> m:map.entrySet())
        {
            res.add(m.getValue());
        }
        return res;
        
    }
}