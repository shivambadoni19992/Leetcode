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
    int a = -1;

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        if (a == -1) a = root.val;
        if (root.val != a) return false;
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }
}
