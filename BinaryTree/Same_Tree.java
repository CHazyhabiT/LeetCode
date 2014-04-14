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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null) return true;
        if(p==null||q==null) return false;
        
        boolean L = isSameTree(p.left, q.left);
        if(L==false) return false;
        boolean R = isSameTree(p.right, q.right);
        if(R==false) return false;
        
        if(p.val==q.val) return true;
        else return false;
        
        
    }
}
