/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 /*
 * recursively, f(node, value) is the sum of the tree based on this node
 */
 
public class Solution {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);

    }
    
    private int sumNumbers(TreeNode node, int value) {
        if(node==null) return 0;
        int newValue = value*10 + node.val;
        if(node.left==null&&node.right==null) {
            return newValue;
        }else return sumNumbers(node.left, newValue) + sumNumbers(node.right, newValue);
        
        
    }
}
