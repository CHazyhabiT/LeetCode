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
 import java.util.Stack;
public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        if(root==null) return al;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while(node!=null) {
            while(node!=null) {
                if(node.right!=null)
                    stack.push(node.right);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            while(!stack.empty()&&node.right==null){
                al.add(node.val);
                node = stack.pop();
            }
            al.add(node.val);
            if(!stack.empty())
                node = stack.pop();
            else 
                node = null;
        }
        return al;

    }
}
