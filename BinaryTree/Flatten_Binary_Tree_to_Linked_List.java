// Chester

// given a node, analyze every situation of its left and right child
// Binary Tree - a data structure constructed based on recursive way


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
    // given a node, flatten the tree based on a root of this node
    public void flatten(TreeNode root) {
        if(root==null) return;
        if(root.right==null) { // if node.right == null, directly change its right child pointing to its left
            root.right = root.left;
            root.left = null;
            flatten(root.right);
        }else { // if node.right != null
            if(root.left==null) 
		// if node.left == null, directly move the node to its right,
		// to flatten the right subtree
                flatten(root.right);
            else {
		// if both children != null
		// 1. first record its right child and the last node of its left subtree in advance
		// 2. change its right child pointing to its left
		// 3. flatten its pre-left subtree
		// 4. its left set to null
		// 5. its pre-right child pointed by the last node of its pre-left subtree in advance
		// 6. flatten its pre-right subtree
		TreeNode right = root.right; // 1
                TreeNode node = lastNode(root.left); // 1
                root.right = root.left; // 2
                flatten(root.left); // 3
                root.left = null; // 4
                node.right = right; // 5
                flatten(right); // 6
            }
        }
        
    }
    
    // find the last node of a tree with a given node as the root
    private TreeNode lastNode(TreeNode node) {
        if(node==null) return node;
        if(node.right!=null)
            return lastNode(node.right);
        else {
            if(node.left!=null)
                return lastNode(node.left);
            else return node;
        }
    }
}
