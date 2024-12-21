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
       
        ListNode prev = new ListNode(-1);
        prev.next = head;
        ListNode result = prev;
        ListNode curr = head;
        while(head!=null){
            if(n<=0){
                prev = curr;
                curr = curr.next;
            }
            n--;
            head = head.next;
        }
        prev.next = curr.next;

        return result.next;
    }
}