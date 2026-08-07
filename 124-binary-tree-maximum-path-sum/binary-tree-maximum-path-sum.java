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


    int maxSum = Integer.MIN_VALUE;

    int dfs(TreeNode root) {
        if(root == null) return 0;

        int leftSubTree = dfs(root.left);

        int rightSubTree = dfs(root.right);
        leftSubTree = (leftSubTree < 0 ? 0 : leftSubTree);
        rightSubTree = (rightSubTree < 0 ? 0 : rightSubTree);
        int sum =  root.val + leftSubTree + rightSubTree;
        maxSum = Math.max(sum, maxSum);

        return root.val + Math.max(leftSubTree, rightSubTree);

    }
    public int maxPathSum(TreeNode root) {
        
        dfs(root);
        return maxSum;
    }
}