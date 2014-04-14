/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 import java.util.Stack;
 
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root==null) return result;
        Stack<ArrayList<Integer>> stack = new Stack<ArrayList<Integer>>();
        ArrayList<TreeNode> current = new ArrayList<TreeNode>();
        current.add(root);
        while(!current.isEmpty()){
            
            ArrayList<TreeNode> parent = current;
            current = new ArrayList<TreeNode>();
            ArrayList<Integer> values = new ArrayList<Integer>();
            for(TreeNode node : parent){
                int val = node.val;
                values.add(val);
                if(node.left!=null) current.add(node.left);
                if(node.right!=null) current.add(node.right);
                
                
            }
            stack.push(values);
            
        }
        while(!stack.empty()){
            ArrayList<Integer> temp = stack.pop();
            result.add(temp);
        }
        
        return result;
    }
}
