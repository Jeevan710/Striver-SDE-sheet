/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)
        {
            return null;
        }
        Node temp=head;
        while(temp!=null)
        {
            Node newNode=new Node(temp.val);
            newNode.next=temp.next;
            temp.next=newNode;
            temp=temp.next.next;
        }
        temp=head;
        while(temp!=null)
        {
            if(temp.random!=null)
            {
                temp.next.random=temp.random.next;
            }
            temp=temp.next.next;
        }
        Node headCopy=head.next;
        Node slow=head;
        Node fast=headCopy;
        while(fast.next!=null)
        {
            slow.next=fast.next;
            fast.next=fast.next.next;
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=null;
        return headCopy;
    }
}