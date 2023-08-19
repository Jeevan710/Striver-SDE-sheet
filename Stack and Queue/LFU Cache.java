class Node
{
    int key;
    int value;
    int count;
    
    Node(int key,int value,int count)
    {
        this.key=key;
        this.value=value;
        this.count=count;
    }
}

class LFUCache {
    int minC;
    int capacity;
    Map<Integer,Node> m;
    Map<Integer,LinkedHashSet<Node>> mNode;
    public LFUCache(int capacity) {
        this.capacity=capacity;
        minC=1;
        m=new HashMap<>();
        mNode=new HashMap<>();
    }
    
    public int get(int key) {
       if(!m.containsKey(key))
       {
           return -1;
       }
       Node cur=m.get(key);
       mNode.get(cur.count).remove(cur);
       if(cur.count==minC && mNode.get(cur.count).size()==0)
       {
           minC++;
       }
       cur.count++;
       if(!mNode.containsKey(cur.count))
       {
           mNode.put(cur.count,new LinkedHashSet<>());
       }
       mNode.get(cur.count).add(cur);
       return m.get(key).value;
    }
    
    public void put(int key, int value) {
        if(m.containsKey(key))
        {
            m.get(key).value=value;
            get(key);
            return;
        }
        if(m.size()>=capacity)
        {
            Node node=mNode.get(minC).iterator().next();
            mNode.get(minC).remove(node);
            m.remove(node.key);
        }
        minC=1;
        Node cur=new Node(key,value,minC);
        m.put(key,cur);
        if(!mNode.containsKey(cur.count))
        {
            mNode.put(cur.count,new LinkedHashSet<>());
        }
        mNode.get(cur.count).add(cur);
    }

}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */