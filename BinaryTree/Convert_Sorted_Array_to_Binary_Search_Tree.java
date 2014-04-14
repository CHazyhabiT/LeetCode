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
    public TreeNode sortedArrayToBST(int[] num) {
        if(num.length<1) return null;
        TreeNode root = sortedArrayToBST(num, 0, num.length-1);
        return root;
        
    }
    
    private TreeNode sortedArrayToBST(int[] num, int i, int j){
        if(i>j) return null;
        int mid = (j+i)/2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = sortedArrayToBST(num, i, mid-1);
        node.right = sortedArrayToBST(num, mid+1, j);
        return node;
  
    }
    
    
    
}
