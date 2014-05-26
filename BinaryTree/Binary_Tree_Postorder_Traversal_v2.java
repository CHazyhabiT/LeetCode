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
        Stack<TreeNode> L = new Stack<TreeNode>();
        Stack<TreeNode> R = new Stack<TreeNode>();
        TreeNode node = root;
        TreeNode right;
        do{
            while(node!=null) {
                right = node.right;
                L.push(node);
                R.push(right);
                node = node.left;
            }
            node = L.pop();
            right = R.pop();
            if(right==null) {
                result.add(node.val);
                node = null;
            }
            else {
                L.push(node);
                R.push(null);
                node = right;
            }
            
        }while(!L.empty()||!R.empty());
        
        return result;
    }
    
    
}
