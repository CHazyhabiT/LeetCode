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
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        int i = minDepth(root.left);
        int j = minDepth(root.right);
        
        if(i == 0 || j == 0)
            return 1+i+j;
        return Math.min(i,j) + 1;
        
    }
}
