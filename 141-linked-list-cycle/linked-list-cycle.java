/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    public boolean hasCycle(ListNode head) {
        ListNode cycle = head;
        while (cycle != null && cycle.next != null) {
            cycle = cycle.next.next;
            head = head.next;
            if (cycle == head) return true;
        }
        return false;
    }
}
