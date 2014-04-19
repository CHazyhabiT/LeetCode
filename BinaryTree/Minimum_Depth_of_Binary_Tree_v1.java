/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 import java.util.ArrayList;
public class Solution {
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        int depth = 0;
        ArrayList<TreeNode> parent = new ArrayList<TreeNode>();
        parent.add(root);
        while(!parent.isEmpty()) {
            ++depth;
            ArrayList<TreeNode> current = parent;
            parent = new ArrayList<TreeNode>();
            for(TreeNode node : current) {
                if(node.left==null&&node.right==null)
                    return depth;
                if(node.left!=null) parent.add(node.left);
                if(node.right!=null) parent.add(node.right);
            }
            
        }
        return depth;
        
    }
}
