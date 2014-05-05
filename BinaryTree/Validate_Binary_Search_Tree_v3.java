// Chester

// range search
// this time it will handle nodes with MIN_VALUE, MAX_VALUE
// by setting a flag to mark where we have meet such node
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
	// initial: isMinMeet = false, isMaxMeet = false
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE, false, false);
    }
    
    private boolean isValidBST(TreeNode node, int min, int max, boolean isMinMeet, boolean isMaxMeet) {
        if(node==null) return true;
	// can only meet MIN_VALUE only once
	// and currently node.val should in the range of [min, max]
        if(node.val==Integer.MIN_VALUE&&node.val==min&&!isMinMeet) {
            isMinMeet = true;
            if(node.left!=null) return false;
            return isValidBST(node.right, node.val, max, isMinMeet, isMaxMeet);
            
        }
        if(node.val==Integer.MAX_VALUE&&node.val==max&&!isMaxMeet) {
            isMaxMeet = true;
            if(node.right!=null) return false;
            return isValidBST(node.left, min, node.val, isMinMeet, isMaxMeet);
        }
        
        
        if(node.val>min&&node.val<max) {
            return isValidBST(node.left, min, node.val, isMinMeet, isMaxMeet) 
                && isValidBST(node.right, node.val, max, isMinMeet, isMaxMeet);
        }else return false;
        
        
    }
    
    
    

}
