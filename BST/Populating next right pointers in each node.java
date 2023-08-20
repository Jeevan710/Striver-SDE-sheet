/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public void recurse(Node root)
    {
        if(root==null || root.left==null)
        {
            return ;
        }
        root.left.next=root.right;
        Node temp=root.left;
        while(temp.next!=null && temp.left!=null)
        {
            temp.right.next=temp.next.left;
            temp=temp.right;
        }

        recurse(root.left);
        recurse(root.right);

    }

    public Node connect(Node root) {
        recurse(root);
        return root;
    }
}