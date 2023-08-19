
public class Solution {
     public static Node mergeTwoLists(Node a, Node b) {
        if(a==null)
        {
            return b;
        }
        if(b==null)
        {
            return a;
        }
        Node temp = new Node(0);
        Node res = temp; 
        
        while(a != null && b != null) {
            if(a.data < b.data) {
                temp.child = a; 
                temp = temp.child; 
                a = a.child; 
            }
            else {
                temp.child = b;
                temp = temp.child; 
                b = b.child; 
            }
        }
        
        if(a != null) temp.child = a; 
        else temp.child = b;
        return res.child; 
    
    }
    public static Node flatten(Node root)
    {
       
            if (root == null || root.next == null) 
                return root; 
      
            Node l=root;
            Node temp=flatten(root.next);
            l.next=null;
            Node a=mergeTwoLists(l, temp);
            return a;
    }
    public static Node flattenLinkedList(Node head) {
        return flatten(head);
    }
}