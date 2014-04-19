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
 * pre-order traversal
 */
 
public class Solution {
    public int sumNumbers(TreeNode root) {
        ArrayList<Integer> leaves = new ArrayList<Integer>();
        sumNumbers(root, leaves, 0);
        int sum = 0;
        for(int val : leaves) {
            sum += val;
        }
        return sum;

    }
    
    private void sumNumbers(TreeNode node, ArrayList<Integer> leaves, int pre) {
        if(node==null) return;
        int value = pre*10 + node.val;
        if(node.left==null&&node.right==null) 
            leaves.add(value);
        sumNumbers(node.left, leaves, value);
        sumNumbers(node.right, leaves, value);
        
        
        
        
    }
    

}
