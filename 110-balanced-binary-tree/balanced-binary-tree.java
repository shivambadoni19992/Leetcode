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

    public int findHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = findHeight(root.left);
        int right = findHeight(root.right);
        if(right == -1 || left == -1) return -1;
        if(Math.abs(right - left) > 1) return -1;
        return 1+ Math.max(left,right);
    }
    public boolean isBalanced(TreeNode root) {
        int x = findHeight(root);
        if(x ==-1) return false;
        return true;
    }
}