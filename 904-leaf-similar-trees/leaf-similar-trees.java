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
    ArrayList<Integer> list;
    public void addToList(TreeNode root){
        if(root==null) return;
        if(root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }
        addToList(root.left);
        addToList(root.right);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        list = new ArrayList<>();
        addToList(root1);
        ArrayList<Integer> list1 = new ArrayList<>(list);
        list = new ArrayList<>();
        addToList(root2);
        return list1.equals(list);
    }
}