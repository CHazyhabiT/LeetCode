// Chester

// ArrayList extends List;
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
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        preorderTraversal(root, result);
        return result;
        
    }
    
    private void preorderTraversal(TreeNode node, ArrayList<Integer> result) {
        if(node==null) return;
        result.add(node.val);
        preorderTraversal(node.left, result);
        preorderTraversal(node.right, result);
    }
}
