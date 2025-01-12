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
    int ans = 0;
    int c = 0;
    public void find(TreeNode root, int k) {
        if (root == null) return;
        find(root.left, k);
        c++;
        if (k == c) {
            ans = root.val;
            return;
        }
        find(root.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        find(root, k);
        return ans;
    }
}
