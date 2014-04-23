// Chester

// Obviously recursively solve the problem
// the key is how to define the method
// 	-- given a range from start to end
//	-- each time choose a number as root
// 	-- then construct all the possible left and right sub tree
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        if(n<=0) {
            result.add(null);
            return result;
        }
        result = generateTrees(1, n);
        return result;
        
    }
    
    // given a range, generate all the unique trees
    // base case is start == end
    private ArrayList<TreeNode> generateTrees(int start, int end) {
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        if(start==end) {
            result.add(new TreeNode(start));
            return result;
        }
        for(int i=start;i<=end;++i) {
            // TreeNode root = new TreeNode(i);
            int leftE = i-1;
            int rightS = i+1;
            ArrayList<TreeNode> leftSubTree = new ArrayList<TreeNode>();
            ArrayList<TreeNode> rightSubTree = new ArrayList<TreeNode>();
            if(leftE>=start)
                leftSubTree = generateTrees(start, leftE);
            if(rightS<=end)
                rightSubTree = generateTrees(rightS, end);
            
            // 
            int lenLST = leftSubTree.size();
            int lenRST = rightSubTree.size();
            if(lenLST==0) {
                if(lenRST==0) {
                    result.add(new TreeNode(i)); // each time generate a new node as the root of the tree
                }else {
                    for(TreeNode node : rightSubTree) {
                        TreeNode root = new TreeNode(i); // each time generate a new node as the root of the tree
                        root.right = node;
                        result.add(root);
                    }
                }
                
            }else {
                if(lenRST==0) {
                    for(TreeNode node : leftSubTree) {
                        TreeNode root = new TreeNode(i); // each time generate a new node as the root of the tree
                        root.left = node;
                        result.add(root);
                    }
                }else {
                    for(TreeNode lNode : leftSubTree) {
                        for(TreeNode rNode : rightSubTree) {
                            TreeNode root = new TreeNode(i); // each time generate a new node as the root of the tree
                            root.left = lNode;
                            root.right = rNode;
                            result.add(root);
                        }
                    }
                }
            }
        }
        
        return result;
        
        
    }
    
}
