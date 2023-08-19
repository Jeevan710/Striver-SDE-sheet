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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null)
        {
            return head;
        }
        ListNode temp=head;
        int len=1;
        while(temp.next!=null)
        {
            len++;
            temp=temp.next;
        }
        k=k%len;
        k=len-k;

        ListNode a=head;
        while(k!=1){
            k--;
            a=a.next;
        }
        temp.next=head;
        head=a.next;
        a.next=null;
        return head;

    }
}