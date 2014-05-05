// Chester

// level order traversal to get element of each line in order 
// use a tag to mark where this line should be reversed

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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root==null) return result;
        ArrayList<TreeNode> parent = new ArrayList<TreeNode>();
        parent.add(root);
        int mark = -1;
        while(!parent.isEmpty()) {
            ArrayList<TreeNode> current = parent;
            parent = new ArrayList<TreeNode>();
            ArrayList<Integer> line = new ArrayList<Integer>();
            for(TreeNode node : current) {
                line.add(node.val);
                if(node.left!=null) parent.add(node.left);
                if(node.right!=null) parent.add(node.right);
                
            }
            if(mark==-1) result.add(line);
            else {
                ArrayList<Integer> reverseLine = new ArrayList<Integer>();
                for(int i=line.size()-1;i>=0;--i)
                    reverseLine.add(line.get(i));
                result.add(reverseLine);
            }
            mark *= -1;
        }
        return result;
        
    }
}
