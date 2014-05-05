// Chester

// BST in inOrder trasversal will be an ascending sequence
// BST should not contain duplicates

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
    public boolean isValidBST(TreeNode root) {
        //if(root==null) return false;
        ArrayList<Integer> inOrderSeq = new ArrayList<Integer>();
        inOrderTraverse(root, inOrderSeq);
        for(int i=0;i<inOrderSeq.size()-1;++i) {
            if(inOrderSeq.get(i)>=inOrderSeq.get(i+1))
                return false;
        }
        return true;
        
    }
    
    private void inOrderTraverse(TreeNode node, ArrayList<Integer> seq) {
        if(node==null) return;
        inOrderTraverse(node.left, seq);
        seq.add(node.val);
        inOrderTraverse(node.right, seq);
        
        
    }
}
