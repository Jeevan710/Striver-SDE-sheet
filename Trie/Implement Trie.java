class Node{
    Node arr[]=new Node[26];
    boolean isWord=false;
}
class Trie {
    Node root;
    public Trie() {
        root=new Node();
    }
    
    public void insert(String word) {
        Node temp=root;
        for(char c:word.toCharArray())
        {
            int ind=c-'a';
            if(temp.arr[ind]==null)
            {
                temp.arr[ind]=new Node();
            }
            temp=temp.arr[ind];
        }
        temp.isWord=true;
    }
    
    public boolean search(String word) {
        Node temp=root;
        for(char c:word.toCharArray())
        {
            int ind=c-'a';
            if(temp.arr[ind]!=null)
            {
                temp=temp.arr[ind];
            }
            else
            {
                return false;
            }
        }
        if(temp.isWord==true)
        {
            return true;
        }
        return false;
    }
    
    public boolean startsWith(String prefix) {
        Node temp=root;
        for(char c:prefix.toCharArray())
        {
            int ind=c-'a';
            if(temp.arr[ind]==null)
            {
                return false;
            }
            temp=temp.arr[ind];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */