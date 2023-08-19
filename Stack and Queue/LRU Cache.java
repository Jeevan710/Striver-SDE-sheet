class DoublyLinked
{
    int key;
    int value;
    DoublyLinked next;
    DoublyLinked prev;
    
    DoublyLinked(int key,int value)
    {
        this.key=key;
        this.value=value;
    }
}

class LRUCache {
    DoublyLinked head = new DoublyLinked(0, 0), tail = new DoublyLinked(0, 0);
    Map < Integer, DoublyLinked > map = new HashMap();
    int capacity;

    public LRUCache(int _capacity) {
        capacity = _capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key))
        {
            DoublyLinked node=map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        else
        {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            remove(map.get(key));
        }
        if(map.size()==capacity)
        {
            remove(tail.prev);
        }
        insert(new DoublyLinked(key,value));
    }

    private void remove(DoublyLinked node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(DoublyLinked node) {
        map.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */