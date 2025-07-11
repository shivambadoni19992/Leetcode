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
    List<List<Integer>> ans= new ArrayList<>();

    public void findSum(TreeNode root , int targetSum,List<Integer> path) {

        if(root == null) {
            return;
        }

        path.add(root.val);
        if (root.left == null && root.right == null && root.val == targetSum) {
            ans.add(new ArrayList<>(path));
        } else {
            findSum(root.left, targetSum - root.val, path);
            findSum(root.right, targetSum - root.val, path);
        }
        path.remove(path.size() - 1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        findSum(root,targetSum, new ArrayList<>());
        return ans;
    }
}