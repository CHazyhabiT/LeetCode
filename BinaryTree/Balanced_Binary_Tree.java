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
    
    class Wrapper{
        boolean isBalanced;
        int height;
        Wrapper(){
            isBalanced = true;
            height = 0;
        }
        
        
    }
    
    
    public boolean isBalanced(TreeNode root) {
        Wrapper result = isBalancedHelper(root);
        return result.isBalanced;
        
    }
    
    private Wrapper isBalancedHelper(TreeNode node){
        Wrapper result = new Wrapper();
        if(node==null) return result;
        Wrapper lW = isBalancedHelper(node.left);
        Wrapper rW = isBalancedHelper(node.right);
        if(!lW.isBalanced||!rW.isBalanced){
            result.isBalanced = false;
            return result;
        }
        if(Math.abs(lW.height-rW.height)<=1){
            result.height = Math.max(lW.height, rW.height) + 1;
            
        }else result.isBalanced = false;
        
        return result;
  
    }
    
}
