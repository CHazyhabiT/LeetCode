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
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tuple = new ArrayList<Integer>();
        pathSum(root, sum, result, tuple);
        return result;
        
    }
    
    private void pathSum(TreeNode node, int sum, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> tuple) {
        if(node==null) return;
        ArrayList<Integer> newTuple = new ArrayList<Integer>(tuple);
        newTuple.add(node.val);
        if(node.left==null&&node.right==null) {
            int temp = 0;
            for(int value : newTuple) {
                temp += value;
            }
            if(temp==sum) result.add(newTuple);
        }
        pathSum(node.left, sum, result, newTuple);
        pathSum(node.right, sum, result, newTuple);
        
        
    }
}
