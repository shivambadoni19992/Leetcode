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

    int c = 0;

    public void findTotal(TreeNode root, int target, Map<Long,Integer> sum, long s){
        if(root == null) return;

        s = s + root.val;
        c += sum.getOrDefault(s - target, 0);
        sum.put(s, sum.getOrDefault(s, 0) + 1);
        findTotal(root.left, target , sum, s);
        findTotal(root.right, target , sum, s);
        sum.put(s, sum.get(s) - 1);
        if (sum.get(s) == 0) sum.remove(s);

        
    }
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> sum = new HashMap<>();
        sum.put(0L, 1);
        findTotal(root, targetSum , sum, 0L);
        return c;
    }
}