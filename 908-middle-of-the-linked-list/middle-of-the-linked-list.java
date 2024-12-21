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
    public ListNode middleNode(ListNode head) {
        if (head== null) return head;
        ListNode middleNode = head;
        while(head != null && head.next !=null){
            head = head.next.next;
            middleNode = middleNode.next;
        }
        return middleNode;
    }
}