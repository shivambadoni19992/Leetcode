class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (true) {
            ListNode tail = prev;
            for (int i = 0; i < k && tail != null; i++) {
                tail = tail.next;
            }
            if (tail == null) break;

            ListNode nextGroup = tail.next;
            ListNode curr = prev.next, prevNode = nextGroup;

            while (curr != nextGroup) {
                ListNode tmp = curr.next;
                curr.next = prevNode;
                prevNode = curr;
                curr = tmp;
            }

            ListNode temp = prev.next;
            prev.next = tail;
            prev = temp;
        }
        return dummy.next;
    }
}
