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
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        if(root==null) return al;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        stack.push(node);
        while(!stack.empty()) {
            node = stack.pop();
            al.add(node.val);
            if(node.right!=null)
                stack.push(node.right);
            if(node.left!=null)
                stack.push(node.left);
            
        }
        return al;
    }
    

    
    
    
}
