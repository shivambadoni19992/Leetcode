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
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) {
            return ans;
        }
        queue.add(root);
        
        boolean flag = true;
        while(!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int n = queue.size();
            for(int i =0;i<n;i++) {
                TreeNode a =queue.poll();
                list.add(a.val);
                if(a.left != null) queue.add(a.left);
                if(a.right != null) queue.add(a.right);
            }
            if(!flag) Collections.reverse(list);
            ans.add(list);
            flag = !flag;
        }
        return ans;
    }
}