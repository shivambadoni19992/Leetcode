/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {

    public Node connect(Node root) {
        Node head = root;
        if (root == null) return null;
        Queue<Node> q = new LinkedList<>();
        q.add(head);
        while (!q.isEmpty()) {
            int n = q.size();
            Node prev = null;
            for (int i = 0; i < n; i++) {
                Node a = q.poll();
                if (prev != null) {
                    prev.next = a;
                }
                prev = a;
                if (a.left != null) q.add(a.left);
                if (a.right != null) q.add(a.right);
            }
            prev.next = null;
        }
        return root;
    }
}
