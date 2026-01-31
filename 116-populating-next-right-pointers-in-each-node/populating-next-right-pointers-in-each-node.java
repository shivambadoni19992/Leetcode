class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node rightNode = null;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                curr.next = rightNode;
                rightNode = curr;
                if (curr.right != null) {
                    queue.add(curr.right);
                }
                if (curr.left != null) {
                    queue.add(curr.left);
                }
            }
        }
        return root;
    }
}