// Chester
// less than one pass
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

        if(p.val!=q.val) return false;
        boolean l = isSameTree(p.left, q.left);
        if(l==false) return false;
        boolean r = isSameTree(p.right, q.right);
        if(r==false) return false;

        return true;        
        
    }
}
