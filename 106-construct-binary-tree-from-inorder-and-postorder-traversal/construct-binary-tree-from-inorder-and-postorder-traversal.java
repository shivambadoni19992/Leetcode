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

    TreeNode build(int left, int right, int []postorder, int leftIn, int rightIn, int []inorder, Map<Integer, Integer> map) {
        if(left > right || leftIn > rightIn) return null;

        int curr = postorder[right];

        TreeNode root = new TreeNode(curr);
        int inorderPos = map.get(curr);
        int leftSize = inorderPos - leftIn;

        root.left = build(left, left + leftSize - 1, postorder, leftIn , inorderPos - 1, inorder, map);
        root.right = build(left + leftSize, right - 1, postorder, inorderPos + 1, rightIn, inorder, map);
        return root;

    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        Map<Integer, Integer> map = new HashMap<>();
        int n = inorder.length;
        for(int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        int left = 0; 
        int leftIn = 0;
        int right = n - 1;
        int rightIn = n - 1;
        return build(left, right, postorder, leftIn, rightIn, inorder, map);
        
    }
}