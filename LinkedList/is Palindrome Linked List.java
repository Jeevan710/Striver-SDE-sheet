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
    public ListNode reverse(ListNode head)
    {
        if(head.next==null)
        {
            return head;
        }
        ListNode temp=reverse(head.next);
        head.next.next=head;
        head.next=null;
        return temp;
    }
    public boolean isPalindrome(ListNode head) {
        if(head!=null && head.next==null)
        {
            return true;
        }
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        if(fast!=null)
        {
            slow=slow.next;
        }
        fast=head;
        slow=reverse(slow);
        while(fast!=null)
        {
            if(slow==null)
            {
                return true;
            }
            if(slow.val!=fast.val)
            {
                return false;
            }
            slow=slow.next;
            fast=fast.next;
        }
        return true;
    }
}