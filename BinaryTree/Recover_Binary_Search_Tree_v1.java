// Chester

// 1. inOrder traversal
// 2. recover

// O(n) time and space

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
    public void recoverTree(TreeNode root) {
        ArrayList<TreeNode> inOrder = new ArrayList<TreeNode>();
        inOrderTraverse(root, inOrder);
        recoverTree(inOrder);
    }
    
    private void inOrderTraverse(TreeNode node, ArrayList<TreeNode> inOrder) {
        if(node==null) return;
        inOrderTraverse(node.left, inOrder);
        inOrder.add(node);
        inOrderTraverse(node.right, inOrder);
    }
    
    // test cases:
    // 1.   1 2 4 3 5 6 7
    // 2.   1 2 5 4 3 6 7
    // 3.   1 6 3 4 5 2 7
    // 4.   2 1 
    // 5.   1 2 6 5 5 7
    // 6.   1 2 5 6 5 7
    
    private void recoverTree(ArrayList<TreeNode> inOrder) {
        if(inOrder.size()<=1) return;
        int len = inOrder.size();
        TreeNode wrongNode1 = null;
        TreeNode wrongNode2 = null;
        int i = 0;
        while(i<len-1) {
            TreeNode node1 = inOrder.get(i);
            TreeNode node2 = inOrder.get(i+1);
            if(node1.val>node2.val) {
                wrongNode1 = node1;
                ++i;
                break;
            }
            ++i;
        }
        int tempIndex = i;
        while(i<len-1) {
            TreeNode node1 = inOrder.get(i);
            TreeNode node2 = inOrder.get(i+1);
            if(node1.val>node2.val) {
                wrongNode2 = node2;
                ++i;
                break;
            }
            ++i;
        }
        if(wrongNode2==null) wrongNode2 = inOrder.get(tempIndex);
        
        int temp = wrongNode1.val;
        wrongNode1.val = wrongNode2.val;
        wrongNode2.val = temp;
   
    }
    
    
    
}
