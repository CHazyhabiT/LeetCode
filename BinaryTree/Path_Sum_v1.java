/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        int value = root.val;
        return hasPathSum(root, value, sum);
        
    }
    
    public boolean hasPathSum(TreeNode node, int value, int sum) {
        if(node.left==null&&node.right==null) {
            if(value==sum) return true;
            else return false;
            
        }
        boolean L = false;
        boolean R = false;
        if(node.left!=null) {
            int newValue = node.left.val + value;
            L = hasPathSum(node.left, newValue, sum);
        }
        if(node.right!=null) {
            int newValue = node.right.val +value;
            R = hasPathSum(node.right, newValue, sum);
        }
        return L||R;
        
        
        
    }
    
}
