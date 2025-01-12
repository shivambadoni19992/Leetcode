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

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                TreeNode top = q.poll();
                max = Math.max(max, top.val);
                if (top.left != null) q.add(top.left);
                if (top.right != null) q.add(top.right);
            }
            ans.add(max);
        }
        return ans;
    }
}
