// Chester

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
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root==null) return result;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
	// pre used to record the node already being stored
        TreeNode pre = null;
        while(node!=null||!stack.empty()) {
            while(node!=null) {
                stack.push(node);
                node = node.left;
            }
            
            if(!stack.empty()) {
                node = stack.peek().right;
                if(node==null||node==pre) {
                    node = stack.pop();
                    result.add(node.val);
                    pre = node;
                    node = null;
                }
            }
            
        }
        return result;
        
    }
    
    
}
