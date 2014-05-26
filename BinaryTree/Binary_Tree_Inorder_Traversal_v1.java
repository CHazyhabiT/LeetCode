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
 import java.util.ArrayList;
 import java.util.Stack;
public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        if(root==null) return al;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while(node!=null||!stack.empty()) {
            while(node!=null) {
                stack.push(node);
                node = node.left;
            }
            if(!stack.empty()) {
                node = stack.pop();
                al.add(node.val);
                node = node.right;
            }
        }
        return al;
        

    }
}
