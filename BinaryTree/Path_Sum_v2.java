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
        Stack<TreeNode> sNode = new Stack<TreeNode>();
        Stack<Integer> sInt = new Stack<Integer>();
        TreeNode node = root;
        int value = 0;
        while(node!=null||!sNode.isEmpty()) {
            while(node!=null) {
                sNode.push(node);
                value += node.val;
                sInt.push(value);
                if(node.left==null&&node.right==null) {
                    if(value==sum) return true;
                }
                node = node.left;

            }
            
            if(!sNode.isEmpty()) {
                node = sNode.pop();
                value = sInt.pop();
                node = node.right;
            }
            
        }
        return false;
        
        
        
    }
    

    
}
