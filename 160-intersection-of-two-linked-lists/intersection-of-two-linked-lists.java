/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int m = 0,n=0;
        ListNode dummyA = headA;
        while(dummyA!=null){
            dummyA = dummyA.next;
            m++;
        }
        ListNode dummyB = headB;
        while(dummyB!=null){
            dummyB = dummyB.next;
            n++;
        }
        dummyA = headA;
        dummyB = headB;
        if(m>n){
            while(m > n){
                dummyA = dummyA.next;
                m--;
            }
        } else{
            while(n > m){
                dummyB = dummyB.next;
                n--;
            }
        }
        while(dummyA !=null && dummyB != null){
            if(dummyA == dummyB) return dummyA;
            dummyA=dummyA.next;
            dummyB= dummyB.next;
        }
        return null;
    }
}