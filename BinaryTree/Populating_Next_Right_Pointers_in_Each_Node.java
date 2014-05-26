// Chester

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
 import java.util.LinkedList;
 
public class Solution {
    public void connect(TreeLinkNode root) {
         if(root==null) return;
         ArrayList<TreeLinkNode> parent = new ArrayList<TreeLinkNode>();
         parent.add(root);
         while(!parent.isEmpty()) {
             ArrayList<TreeLinkNode> current = parent;
             parent = new ArrayList<TreeLinkNode>();
             for(int i=0;i<current.size();i++) {
                 TreeLinkNode node = current.get(i);
                 if(i!=current.size()-1) node.next = current.get(i+1); // in case nullPointerException
                 if(node.left!=null) parent.add(node.left);
                 if(node.right!=null) parent.add(node.right);
             
             }
         }
        
    }
}
