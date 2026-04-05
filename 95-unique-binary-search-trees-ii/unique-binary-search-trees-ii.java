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

    List<TreeNode> gen(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if(start > end) {
            res.add(null);
        } else {
            for(int i = start; i <= end; i++) {
                List<TreeNode> left = gen(start, i - 1);
                List<TreeNode> right = gen(i + 1, end);

                for(TreeNode r : right) {
                    for(TreeNode l : left) {
                        TreeNode curr = new TreeNode(i);
                        curr.left = l;
                        curr.right = r;
                        res.add(curr);
                    }
                }
            }

        }
        return res;


    }
    public List<TreeNode> generateTrees(int n) {

        return gen(1, n);
        
    }
}