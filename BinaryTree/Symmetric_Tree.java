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
 import java.util.ArrayList;
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> al = new ArrayList<Integer>();
        queue.add(root);
        while(!queue.isEmpty()){
            LinkedList<TreeNode> current = queue;
            queue = new LinkedList<TreeNode>();
            al.clear();
            while(!current.isEmpty()){
                TreeNode node = current.poll();
                if(node.left!=null){
                    al.add(node.left.val);
                    queue.add(node.left);
                }
                else al.add(Integer.MAX_VALUE);
                if(node.right!=null){
                    al.add(node.right.val);
                    queue.add(node.right);
                } 
                else al.add(Integer.MAX_VALUE);
            }
            int len = al.size();
            for(int i=0;i<len/2;++i){
            	int a = al.get(i);
            	int b = al.get(len-1-i);
//                if((int)al.get(i)!=(int)al.get(len-1-i)) return false;
                if(a!=b) return false;
                
            }
            
            
            
        }
        
        
        return true;
        
        
        
    }
}
