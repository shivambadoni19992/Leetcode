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
    public int getSize(ListNode head){
        ListNode temp = head;
        int size = 0;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        return size;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0){
            return head;
        }
        int size = getSize(head);
        int n = k % size;
        if(n == 0){
            return head;
        }
        ListNode lastNode = get(size-1, head);
        ListNode temp1 = get(size - n - 1, head);
        ListNode temp2 = temp1.next;
        temp1.next = null;
        lastNode.next = head;
        head = temp2;
        return head;
    }
    public ListNode get(int index, ListNode head){
        ListNode node = head;
        for(int i = 0; i < index; i++){
            node = node.next;
        }
        return node;
    }
}