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
        if(root==null) return result;
        ArrayList<Integer> tuple = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        TreeNode pre = null; // used to record the previous node visited
        while(node!=null||!stack.empty()) {
            while(node!=null) {
                stack.push(node);
                tuple.add(node.val);
                node = node.left;
                
            }
            // only post-order is feasible if you want to implement in iterately way (I guess)
            if(!stack.empty()) {
                node = stack.peek();
                if(node.right==null||node.right==pre) {
                    if(node.left==null&&node.right==null) {
                        int check = 0;
                        for(int ele : tuple) {
                            check += ele;
                        }
                        if(check==sum) {
                            result.add(new ArrayList<Integer>(tuple));
                        }
                    }
                    stack.pop();
                    tuple.remove(tuple.size()-1);
                    pre = node;
                    node = null;
                }else {
                    node = node.right;
                }
 
            }

        }

        return result;
        
    }
    

}
