// Chester

// range search
// this will be less than O(n), worst case is O(n)

// assumption:
// the binary tree cannot contain a node with Integer.MIN_VALUE or Integer.MAX_VALUE

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
    public boolean isValidBST(TreeNode root) {
        //if(root==null) return false;
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode node, int min, int max) {
        if(node==null) return true;
        if(node.val>min&&node.val<max) {
            return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
        }else return false;
        
        
    }
    
    
    

}

