// Chester

// DFS
// visite the tree by proceeding deeper and deeper until it reaches the target level
// hint: write a function to visit a given node if the node is in the target level
// when trasverse a given level, complexity of visiting nodes will be 2^level,
// time = 1 + 2 + 2^ + ... + 2^lg(N-1) = O(N)


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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int height = height(root);
        for(int i=1;i<=height;++i) {
            ArrayList<Integer> ls = new ArrayList<Integer>();
            levelOrder(root, i, ls);
            result.add(ls);
        }
        return result;
    }
    
    // visit the node at given level, 
    private void levelOrder(TreeNode root, int level, ArrayList<Integer> list) {
        if(root==null) return;
        if(level==1) {
            list.add(root.val);
        }else {
            levelOrder(root.left, level-1, list);
            levelOrder(root.right, level-1, list);
        }
        
    }
    // obtain the height of the tree
    private int height(TreeNode node) {
        if(node==null) return 0;
        int L = height(node.left);
        int R = height(node.right);
        return L < R ? R+1 : L+1;
    }
    
    
}
