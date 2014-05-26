// Chester

// standard iteration: Stack
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
        while(node!=null||!stack.empty()){
            while(node!=null) {
                al.add(node.val);
                stack.push(node);
                node = node.left;
            }
            if(!stack.empty()) {
                node = stack.pop();
                node = node.right;
            }
        }
        return al;
    }
    

    
    
    
}
