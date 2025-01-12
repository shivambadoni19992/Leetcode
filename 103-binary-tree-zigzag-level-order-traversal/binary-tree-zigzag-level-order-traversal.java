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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean flag = true;
        while (!q.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode head = q.poll();
                temp.add(head.val);
                if (head.left != null) q.add(head.left);
                if (head.right != null) q.add(head.right);
            }
            if(!flag) Collections.reverse(temp);
            ans.add(temp);
            flag = !flag;
        }
        return ans;
    }
}
