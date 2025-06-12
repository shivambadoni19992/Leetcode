/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    Map<TreeNode,TreeNode> parent = new HashMap<>();
    Set<TreeNode> vis = new HashSet<>();
    List<Integer> ans = new ArrayList<>();

    public void makeParent(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            if(curr.left != null){
                parent.put(curr.left,curr);
                q.add(curr.left);
            }
            if(curr.right != null) {
                parent.put(curr.right , curr);
                q.add(curr.right);
            }
        }
    }

    public void bfsWithTarget(TreeNode target, int k) {
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        vis.add(target);
        while(!queue.isEmpty()) {
            int n = queue.size();
            for(int i = 0;i < n; i++){
                TreeNode curr = queue.poll();
                if(level != k) {
                    if(curr.left !=null && !vis.contains(curr.left)){
                        queue.add(curr.left);
                        vis.add(curr.left);
                    }
                    if(curr.right !=null && !vis.contains(curr.right)){
                        queue.add(curr.right);
                        vis.add(curr.right);
                    }
                    if(parent.containsKey(curr) && !vis.contains(parent.get(curr))){
                        queue.add(parent.get(curr));
                        vis.add(parent.get(curr));
                    }
                } else {
                    ans.add(curr.val);
                }
            }
            level++;
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        makeParent(root);

        bfsWithTarget(target,k);

        return ans;
    }
}

// 3 : null
// 5 : 3
// 1 3
// 6 : 5
// 2 : 5
// 0 : 1
// 8 : 1
// 7 : 2
// 4 : 2  
// 5
// 6 2 3
// 1 7 4