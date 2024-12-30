/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        int levelX = -1, levelY = -1;
        int level = 0;
        TreeNode parentX = null, parentY = null;
        while (!queue.isEmpty()) {
            int n = queue.size();
            // For each level
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                    if (node.left.val == x) {
                        parentX = node;
                        levelX = level + 1;
                    }
                    if (node.left.val == y) {
                        parentY = node;
                        levelY = level + 1;
                    }
                }
                
                if (node.right != null) {
                    queue.add(node.right);
                    if (node.right.val == x) {
                        parentX = node;
                        levelX = level + 1;
                    }
                    if (node.right.val == y) {
                        parentY = node;
                        levelY = level + 1;
                    }
                }
            }
            if (parentX != null && parentY != null) return (levelX == levelY) && (parentX != parentY);
            level++;
        }
        return false;
    }
}
