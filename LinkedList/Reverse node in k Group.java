/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverse(ListNode head,int k)
    {
        if(head.next==null || k==1)
        {
            return head;
        }
        ListNode temp=reverse(head.next,k-1);
        head.next.next=head;
        head.next=null;
        return temp;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null)
        {
            return head;
        }
        ListNode dummy=head;
        ListNode temp;
        int x=0;
        while(dummy!=null && x!=k)
        {
            dummy=dummy.next;
            x++;
        }
        if(x==k)
        {
            temp=reverse(head,k);
            head.next=reverseKGroup(dummy,k);
            return temp;
        }
        return head;
    }
}