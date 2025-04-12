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

    public ListNode deleteDuplicates(ListNode head) {
        ListNode ans = new ListNode(-1000);
        ListNode prev = ans;
        while (head != null) {
            while (head != null && head.val == prev.val) {
                head = head.next;
            }
            prev.next = head;
            prev = prev.next;
            if (head != null) {
                head = head.next;
            }
        }
        return ans.next;
    }
}
