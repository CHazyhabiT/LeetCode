/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
 import java.util.ArrayList;
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null) return;
        ArrayList<TreeLinkNode> parent = new ArrayList<TreeLinkNode>();
        parent.add(root);
        while(!parent.isEmpty()) {
            ArrayList<TreeLinkNode> current = parent;
            parent = new ArrayList<TreeLinkNode>();
            int len = current.size();
            for(int i=0;i<len-1;++i) {
                TreeLinkNode node = current.get(i);
                node.next = current.get(i+1);
                if(node.left!=null) parent.add(node.left);
                if(node.right!=null) parent.add(node.right);
            }
            TreeLinkNode node = current.get(len-1);
            node.next = null;
            if(node.left!=null) parent.add(node.left);
            if(node.right!=null) parent.add(node.right);
        }
        
    }
}
