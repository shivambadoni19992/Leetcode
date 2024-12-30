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
    List<Integer> list = new ArrayList<>();

    public void findInorder(TreeNode root) {
        if (root == null) return;
        findInorder(root.left);
        list.add(root.val);
        findInorder(root.right);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        findInorder(root);
        return list;
    }
}