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
        LinkedList<TreeLinkNode> current = new LinkedList<TreeLinkNode>();
        current.add(root);
        while(!current.isEmpty()){
            LinkedList<TreeLinkNode> parent = current;
            current = new LinkedList<TreeLinkNode>();
            TreeLinkNode node = parent.pollFirst();

            while(!parent.isEmpty()){
                if(node.left!=null) current.add(node.left);
                if(node.right!=null) current.add(node.right);
                node.next = parent.peek();
                node = parent.pollFirst();
            }
            node.next = null;
            if(node.left!=null) current.add(node.left);
            if(node.right!=null) current.add(node.right);
 
            
        }
  
    }
}
