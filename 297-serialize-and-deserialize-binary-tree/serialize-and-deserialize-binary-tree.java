/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder ans = new StringBuilder();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {

            TreeNode curr = q.poll();
            if(curr == null) {
                ans.append("#,");
                continue;
            }
            ans.append(curr.val + ",");
            q.add(curr.left);
            q.add(curr.right);
        }
        return ans.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        String []d = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        if(d[0].equals("#")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(d[0]));
        q.add(root);
        int i = 1;
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            curr.left = d[i].equals("#") ? null : new TreeNode(Integer.parseInt(d[i]));
            i++;

            curr.right = d[i].equals("#") ? null : new TreeNode(Integer.parseInt(d[i]));
            i++;

            if(curr.left != null) q.add(curr.left);
            if(curr.right != null) q.add(curr.right);
        }

        return root;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));