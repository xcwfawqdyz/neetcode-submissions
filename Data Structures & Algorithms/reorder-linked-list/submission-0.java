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
    public void reorderList(ListNode head) {
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode second=slow.next;
        slow.next=null;
        ListNode pre=null;
        while(second!=null){
            ListNode post=second.next;
            second.next=pre;
            pre=second;
            second=post;
        }
        second=pre;
        ListNode first=head;
        while(second!=null){
            ListNode post1=first.next;
            ListNode post2=second.next;

            first.next=second;
            second.next=post1;

            second=post2;
            first=post1;
        }
        
    }
}
