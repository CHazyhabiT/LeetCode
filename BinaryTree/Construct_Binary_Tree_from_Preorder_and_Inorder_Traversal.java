// Chester

//         1                        0 1 2 3 4 5 6 7 8
//       /   \            preorder: 1-2-4-8-5-9-3-6-7
//      2     3            inorder: 4-8-2-9-5-1-6-3-7
//     / \   / \                    0 1 2 3 4 5 6 7 8
//    4  5  6  7
//    \  /
//    8 9

// the start element of the subsequence in preorder will be the root,
// the root element in inorder sequence will be used for partition,
// F( startPre, endPre, startIn, endIn) maintain the four pointers each time

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0||preorder.length!=inorder.length) return null;
        int len = preorder.length;
        HashMap<Integer, Integer> hmPreorder = new HashMap<Integer, Integer>(len*2);
        HashMap<Integer, Integer> hmInorder = new HashMap<Integer, Integer>(len*2);
        for(int i=0;i<len;++i)
            hmInorder.put(inorder[i], i);
        return buildTree(preorder, inorder, hmInorder, 0, len-1, 0, len-1);
    }
    
    private TreeNode buildTree(int[] preorder, int[] inorder, HashMap<Integer, Integer> hmInorder, 
        int sPre, int ePre, int sIn, int eIn) {
        if(sPre>ePre) return null;
        if(sPre==ePre) return new TreeNode(preorder[sPre]);
        int value = preorder[sPre];
        TreeNode root = new TreeNode(value);
        int rootIndex = hmInorder.get(value);
        int leftLen = rootIndex - sIn;
        // int rightLen = eIn - rootIndex;
        root.left = buildTree(preorder, inorder, hmInorder, sPre+1, sPre+leftLen, sIn, rootIndex-1);
        root.right = buildTree(preorder, inorder, hmInorder, sPre+leftLen+1, ePre, rootIndex+1, eIn);
        return root;
    }
    
}
