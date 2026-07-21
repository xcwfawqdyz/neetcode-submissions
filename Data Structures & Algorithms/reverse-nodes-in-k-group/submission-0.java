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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode curr=dummy;
        for(int i=0;i<k;i++){
            curr=curr.next;
            if(curr==null) return head;
        }
        ListNode newHead=curr.next;

        ListNode pre=null;
        curr=head;
        while(curr!=newHead){
            ListNode tmp=curr.next;
            curr.next=pre;
            pre=curr;
            curr=tmp;
        }
        head.next=reverseKGroup(newHead,k);

        return pre;

    }
}
