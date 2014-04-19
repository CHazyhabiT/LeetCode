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
        TreeLinkNode head = null; // the head node of the next level
        TreeLinkNode prev = null; // the previous node of the current node in the same level
        TreeLinkNode curr = root;
        while(curr!=null) {
            
            while(curr!=null) {
                if(curr.left!=null) {
                    if(prev==null) {
                        head = curr.left;
                    }else prev.next = curr.left;
                    prev = curr.left;
                }
                if(curr.right!=null) {
                    if(prev==null) {
                        head = curr.right;
                    }else prev.next = curr.right;
                    prev = curr.right;
                }
                curr = curr.next;
            }
            curr = head;
            head = null;
            prev = null;
            
            
            
            
        }
        
        
    }
}
