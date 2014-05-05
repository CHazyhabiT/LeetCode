// Chester

//         1                        0 1 2 3 4 5 6 7 8
//       /   \             inorder: 4-8-2-9-5-1-6-3-7
//      2     3          postorder: 8-4-9-5-2-6-7-3-1   
//     / \   / \                    0 1 2 3 4 5 6 7 8
//    4  5  6  7
//    \  /
//    8 9

// the end element of the subsequence in postorder will be the root,
// the root element in inorder sequence will be used for partition,
// F(startIn, endIn, startPost, endPost) maintain the four pointers each time

// since the hashmap, O(n)

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 import java.util.HashMap;
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length<0&&inorder.length!=postorder.length) return null;
        HashMap<Integer, Integer> hmInorder = new HashMap<Integer, Integer>(inorder.length*2);
        HashMap<Integer, Integer> hmPostorder = new HashMap<Integer, Integer>(inorder.length*2);
        for(int i=0;i<inorder.length;++i) 
            hmInorder.put(inorder[i], i);
        TreeNode root = buildTree(inorder, postorder, hmInorder, 0, inorder.length-1, 0, inorder.length-1);
        return root;
    }
    
    private TreeNode buildTree(int[] inorder, int[] postorder, HashMap<Integer, Integer> hmInorder,
        int sIn, int eIn, int sPost, int ePost) {
        if(sIn>eIn) return null;
        if(sIn==eIn) return new TreeNode(postorder[ePost]);
        int value = postorder[ePost];
        TreeNode root = new TreeNode(value);
        int rootIndex = hmInorder.get(value);
        int leftLen = rootIndex - sIn;
        root.left = buildTree(inorder, postorder, hmInorder, sIn, rootIndex-1, sPost, sPost+leftLen-1);
        root.right = buildTree(inorder, postorder, hmInorder, rootIndex+1, eIn, sPost+leftLen, ePost-1);
        
        return root;
   
    }
    
}
