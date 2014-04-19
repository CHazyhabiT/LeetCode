// Chester

// BFS 
// visit the node level by level
// time O(N)
// space O(logN)


/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 import java.util.LinkedList;
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root==null) return result;
	// store the nodes in the previous level
        LinkedList<TreeNode> parent = new LinkedList<TreeNode>();
        parent.add(root);
        while(!parent.isEmpty()) {
            LinkedList<TreeNode> current = parent;
            parent = new LinkedList<TreeNode>();
            ArrayList<Integer> row = new ArrayList<Integer>();
            while(!current.isEmpty()) {
                TreeNode temp = current.poll();
                row.add(temp.val);
                if(temp.left!=null) parent.add(temp.left);
                if(temp.right!=null) parent.add(temp.right);
            }
            result.add(row);
            
  
        }
        return result;
        
        
    }
}
