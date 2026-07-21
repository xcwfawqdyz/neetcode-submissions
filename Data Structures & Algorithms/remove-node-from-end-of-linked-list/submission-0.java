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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode();
        dummy.next=head;
        ListNode slow=dummy,fast=dummy;
        for(int i=n;i>0;i--){
            fast=fast.next;
        }
        ListNode pre=slow;
        while(fast!=null){
            fast=fast.next;
            pre=slow;
            slow=slow.next; 
        }
        pre.next=slow.next;
        return dummy.next;
    }
}
